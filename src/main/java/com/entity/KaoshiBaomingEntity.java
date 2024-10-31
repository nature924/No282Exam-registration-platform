package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 监考报名
 *
 * @author 
 * @email
 */
@TableName("kaoshi_baoming")
public class KaoshiBaomingEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public KaoshiBaomingEntity() {

	}

	public KaoshiBaomingEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 考试
     */
    @ColumnInfo(comment="考试",type="int(11)")
    @TableField(value = "kaoshi_id")

    private Integer kaoshiId;


    /**
     * 老师
     */
    @ColumnInfo(comment="老师",type="int(11)")
    @TableField(value = "laoshi_id")

    private Integer laoshiId;


    /**
     * 监考报名编号
     */
    @ColumnInfo(comment="监考报名编号",type="varchar(200)")
    @TableField(value = "kaoshi_baoming_uuid_number")

    private String kaoshiBaomingUuidNumber;


    /**
     * 监考报名名称
     */
    @ColumnInfo(comment="监考报名名称",type="varchar(200)")
    @TableField(value = "kaoshi_baoming_name")

    private String kaoshiBaomingName;


    /**
     * 报名缘由
     */
    @ColumnInfo(comment="报名缘由",type="longtext")
    @TableField(value = "kaoshi_baoming_content")

    private String kaoshiBaomingContent;


    /**
     * 报名时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="报名时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 申请状态
     */
    @ColumnInfo(comment="申请状态",type="int(11)")
    @TableField(value = "kaoshi_baoming_yesno_types")

    private Integer kaoshiBaomingYesnoTypes;


    /**
     * 审核意见
     */
    @ColumnInfo(comment="审核意见",type="longtext")
    @TableField(value = "kaoshi_baoming_yesno_text")

    private String kaoshiBaomingYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="审核时间",type="timestamp")
    @TableField(value = "kaoshi_baoming_shenhe_time")

    private Date kaoshiBaomingShenheTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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
	 * 获取：考试
	 */
    public Integer getKaoshiId() {
        return kaoshiId;
    }
    /**
	 * 设置：考试
	 */

    public void setKaoshiId(Integer kaoshiId) {
        this.kaoshiId = kaoshiId;
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

    @Override
    public String toString() {
        return "KaoshiBaoming{" +
            ", id=" + id +
            ", kaoshiId=" + kaoshiId +
            ", laoshiId=" + laoshiId +
            ", kaoshiBaomingUuidNumber=" + kaoshiBaomingUuidNumber +
            ", kaoshiBaomingName=" + kaoshiBaomingName +
            ", kaoshiBaomingContent=" + kaoshiBaomingContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", kaoshiBaomingYesnoTypes=" + kaoshiBaomingYesnoTypes +
            ", kaoshiBaomingYesnoText=" + kaoshiBaomingYesnoText +
            ", kaoshiBaomingShenheTime=" + DateUtil.convertString(kaoshiBaomingShenheTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
