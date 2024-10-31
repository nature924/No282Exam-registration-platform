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
 * 考试分配
 *
 * @author 
 * @email
 */
@TableName("xuesheng_kaoshifenpei")
public class XueshengKaoshifenpeiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public XueshengKaoshifenpeiEntity() {

	}

	public XueshengKaoshifenpeiEntity(T t) {
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
     * 教室
     */
    @ColumnInfo(comment="教室",type="int(11)")
    @TableField(value = "banji_id")

    private Integer banjiId;


    /**
     * 学生
     */
    @ColumnInfo(comment="学生",type="int(11)")
    @TableField(value = "xuesheng_id")

    private Integer xueshengId;


    /**
     * 座位号
     */
    @ColumnInfo(comment="座位号",type="varchar(200)")
    @TableField(value = "xuesheng_kaoshifenpei_name")

    private String xueshengKaoshifenpeiName;


    /**
     * 备注
     */
    @ColumnInfo(comment="备注",type="longtext")
    @TableField(value = "xuesheng_kaoshifenpei_content")

    private String xueshengKaoshifenpeiContent;


    /**
     * 分配时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="分配时间",type="timestamp")
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
	 * 获取：教室
	 */
    public Integer getBanjiId() {
        return banjiId;
    }
    /**
	 * 设置：教室
	 */

    public void setBanjiId(Integer banjiId) {
        this.banjiId = banjiId;
    }
    /**
	 * 获取：学生
	 */
    public Integer getXueshengId() {
        return xueshengId;
    }
    /**
	 * 设置：学生
	 */

    public void setXueshengId(Integer xueshengId) {
        this.xueshengId = xueshengId;
    }
    /**
	 * 获取：座位号
	 */
    public String getXueshengKaoshifenpeiName() {
        return xueshengKaoshifenpeiName;
    }
    /**
	 * 设置：座位号
	 */

    public void setXueshengKaoshifenpeiName(String xueshengKaoshifenpeiName) {
        this.xueshengKaoshifenpeiName = xueshengKaoshifenpeiName;
    }
    /**
	 * 获取：备注
	 */
    public String getXueshengKaoshifenpeiContent() {
        return xueshengKaoshifenpeiContent;
    }
    /**
	 * 设置：备注
	 */

    public void setXueshengKaoshifenpeiContent(String xueshengKaoshifenpeiContent) {
        this.xueshengKaoshifenpeiContent = xueshengKaoshifenpeiContent;
    }
    /**
	 * 获取：分配时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：分配时间
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
        return "XueshengKaoshifenpei{" +
            ", id=" + id +
            ", kaoshiId=" + kaoshiId +
            ", banjiId=" + banjiId +
            ", xueshengId=" + xueshengId +
            ", xueshengKaoshifenpeiName=" + xueshengKaoshifenpeiName +
            ", xueshengKaoshifenpeiContent=" + xueshengKaoshifenpeiContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
