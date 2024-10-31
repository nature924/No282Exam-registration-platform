
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 考试分配
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/xueshengKaoshifenpei")
public class XueshengKaoshifenpeiController {
    private static final Logger logger = LoggerFactory.getLogger(XueshengKaoshifenpeiController.class);

    private static final String TABLE_NAME = "xueshengKaoshifenpei";

    @Autowired
    private XueshengKaoshifenpeiService xueshengKaoshifenpeiService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private BanjiService banjiService;//教室
    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private GonggaoService gonggaoService;//公告
    @Autowired
    private KaoshiService kaoshiService;//考试
    @Autowired
    private KaoshiBaomingService kaoshiBaomingService;//监考报名
    @Autowired
    private LaoshiService laoshiService;//老师
    @Autowired
    private XueshengService xueshengService;//学生
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("学生".equals(role))
            params.put("xueshengId",request.getSession().getAttribute("userId"));
        else if("老师".equals(role))
            params.put("laoshiId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = xueshengKaoshifenpeiService.queryPage(params);

        //字典表数据转换
        List<XueshengKaoshifenpeiView> list =(List<XueshengKaoshifenpeiView>)page.getList();
        for(XueshengKaoshifenpeiView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        XueshengKaoshifenpeiEntity xueshengKaoshifenpei = xueshengKaoshifenpeiService.selectById(id);
        if(xueshengKaoshifenpei !=null){
            //entity转view
            XueshengKaoshifenpeiView view = new XueshengKaoshifenpeiView();
            BeanUtils.copyProperties( xueshengKaoshifenpei , view );//把实体数据重构到view中
            //级联表 考试
            //级联表
            KaoshiEntity kaoshi = kaoshiService.selectById(xueshengKaoshifenpei.getKaoshiId());
            if(kaoshi != null){
            BeanUtils.copyProperties( kaoshi , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "xueshengId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setKaoshiId(kaoshi.getId());
            }
            //级联表 教室
            //级联表
            BanjiEntity banji = banjiService.selectById(xueshengKaoshifenpei.getBanjiId());
            if(banji != null){
            BeanUtils.copyProperties( banji , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "xueshengId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setBanjiId(banji.getId());
            }
            //级联表 学生
            //级联表
            XueshengEntity xuesheng = xueshengService.selectById(xueshengKaoshifenpei.getXueshengId());
            if(xuesheng != null){
            BeanUtils.copyProperties( xuesheng , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "xueshengId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setXueshengId(xuesheng.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody XueshengKaoshifenpeiEntity xueshengKaoshifenpei, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,xueshengKaoshifenpei:{}",this.getClass().getName(),xueshengKaoshifenpei.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("学生".equals(role))
            xueshengKaoshifenpei.setXueshengId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<XueshengKaoshifenpeiEntity> queryWrapper = new EntityWrapper<XueshengKaoshifenpeiEntity>()
            .eq("kaoshi_id", xueshengKaoshifenpei.getKaoshiId())
            .eq("xuesheng_id", xueshengKaoshifenpei.getXueshengId())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XueshengKaoshifenpeiEntity xueshengKaoshifenpeiEntity = xueshengKaoshifenpeiService.selectOne(queryWrapper);
        if(xueshengKaoshifenpeiEntity==null){
            xueshengKaoshifenpei.setInsertTime(new Date());
            xueshengKaoshifenpei.setCreateTime(new Date());
            xueshengKaoshifenpeiService.insert(xueshengKaoshifenpei);
            return R.ok();
        }else {
            return R.error(511,"该考试该学生已经分配有考试教室和座位号");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody XueshengKaoshifenpeiEntity xueshengKaoshifenpei, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,xueshengKaoshifenpei:{}",this.getClass().getName(),xueshengKaoshifenpei.toString());
        XueshengKaoshifenpeiEntity oldXueshengKaoshifenpeiEntity = xueshengKaoshifenpeiService.selectById(xueshengKaoshifenpei.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("学生".equals(role))
//            xueshengKaoshifenpei.setXueshengId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

            xueshengKaoshifenpeiService.updateById(xueshengKaoshifenpei);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<XueshengKaoshifenpeiEntity> oldXueshengKaoshifenpeiList =xueshengKaoshifenpeiService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        xueshengKaoshifenpeiService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer xueshengId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<XueshengKaoshifenpeiEntity> xueshengKaoshifenpeiList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            XueshengKaoshifenpeiEntity xueshengKaoshifenpeiEntity = new XueshengKaoshifenpeiEntity();
//                            xueshengKaoshifenpeiEntity.setKaoshiId(Integer.valueOf(data.get(0)));   //考试 要改的
//                            xueshengKaoshifenpeiEntity.setBanjiId(Integer.valueOf(data.get(0)));   //教室 要改的
//                            xueshengKaoshifenpeiEntity.setXueshengId(Integer.valueOf(data.get(0)));   //学生 要改的
//                            xueshengKaoshifenpeiEntity.setXueshengKaoshifenpeiName(data.get(0));                    //座位号 要改的
//                            xueshengKaoshifenpeiEntity.setXueshengKaoshifenpeiContent("");//详情和图片
//                            xueshengKaoshifenpeiEntity.setInsertTime(date);//时间
//                            xueshengKaoshifenpeiEntity.setCreateTime(date);//时间
                            xueshengKaoshifenpeiList.add(xueshengKaoshifenpeiEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        xueshengKaoshifenpeiService.insertBatch(xueshengKaoshifenpeiList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }




}

