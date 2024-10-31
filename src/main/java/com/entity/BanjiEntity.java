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
 * 教室
 *
 * @author 
 * @email
 */
@TableName("banji")
public class BanjiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public BanjiEntity() {

	}

	public BanjiEntity(T t) {
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
     * 教室编号
     */
    @ColumnInfo(comment="教室编号",type="varchar(200)")
    @TableField(value = "banji_uuid_number")

    private String banjiUuidNumber;


    /**
     * 楼栋
     */
    @ColumnInfo(comment="楼栋",type="varchar(200)")
    @TableField(value = "banji_loudong")

    private String banjiLoudong;


    /**
     * 楼层
     */
    @ColumnInfo(comment="楼层",type="varchar(200)")
    @TableField(value = "banji_louceng")

    private String banjiLouceng;


    /**
     * 教室名称
     */
    @ColumnInfo(comment="教室名称",type="varchar(200)")
    @TableField(value = "banji_name")

    private String banjiName;


    /**
     * 教室备注
     */
    @ColumnInfo(comment="教室备注",type="longtext")
    @TableField(value = "banji_content")

    private String banjiContent;


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

    @Override
    public String toString() {
        return "Banji{" +
            ", id=" + id +
            ", banjiUuidNumber=" + banjiUuidNumber +
            ", banjiLoudong=" + banjiLoudong +
            ", banjiLouceng=" + banjiLouceng +
            ", banjiName=" + banjiName +
            ", banjiContent=" + banjiContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
