
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
 * 学生
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/xuesheng")
public class XueshengController {
    private static final Logger logger = LoggerFactory.getLogger(XueshengController.class);

    private static final String TABLE_NAME = "xuesheng";

    @Autowired
    private XueshengService xueshengService;


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
        PageUtils page = xueshengService.queryPage(params);

        //字典表数据转换
        List<XueshengView> list =(List<XueshengView>)page.getList();
        for(XueshengView c:list){
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
        XueshengEntity xuesheng = xueshengService.selectById(id);
        if(xuesheng !=null){
            //entity转view
            XueshengView view = new XueshengView();
            BeanUtils.copyProperties( xuesheng , view );//把实体数据重构到view中
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
    public R save(@RequestBody XueshengEntity xuesheng, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,xuesheng:{}",this.getClass().getName(),xuesheng.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<XueshengEntity> queryWrapper = new EntityWrapper<XueshengEntity>()
            .eq("username", xuesheng.getUsername())
            .or()
            .eq("xuesheng_phone", xuesheng.getXueshengPhone())
            .or()
            .eq("xuesheng_id_number", xuesheng.getXueshengIdNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XueshengEntity xueshengEntity = xueshengService.selectOne(queryWrapper);
        if(xueshengEntity==null){
            xuesheng.setCreateTime(new Date());
            xuesheng.setPassword("123456");
            xueshengService.insert(xuesheng);
            return R.ok();
        }else {
            return R.error(511,"账户或者学生手机号或者学生身份证号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody XueshengEntity xuesheng, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,xuesheng:{}",this.getClass().getName(),xuesheng.toString());
        XueshengEntity oldXueshengEntity = xueshengService.selectById(xuesheng.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(xuesheng.getXueshengPhoto()) || "null".equals(xuesheng.getXueshengPhoto())){
                xuesheng.setXueshengPhoto(null);
        }

            xueshengService.updateById(xuesheng);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<XueshengEntity> oldXueshengList =xueshengService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        xueshengService.deleteBatchIds(Arrays.asList(ids));

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
            List<XueshengEntity> xueshengList = new ArrayList<>();//上传的东西
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
                            XueshengEntity xueshengEntity = new XueshengEntity();
                            xueshengEntity.setUsername(data.get(0));                    //账户 要改的
                            xueshengEntity.setPassword("123456");//密码
                            xueshengEntity.setXueshengUuidNumber(data.get(1));                    //学号 要改的
                            xueshengEntity.setXueshengName(data.get(2));                    //学生姓名 要改的
                            xueshengEntity.setXueshengPhone(data.get(3));                    //学生手机号 要改的
                            xueshengEntity.setXueshengIdNumber(data.get(4));                    //学生身份证号 要改的
                            xueshengEntity.setXueshengPhoto("");//详情和图片
                            xueshengEntity.setSexTypes(Integer.valueOf(data.get(5)));   //性别 要改的
                            xueshengEntity.setXueshengEmail(data.get(6));                    //学生邮箱 要改的
                            xueshengEntity.setCreateTime(date);//时间
                            xueshengList.add(xueshengEntity);


                            //把要查询是否重复的字段放入map中
                                //账户
                                if(seachFields.containsKey("username")){
                                    List<String> username = seachFields.get("username");
                                    username.add(data.get(0));//要改的
                                }else{
                                    List<String> username = new ArrayList<>();
                                    username.add(data.get(0));//要改的
                                    seachFields.put("username",username);
                                }
                                //学号
                                if(seachFields.containsKey("xueshengUuidNumber")){
                                    List<String> xueshengUuidNumber = seachFields.get("xueshengUuidNumber");
                                    xueshengUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> xueshengUuidNumber = new ArrayList<>();
                                    xueshengUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("xueshengUuidNumber",xueshengUuidNumber);
                                }
                                //学生手机号
                                if(seachFields.containsKey("xueshengPhone")){
                                    List<String> xueshengPhone = seachFields.get("xueshengPhone");
                                    xueshengPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> xueshengPhone = new ArrayList<>();
                                    xueshengPhone.add(data.get(0));//要改的
                                    seachFields.put("xueshengPhone",xueshengPhone);
                                }
                                //学生身份证号
                                if(seachFields.containsKey("xueshengIdNumber")){
                                    List<String> xueshengIdNumber = seachFields.get("xueshengIdNumber");
                                    xueshengIdNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> xueshengIdNumber = new ArrayList<>();
                                    xueshengIdNumber.add(data.get(0));//要改的
                                    seachFields.put("xueshengIdNumber",xueshengIdNumber);
                                }
                        }

                        //查询是否重复
                         //账户
                        List<XueshengEntity> xueshengEntities_username = xueshengService.selectList(new EntityWrapper<XueshengEntity>().in("username", seachFields.get("username")));
                        if(xueshengEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(XueshengEntity s:xueshengEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"数据库的该表中的 [账户] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //学号
                        List<XueshengEntity> xueshengEntities_xueshengUuidNumber = xueshengService.selectList(new EntityWrapper<XueshengEntity>().in("xuesheng_uuid_number", seachFields.get("xueshengUuidNumber")));
                        if(xueshengEntities_xueshengUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(XueshengEntity s:xueshengEntities_xueshengUuidNumber){
                                repeatFields.add(s.getXueshengUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [学号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //学生手机号
                        List<XueshengEntity> xueshengEntities_xueshengPhone = xueshengService.selectList(new EntityWrapper<XueshengEntity>().in("xuesheng_phone", seachFields.get("xueshengPhone")));
                        if(xueshengEntities_xueshengPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(XueshengEntity s:xueshengEntities_xueshengPhone){
                                repeatFields.add(s.getXueshengPhone());
                            }
                            return R.error(511,"数据库的该表中的 [学生手机号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //学生身份证号
                        List<XueshengEntity> xueshengEntities_xueshengIdNumber = xueshengService.selectList(new EntityWrapper<XueshengEntity>().in("xuesheng_id_number", seachFields.get("xueshengIdNumber")));
                        if(xueshengEntities_xueshengIdNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(XueshengEntity s:xueshengEntities_xueshengIdNumber){
                                repeatFields.add(s.getXueshengIdNumber());
                            }
                            return R.error(511,"数据库的该表中的 [学生身份证号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        xueshengService.insertBatch(xueshengList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }

    /**
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        XueshengEntity xuesheng = xueshengService.selectOne(new EntityWrapper<XueshengEntity>().eq("username", username));
        if(xuesheng==null || !xuesheng.getPassword().equals(password))
            return R.error("账号或密码不正确");
        String token = tokenService.generateToken(xuesheng.getId(),username, "xuesheng", "学生");
        R r = R.ok();
        r.put("token", token);
        r.put("role","学生");
        r.put("username",xuesheng.getXueshengName());
        r.put("tableName","xuesheng");
        r.put("userId",xuesheng.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody XueshengEntity xuesheng, HttpServletRequest request) {
//    	ValidatorUtils.validateEntity(user);
        Wrapper<XueshengEntity> queryWrapper = new EntityWrapper<XueshengEntity>()
            .eq("username", xuesheng.getUsername())
            .or()
            .eq("xuesheng_phone", xuesheng.getXueshengPhone())
            .or()
            .eq("xuesheng_id_number", xuesheng.getXueshengIdNumber())
            ;
        XueshengEntity xueshengEntity = xueshengService.selectOne(queryWrapper);
        if(xueshengEntity != null)
            return R.error("账户或者学生手机号或者学生身份证号已经被使用");
        xuesheng.setXueshengUuidNumber(String.valueOf(new Date().getTime()));
        xuesheng.setCreateTime(new Date());
        xueshengService.insert(xuesheng);

        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id, HttpServletRequest request) {
        XueshengEntity xuesheng = xueshengService.selectById(id);
        xuesheng.setPassword("123456");
        xueshengService.updateById(xuesheng);
        return R.ok();
    }

	/**
	 * 修改密码
	 */
	@GetMapping(value = "/updatePassword")
	public R updatePassword(String  oldPassword, String  newPassword, HttpServletRequest request) {
        XueshengEntity xuesheng = xueshengService.selectById((Integer)request.getSession().getAttribute("userId"));
		if(newPassword == null){
			return R.error("新密码不能为空") ;
		}
		if(!oldPassword.equals(xuesheng.getPassword())){
			return R.error("原密码输入错误");
		}
		if(newPassword.equals(xuesheng.getPassword())){
			return R.error("新密码不能和原密码一致") ;
		}
        xuesheng.setPassword(newPassword);
		xueshengService.updateById(xuesheng);
		return R.ok();
	}



    /**
     * 忘记密码
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        XueshengEntity xuesheng = xueshengService.selectOne(new EntityWrapper<XueshengEntity>().eq("username", username));
        if(xuesheng!=null){
            xuesheng.setPassword("123456");
            xueshengService.updateById(xuesheng);
            return R.ok();
        }else{
           return R.error("账号不存在");
        }
    }


    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrXuesheng(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        XueshengEntity xuesheng = xueshengService.selectById(id);
        if(xuesheng !=null){
            //entity转view
            XueshengView view = new XueshengView();
            BeanUtils.copyProperties( xuesheng , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }
    }


    /**
    * 退出
    */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }



}

