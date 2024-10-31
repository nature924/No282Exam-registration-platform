package com.entity.vo;

import com.entity.KaoshiBaomingEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 监考报名
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("kaoshi_baoming")
public class KaoshiBaomingVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 老师
     */

    @TableField(value = "laoshi_id")
    private Integer laoshiId;


    /**
     * 监考报名编号
     */

    @TableField(value = "kaoshi_baoming_uuid_number")
    private String kaoshiBaomingUuidNumber;


    /**
     * 监考报名名称
     */

    @TableField(value = "kaoshi_baoming_name")
    private String kaoshiBaomingName;


    /**
     * 报名缘由
     */

    @TableField(value = "kaoshi_baoming_content")
    private String kaoshiBaomingContent;


    /**
     * 报名时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 申请状态
     */

    @TableField(value = "kaoshi_baoming_yesno_types")
    private Integer kaoshiBaomingYesnoTypes;


    /**
     * 审核意见
     */

    @TableField(value = "kaoshi_baoming_yesno_text")
    private String kaoshiBaomingYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "kaoshi_baoming_shenhe_time")
    private Date kaoshiBaomingShenheTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：老师
	 */
    public Integer getLaoshiId() {
        return laoshiId;
    }


    /**
	 * 获取：老师
	 */

    public void setLaoshiId(Integer laoshiId) {
        this.laoshiId = laoshiId;
    }
    /**
	 * 设置：监考报名编号
	 */
    public String getKaoshiBaomingUuidNumber() {
        return kaoshiBaomingUuidNumber;
    }


    /**
	 * 获取：监考报名编号
	 */

    public void setKaoshiBaomingUuidNumber(String kaoshiBaomingUuidNumber) {
        this.kaoshiBaomingUuidNumber = kaoshiBaomingUuidNumber;
    }
    /**
	 * 设置：监考报名名称
	 */
    public String getKaoshiBaomingName() {
        return kaoshiBaomingName;
    }


    /**
	 * 获取：监考报名名称
	 */

    public void setKaoshiBaomingName(String kaoshiBaomingName) {
        this.kaoshiBaomingName = kaoshiBaomingName;
    }
    /**
	 * 设置：报名缘由
	 */
    public String getKaoshiBaomingContent() {
        return kaoshiBaomingContent;
    }


    /**
	 * 获取：报名缘由
	 */

    public void setKaoshiBaomingContent(String kaoshiBaomingContent) {
        this.kaoshiBaomingContent = kaoshiBaomingContent;
    }
    /**
	 * 设置：报名时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：报名时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：申请状态
	 */
    public Integer getKaoshiBaomingYesnoTypes() {
        return kaoshiBaomingYesnoTypes;
    }


    /**
	 * 获取：申请状态
	 */

    public void setKaoshiBaomingYesnoTypes(Integer kaoshiBaomingYesnoTypes) {
        this.kaoshiBaomingYesnoTypes = kaoshiBaomingYesnoTypes;
    }
    /**
	 * 设置：审核意见
	 */
    public String getKaoshiBaomingYesnoText() {
        return kaoshiBaomingYesnoText;
    }


    /**
	 * 获取：审核意见
	 */

    public void setKaoshiBaomingYesnoText(String kaoshiBaomingYesnoText) {
        this.kaoshiBaomingYesnoText = kaoshiBaomingYesnoText;
    }
    /**
	 * 设置：审核时间
	 */
    public Date getKaoshiBaomingShenheTime() {
        return kaoshiBaomingShenheTime;
    }


    /**
	 * 获取：审核时间
	 */

    public void setKaoshiBaomingShenheTime(Date kaoshiBaomingShenheTime) {
        this.kaoshiBaomingShenheTime = kaoshiBaomingShenheTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
