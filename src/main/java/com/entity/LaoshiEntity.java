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
 * 老师
 *
 * @author 
 * @email
 */
@TableName("laoshi")
public class LaoshiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public LaoshiEntity() {

	}

	public LaoshiEntity(T t) {
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
     * 账户
     */
    @ColumnInfo(comment="账户",type="varchar(200)")
    @TableField(value = "username")

    private String username;


    /**
     * 密码
     */
    @ColumnInfo(comment="密码",type="varchar(200)")
    @TableField(value = "password")

    private String password;


    /**
     * 工号
     */
    @ColumnInfo(comment="工号",type="varchar(200)")
    @TableField(value = "laoshi_uuid_number")

    private String laoshiUuidNumber;


    /**
     * 老师姓名
     */
    @ColumnInfo(comment="老师姓名",type="varchar(200)")
    @TableField(value = "laoshi_name")

    private String laoshiName;


    /**
     * 老师手机号
     */
    @ColumnInfo(comment="老师手机号",type="varchar(200)")
    @TableField(value = "laoshi_phone")

    private String laoshiPhone;


    /**
     * 老师身份证号
     */
    @ColumnInfo(comment="老师身份证号",type="varchar(200)")
    @TableField(value = "laoshi_id_number")

    private String laoshiIdNumber;


    /**
     * 老师头像
     */
    @ColumnInfo(comment="老师头像",type="varchar(200)")
    @TableField(value = "laoshi_photo")

    private String laoshiPhoto;


    /**
     * 性别
     */
    @ColumnInfo(comment="性别",type="int(11)")
    @TableField(value = "sex_types")

    private Integer sexTypes;


    /**
     * 院部
     */
    @ColumnInfo(comment="院部",type="int(11)")
    @TableField(value = "yuanbu_types")

    private Integer yuanbuTypes;


    /**
     * 老师邮箱
     */
    @ColumnInfo(comment="老师邮箱",type="varchar(200)")
    @TableField(value = "laoshi_email")

    private String laoshiEmail;


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
	 * 获取：账户
	 */
    public String getUsername() {
        return username;
    }
    /**
	 * 设置：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 获取：密码
	 */
    public String getPassword() {
        return password;
    }
    /**
	 * 设置：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 获取：工号
	 */
    public String getLaoshiUuidNumber() {
        return laoshiUuidNumber;
    }
    /**
	 * 设置：工号
	 */

    public void setLaoshiUuidNumber(String laoshiUuidNumber) {
        this.laoshiUuidNumber = laoshiUuidNumber;
    }
    /**
	 * 获取：老师姓名
	 */
    public String getLaoshiName() {
        return laoshiName;
    }
    /**
	 * 设置：老师姓名
	 */

    public void setLaoshiName(String laoshiName) {
        this.laoshiName = laoshiName;
    }
    /**
	 * 获取：老师手机号
	 */
    public String getLaoshiPhone() {
        return laoshiPhone;
    }
    /**
	 * 设置：老师手机号
	 */

    public void setLaoshiPhone(String laoshiPhone) {
        this.laoshiPhone = laoshiPhone;
    }
    /**
	 * 获取：老师身份证号
	 */
    public String getLaoshiIdNumber() {
        return laoshiIdNumber;
    }
    /**
	 * 设置：老师身份证号
	 */

    public void setLaoshiIdNumber(String laoshiIdNumber) {
        this.laoshiIdNumber = laoshiIdNumber;
    }
    /**
	 * 获取：老师头像
	 */
    public String getLaoshiPhoto() {
        return laoshiPhoto;
    }
    /**
	 * 设置：老师头像
	 */

    public void setLaoshiPhoto(String laoshiPhoto) {
        this.laoshiPhoto = laoshiPhoto;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }
    /**
	 * 设置：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：院部
	 */
    public Integer getYuanbuTypes() {
        return yuanbuTypes;
    }
    /**
	 * 设置：院部
	 */

    public void setYuanbuTypes(Integer yuanbuTypes) {
        this.yuanbuTypes = yuanbuTypes;
    }
    /**
	 * 获取：老师邮箱
	 */
    public String getLaoshiEmail() {
        return laoshiEmail;
    }
    /**
	 * 设置：老师邮箱
	 */

    public void setLaoshiEmail(String laoshiEmail) {
        this.laoshiEmail = laoshiEmail;
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
        return "Laoshi{" +
            ", id=" + id +
            ", username=" + username +
            ", password=" + password +
            ", laoshiUuidNumber=" + laoshiUuidNumber +
            ", laoshiName=" + laoshiName +
            ", laoshiPhone=" + laoshiPhone +
            ", laoshiIdNumber=" + laoshiIdNumber +
            ", laoshiPhoto=" + laoshiPhoto +
            ", sexTypes=" + sexTypes +
            ", yuanbuTypes=" + yuanbuTypes +
            ", laoshiEmail=" + laoshiEmail +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
