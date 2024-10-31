package com.entity.model;

import com.entity.KaoshiBaomingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 监考报名
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class KaoshiBaomingModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 老师
     */
    private Integer laoshiId;


    /**
     * 监考报名编号
     */
    private String kaoshiBaomingUuidNumber;


    /**
     * 监考报名名称
     */
    private String kaoshiBaomingName;


    /**
     * 报名缘由
     */
    private String kaoshiBaomingContent;


    /**
     * 报名时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 申请状态
     */
    private Integer kaoshiBaomingYesnoTypes;


    /**
     * 审核意见
     */
    private String kaoshiBaomingYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date kaoshiBaomingShenheTime;


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
	 * 获取：老师
	 */
    public Integer getLaoshiId() {
        return laoshiId;
    }


    /**
	 * 设置：老师
	 */
    public void setLaoshiId(Integer laoshiId) {
        this.laoshiId = laoshiId;
    }
    /**
	 * 获取：监考报名编号
	 */
    public String getKaoshiBaomingUuidNumber() {
        return kaoshiBaomingUuidNumber;
    }


    /**
	 * 设置：监考报名编号
	 */
    public void setKaoshiBaomingUuidNumber(String kaoshiBaomingUuidNumber) {
        this.kaoshiBaomingUuidNumber = kaoshiBaomingUuidNumber;
    }
    /**
	 * 获取：监考报名名称
	 */
    public String getKaoshiBaomingName() {
        return kaoshiBaomingName;
    }


    /**
	 * 设置：监考报名名称
	 */
    public void setKaoshiBaomingName(String kaoshiBaomingName) {
        this.kaoshiBaomingName = kaoshiBaomingName;
    }
    /**
	 * 获取：报名缘由
	 */
    public String getKaoshiBaomingContent() {
        return kaoshiBaomingContent;
    }


    /**
	 * 设置：报名缘由
	 */
    public void setKaoshiBaomingContent(String kaoshiBaomingContent) {
        this.kaoshiBaomingContent = kaoshiBaomingContent;
    }
    /**
	 * 获取：报名时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：报名时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：申请状态
	 */
    public Integer getKaoshiBaomingYesnoTypes() {
        return kaoshiBaomingYesnoTypes;
    }


    /**
	 * 设置：申请状态
	 */
    public void setKaoshiBaomingYesnoTypes(Integer kaoshiBaomingYesnoTypes) {
        this.kaoshiBaomingYesnoTypes = kaoshiBaomingYesnoTypes;
    }
    /**
	 * 获取：审核意见
	 */
    public String getKaoshiBaomingYesnoText() {
        return kaoshiBaomingYesnoText;
    }


    /**
	 * 设置：审核意见
	 */
    public void setKaoshiBaomingYesnoText(String kaoshiBaomingYesnoText) {
        this.kaoshiBaomingYesnoText = kaoshiBaomingYesnoText;
    }
    /**
	 * 获取：审核时间
	 */
    public Date getKaoshiBaomingShenheTime() {
        return kaoshiBaomingShenheTime;
    }


    /**
	 * 设置：审核时间
	 */
    public void setKaoshiBaomingShenheTime(Date kaoshiBaomingShenheTime) {
        this.kaoshiBaomingShenheTime = kaoshiBaomingShenheTime;
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
