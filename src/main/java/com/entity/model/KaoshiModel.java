package com.entity.model;

import com.entity.KaoshiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 考试
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class KaoshiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 考试编号
     */
    private String kaoshiUuidNumber;


    /**
     * 考试名称
     */
    private String kaoshiName;


    /**
     * 考试区域
     */
    private String kaoshiQuyu;


    /**
     * 考试类型
     */
    private Integer kaoshiTypes;


    /**
     * 考试人数
     */
    private Integer kaoshiRenshu;


    /**
     * 考试时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date kaoshiTime;


    /**
     * 考试介绍
     */
    private String kaoshiContent;


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
	 * 获取：考试编号
	 */
    public String getKaoshiUuidNumber() {
        return kaoshiUuidNumber;
    }


    /**
	 * 设置：考试编号
	 */
    public void setKaoshiUuidNumber(String kaoshiUuidNumber) {
        this.kaoshiUuidNumber = kaoshiUuidNumber;
    }
    /**
	 * 获取：考试名称
	 */
    public String getKaoshiName() {
        return kaoshiName;
    }


    /**
	 * 设置：考试名称
	 */
    public void setKaoshiName(String kaoshiName) {
        this.kaoshiName = kaoshiName;
    }
    /**
	 * 获取：考试区域
	 */
    public String getKaoshiQuyu() {
        return kaoshiQuyu;
    }


    /**
	 * 设置：考试区域
	 */
    public void setKaoshiQuyu(String kaoshiQuyu) {
        this.kaoshiQuyu = kaoshiQuyu;
    }
    /**
	 * 获取：考试类型
	 */
    public Integer getKaoshiTypes() {
        return kaoshiTypes;
    }


    /**
	 * 设置：考试类型
	 */
    public void setKaoshiTypes(Integer kaoshiTypes) {
        this.kaoshiTypes = kaoshiTypes;
    }
    /**
	 * 获取：考试人数
	 */
    public Integer getKaoshiRenshu() {
        return kaoshiRenshu;
    }


    /**
	 * 设置：考试人数
	 */
    public void setKaoshiRenshu(Integer kaoshiRenshu) {
        this.kaoshiRenshu = kaoshiRenshu;
    }
    /**
	 * 获取：考试时间
	 */
    public Date getKaoshiTime() {
        return kaoshiTime;
    }


    /**
	 * 设置：考试时间
	 */
    public void setKaoshiTime(Date kaoshiTime) {
        this.kaoshiTime = kaoshiTime;
    }
    /**
	 * 获取：考试介绍
	 */
    public String getKaoshiContent() {
        return kaoshiContent;
    }


    /**
	 * 设置：考试介绍
	 */
    public void setKaoshiContent(String kaoshiContent) {
        this.kaoshiContent = kaoshiContent;
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
