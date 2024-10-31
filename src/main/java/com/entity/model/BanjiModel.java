package com.entity.model;

import com.entity.BanjiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 教室
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class BanjiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 教室编号
     */
    private String banjiUuidNumber;


    /**
     * 楼栋
     */
    private String banjiLoudong;


    /**
     * 楼层
     */
    private String banjiLouceng;


    /**
     * 教室名称
     */
    private String banjiName;


    /**
     * 教室备注
     */
    private String banjiContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：教室编号
	 */
    public String getBanjiUuidNumber() {
        return banjiUuidNumber;
    }


    /**
	 * 设置：教室编号
	 */
    public void setBanjiUuidNumber(String banjiUuidNumber) {
        this.banjiUuidNumber = banjiUuidNumber;
    }
    /**
	 * 获取：楼栋
	 */
    public String getBanjiLoudong() {
        return banjiLoudong;
    }


    /**
	 * 设置：楼栋
	 */
    public void setBanjiLoudong(String banjiLoudong) {
        this.banjiLoudong = banjiLoudong;
    }
    /**
	 * 获取：楼层
	 */
    public String getBanjiLouceng() {
        return banjiLouceng;
    }


    /**
	 * 设置：楼层
	 */
    public void setBanjiLouceng(String banjiLouceng) {
        this.banjiLouceng = banjiLouceng;
    }
    /**
	 * 获取：教室名称
	 */
    public String getBanjiName() {
        return banjiName;
    }


    /**
	 * 设置：教室名称
	 */
    public void setBanjiName(String banjiName) {
        this.banjiName = banjiName;
    }
    /**
	 * 获取：教室备注
	 */
    public String getBanjiContent() {
        return banjiContent;
    }


    /**
	 * 设置：教室备注
	 */
    public void setBanjiContent(String banjiContent) {
        this.banjiContent = banjiContent;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：录入时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
