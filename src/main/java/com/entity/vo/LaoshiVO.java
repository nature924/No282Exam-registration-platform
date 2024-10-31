package com.entity.vo;

import com.entity.LaoshiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 老师
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("laoshi")
public class LaoshiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 账户
     */

    @TableField(value = "username")
    private String username;


    /**
     * 密码
     */

    @TableField(value = "password")
    private String password;


    /**
     * 工号
     */

    @TableField(value = "laoshi_uuid_number")
    private String laoshiUuidNumber;


    /**
     * 老师姓名
     */

    @TableField(value = "laoshi_name")
    private String laoshiName;


    /**
     * 老师手机号
     */

    @TableField(value = "laoshi_phone")
    private String laoshiPhone;


    /**
     * 老师身份证号
     */

    @TableField(value = "laoshi_id_number")
    private String laoshiIdNumber;


    /**
     * 老师头像
     */

    @TableField(value = "laoshi_photo")
    private String laoshiPhoto;


    /**
     * 性别
     */

    @TableField(value = "sex_types")
    private Integer sexTypes;


    /**
     * 院部
     */

    @TableField(value = "yuanbu_types")
    private Integer yuanbuTypes;


    /**
     * 老师邮箱
     */

    @TableField(value = "laoshi_email")
    private String laoshiEmail;


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
	 * 设置：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 获取：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：工号
	 */
    public String getLaoshiUuidNumber() {
        return laoshiUuidNumber;
    }


    /**
	 * 获取：工号
	 */

    public void setLaoshiUuidNumber(String laoshiUuidNumber) {
        this.laoshiUuidNumber = laoshiUuidNumber;
    }
    /**
	 * 设置：老师姓名
	 */
    public String getLaoshiName() {
        return laoshiName;
    }


    /**
	 * 获取：老师姓名
	 */

    public void setLaoshiName(String laoshiName) {
        this.laoshiName = laoshiName;
    }
    /**
	 * 设置：老师手机号
	 */
    public String getLaoshiPhone() {
        return laoshiPhone;
    }


    /**
	 * 获取：老师手机号
	 */

    public void setLaoshiPhone(String laoshiPhone) {
        this.laoshiPhone = laoshiPhone;
    }
    /**
	 * 设置：老师身份证号
	 */
    public String getLaoshiIdNumber() {
        return laoshiIdNumber;
    }


    /**
	 * 获取：老师身份证号
	 */

    public void setLaoshiIdNumber(String laoshiIdNumber) {
        this.laoshiIdNumber = laoshiIdNumber;
    }
    /**
	 * 设置：老师头像
	 */
    public String getLaoshiPhoto() {
        return laoshiPhoto;
    }


    /**
	 * 获取：老师头像
	 */

    public void setLaoshiPhoto(String laoshiPhoto) {
        this.laoshiPhoto = laoshiPhoto;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：院部
	 */
    public Integer getYuanbuTypes() {
        return yuanbuTypes;
    }


    /**
	 * 获取：院部
	 */

    public void setYuanbuTypes(Integer yuanbuTypes) {
        this.yuanbuTypes = yuanbuTypes;
    }
    /**
	 * 设置：老师邮箱
	 */
    public String getLaoshiEmail() {
        return laoshiEmail;
    }


    /**
	 * 获取：老师邮箱
	 */

    public void setLaoshiEmail(String laoshiEmail) {
        this.laoshiEmail = laoshiEmail;
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
