
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
 * 监考报名
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/kaoshiBaoming")
public class KaoshiBaomingController {
    private static final Logger logger = LoggerFactory.getLogger(KaoshiBaomingController.class);

    private static final String TABLE_NAME = "kaoshiBaoming";

    @Autowired
    private KaoshiBaomingService kaoshiBaomingService;


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
        PageUtils page = kaoshiBaomingService.queryPage(params);

        //字典表数据转换
        List<KaoshiBaomingView> list =(List<KaoshiBaomingView>)page.getList();
        for(KaoshiBaomingView c:list){
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
        KaoshiBaomingEntity kaoshiBaoming = kaoshiBaomingService.selectById(id);
        if(kaoshiBaoming !=null){
            //entity转view
            KaoshiBaomingView view = new KaoshiBaomingView();
            BeanUtils.copyProperties( kaoshiBaoming , view );//把实体数据重构到view中
            //级联表 考试
            //级联表
            KaoshiEntity kaoshi = kaoshiService.selectById(kaoshiBaoming.getKaoshiId());
            if(kaoshi != null){
            BeanUtils.copyProperties( kaoshi , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "laoshiId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setKaoshiId(kaoshi.getId());
            }
            //级联表 老师
            //级联表
            LaoshiEntity laoshi = laoshiService.selectById(kaoshiBaoming.getLaoshiId());
            if(laoshi != null){
            BeanUtils.copyProperties( laoshi , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "laoshiId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setLaoshiId(laoshi.getId());
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
    public R save(@RequestBody KaoshiBaomingEntity kaoshiBaoming, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,kaoshiBaoming:{}",this.getClass().getName(),kaoshiBaoming.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("老师".equals(role))
            kaoshiBaoming.setLaoshiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<KaoshiBaomingEntity> queryWrapper = new EntityWrapper<KaoshiBaomingEntity>()
            .eq("kaoshi_id", kaoshiBaoming.getKaoshiId())
            .eq("laoshi_id", kaoshiBaoming.getLaoshiId())
            .in("kaoshi_baoming_yesno_types", new Integer[]{1,2})
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        KaoshiBaomingEntity kaoshiBaomingEntity = kaoshiBaomingService.selectOne(queryWrapper);
        if(kaoshiBaomingEntity==null){

            KaoshiEntity kaoshiEntity = kaoshiService.selectById(kaoshiBaoming.getKaoshiId());
            if (kaoshiEntity.getKaoshiTime().getTime()<new Date().getTime()){
                return R.error("已经开始考试了,无法报名此考试的监考");
            }


            kaoshiBaoming.setInsertTime(new Date());
            kaoshiBaoming.setKaoshiBaomingYesnoTypes(1);
            kaoshiBaoming.setCreateTime(new Date());
            kaoshiBaomingService.insert(kaoshiBaoming);
            return R.ok();
        }else {
            if(kaoshiBaomingEntity.getKaoshiBaomingYesnoTypes()==1)
                return R.error(511,"该老师已经申请了该考试的监考报名");
            else if(kaoshiBaomingEntity.getKaoshiBaomingYesnoTypes()==2)
                return R.error(511,"该老师已经申请通过了该考试的监考报名");
            else
                return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody KaoshiBaomingEntity kaoshiBaoming, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,kaoshiBaoming:{}",this.getClass().getName(),kaoshiBaoming.toString());
        KaoshiBaomingEntity oldKaoshiBaomingEntity = kaoshiBaomingService.selectById(kaoshiBaoming.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("老师".equals(role))
//            kaoshiBaoming.setLaoshiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

            kaoshiBaomingService.updateById(kaoshiBaoming);//根据id更新
            return R.ok();
    }


    /**
    * 审核
    */
    @RequestMapping("/shenhe")
    public R shenhe(@RequestBody KaoshiBaomingEntity kaoshiBaomingEntity, HttpServletRequest request){
        logger.debug("shenhe方法:,,Controller:{},,kaoshiBaomingEntity:{}",this.getClass().getName(),kaoshiBaomingEntity.toString());

        KaoshiBaomingEntity oldKaoshiBaoming = kaoshiBaomingService.selectById(kaoshiBaomingEntity.getId());//查询原先数据

//        if(kaoshiBaomingEntity.getKaoshiBaomingYesnoTypes() == 2){//通过
//            kaoshiBaomingEntity.setKaoshiBaomingTypes();
//        }else if(kaoshiBaomingEntity.getKaoshiBaomingYesnoTypes() == 3){//拒绝
//            kaoshiBaomingEntity.setKaoshiBaomingTypes();
//        }
        kaoshiBaomingEntity.setKaoshiBaomingShenheTime(new Date());//审核时间
        kaoshiBaomingService.updateById(kaoshiBaomingEntity);//审核

        return R.ok();
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<KaoshiBaomingEntity> oldKaoshiBaomingList =kaoshiBaomingService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        kaoshiBaomingService.deleteBatchIds(Arrays.asList(ids));

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
            List<KaoshiBaomingEntity> kaoshiBaomingList = new ArrayList<>();//上传的东西
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
                            KaoshiBaomingEntity kaoshiBaomingEntity = new KaoshiBaomingEntity();
//                            kaoshiBaomingEntity.setKaoshiId(Integer.valueOf(data.get(0)));   //考试 要改的
//                            kaoshiBaomingEntity.setLaoshiId(Integer.valueOf(data.get(0)));   //老师 要改的
//                            kaoshiBaomingEntity.setKaoshiBaomingUuidNumber(data.get(0));                    //监考报名编号 要改的
//                            kaoshiBaomingEntity.setKaoshiBaomingName(data.get(0));                    //监考报名名称 要改的
//                            kaoshiBaomingEntity.setKaoshiBaomingContent("");//详情和图片
//                            kaoshiBaomingEntity.setInsertTime(date);//时间
//                            kaoshiBaomingEntity.setKaoshiBaomingYesnoTypes(Integer.valueOf(data.get(0)));   //申请状态 要改的
//                            kaoshiBaomingEntity.setKaoshiBaomingYesnoText(data.get(0));                    //审核意见 要改的
//                            kaoshiBaomingEntity.setKaoshiBaomingShenheTime(sdf.parse(data.get(0)));          //审核时间 要改的
//                            kaoshiBaomingEntity.setCreateTime(date);//时间
                            kaoshiBaomingList.add(kaoshiBaomingEntity);


                            //把要查询是否重复的字段放入map中
                                //监考报名编号
                                if(seachFields.containsKey("kaoshiBaomingUuidNumber")){
                                    List<String> kaoshiBaomingUuidNumber = seachFields.get("kaoshiBaomingUuidNumber");
                                    kaoshiBaomingUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> kaoshiBaomingUuidNumber = new ArrayList<>();
                                    kaoshiBaomingUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("kaoshiBaomingUuidNumber",kaoshiBaomingUuidNumber);
                                }
                        }

                        //查询是否重复
                         //监考报名编号
                        List<KaoshiBaomingEntity> kaoshiBaomingEntities_kaoshiBaomingUuidNumber = kaoshiBaomingService.selectList(new EntityWrapper<KaoshiBaomingEntity>().in("kaoshi_baoming_uuid_number", seachFields.get("kaoshiBaomingUuidNumber")));
                        if(kaoshiBaomingEntities_kaoshiBaomingUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(KaoshiBaomingEntity s:kaoshiBaomingEntities_kaoshiBaomingUuidNumber){
                                repeatFields.add(s.getKaoshiBaomingUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [监考报名编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        kaoshiBaomingService.insertBatch(kaoshiBaomingList);
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

