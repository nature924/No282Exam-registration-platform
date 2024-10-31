
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
 * 教室
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/banji")
public class BanjiController {
    private static final Logger logger = LoggerFactory.getLogger(BanjiController.class);

    private static final String TABLE_NAME = "banji";

    @Autowired
    private BanjiService banjiService;


    @Autowired
    private TokenService tokenService;

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
    private XueshengKaoshifenpeiService xueshengKaoshifenpeiService;//考试分配
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
        PageUtils page = banjiService.queryPage(params);

        //字典表数据转换
        List<BanjiView> list =(List<BanjiView>)page.getList();
        for(BanjiView c:list){
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
        BanjiEntity banji = banjiService.selectById(id);
        if(banji !=null){
            //entity转view
            BanjiView view = new BanjiView();
            BeanUtils.copyProperties( banji , view );//把实体数据重构到view中
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
    public R save(@RequestBody BanjiEntity banji, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,banji:{}",this.getClass().getName(),banji.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<BanjiEntity> queryWrapper = new EntityWrapper<BanjiEntity>()
            .eq("banji_loudong", banji.getBanjiLoudong())
            .eq("banji_louceng", banji.getBanjiLouceng())
            .eq("banji_name", banji.getBanjiName())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        BanjiEntity banjiEntity = banjiService.selectOne(queryWrapper);
        if(banjiEntity==null){
            banji.setInsertTime(new Date());
            banji.setCreateTime(new Date());
            banjiService.insert(banji);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody BanjiEntity banji, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,banji:{}",this.getClass().getName(),banji.toString());
        BanjiEntity oldBanjiEntity = banjiService.selectById(banji.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");

            banjiService.updateById(banji);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<BanjiEntity> oldBanjiList =banjiService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        banjiService.deleteBatchIds(Arrays.asList(ids));

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
            List<BanjiEntity> banjiList = new ArrayList<>();//上传的东西
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
                            BanjiEntity banjiEntity = new BanjiEntity();
//                            banjiEntity.setBanjiUuidNumber(data.get(0));                    //教室编号 要改的
//                            banjiEntity.setBanjiLoudong(data.get(0));                    //楼栋 要改的
//                            banjiEntity.setBanjiLouceng(data.get(0));                    //楼层 要改的
//                            banjiEntity.setBanjiName(data.get(0));                    //教室名称 要改的
//                            banjiEntity.setBanjiContent("");//详情和图片
//                            banjiEntity.setInsertTime(date);//时间
//                            banjiEntity.setCreateTime(date);//时间
                            banjiList.add(banjiEntity);


                            //把要查询是否重复的字段放入map中
                                //教室编号
                                if(seachFields.containsKey("banjiUuidNumber")){
                                    List<String> banjiUuidNumber = seachFields.get("banjiUuidNumber");
                                    banjiUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> banjiUuidNumber = new ArrayList<>();
                                    banjiUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("banjiUuidNumber",banjiUuidNumber);
                                }
                        }

                        //查询是否重复
                         //教室编号
                        List<BanjiEntity> banjiEntities_banjiUuidNumber = banjiService.selectList(new EntityWrapper<BanjiEntity>().in("banji_uuid_number", seachFields.get("banjiUuidNumber")));
                        if(banjiEntities_banjiUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(BanjiEntity s:banjiEntities_banjiUuidNumber){
                                repeatFields.add(s.getBanjiUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [教室编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        banjiService.insertBatch(banjiList);
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

