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
 * 考试
 *
 * @author 
 * @email
 */
@TableName("kaoshi")
public class KaoshiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public KaoshiEntity() {

	}

	public KaoshiEntity(T t) {
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
     * 考试编号
     */
    @ColumnInfo(comment="考试编号",type="varchar(200)")
    @TableField(value = "kaoshi_uuid_number")

    private String kaoshiUuidNumber;


    /**
     * 考试名称
     */
    @ColumnInfo(comment="考试名称",type="varchar(200)")
    @TableField(value = "kaoshi_name")

    private String kaoshiName;


    /**
     * 考试区域
     */
    @ColumnInfo(comment="考试区域",type="varchar(200)")
    @TableField(value = "kaoshi_quyu")

    private String kaoshiQuyu;


    /**
     * 考试类型
     */
    @ColumnInfo(comment="考试类型",type="int(11)")
    @TableField(value = "kaoshi_types")

    private Integer kaoshiTypes;


    /**
     * 考试人数
     */
    @ColumnInfo(comment="考试人数",type="int(11)")
    @TableField(value = "kaoshi_renshu")

    private Integer kaoshiRenshu;


    /**
     * 考试时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="考试时间",type="timestamp")
    @TableField(value = "kaoshi_time")

    private Date kaoshiTime;


    /**
     * 考试介绍
     */
    @ColumnInfo(comment="考试介绍",type="longtext")
    @TableField(value = "kaoshi_content")

    private String kaoshiContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


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

    @Override
    public String toString() {
        return "Kaoshi{" +
            ", id=" + id +
            ", kaoshiUuidNumber=" + kaoshiUuidNumber +
            ", kaoshiName=" + kaoshiName +
            ", kaoshiQuyu=" + kaoshiQuyu +
            ", kaoshiTypes=" + kaoshiTypes +
            ", kaoshiRenshu=" + kaoshiRenshu +
            ", kaoshiTime=" + DateUtil.convertString(kaoshiTime,"yyyy-MM-dd") +
            ", kaoshiContent=" + kaoshiContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
