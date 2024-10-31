package com.entity.vo;

import com.entity.BanjiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 教室
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("banji")
public class BanjiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 教室编号
     */

    @TableField(value = "banji_uuid_number")
    private String banjiUuidNumber;


    /**
     * 楼栋
     */

    @TableField(value = "banji_loudong")
    private String banjiLoudong;


    /**
     * 楼层
     */

    @TableField(value = "banji_louceng")
    private String banjiLouceng;


    /**
     * 教室名称
     */

    @TableField(value = "banji_name")
    private String banjiName;


    /**
     * 教室备注
     */

    @TableField(value = "banji_content")
    private String banjiContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


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
	 * 设置：教室编号
	 */
    public String getBanjiUuidNumber() {
        return banjiUuidNumber;
    }


    /**
	 * 获取：教室编号
	 */

    public void setBanjiUuidNumber(String banjiUuidNumber) {
        this.banjiUuidNumber = banjiUuidNumber;
    }
    /**
	 * 设置：楼栋
	 */
    public String getBanjiLoudong() {
        return banjiLoudong;
    }


    /**
	 * 获取：楼栋
	 */

    public void setBanjiLoudong(String banjiLoudong) {
        this.banjiLoudong = banjiLoudong;
    }
    /**
	 * 设置：楼层
	 */
    public String getBanjiLouceng() {
        return banjiLouceng;
    }


    /**
	 * 获取：楼层
	 */

    public void setBanjiLouceng(String banjiLouceng) {
        this.banjiLouceng = banjiLouceng;
    }
    /**
	 * 设置：教室名称
	 */
    public String getBanjiName() {
        return banjiName;
    }


    /**
	 * 获取：教室名称
	 */

    public void setBanjiName(String banjiName) {
        this.banjiName = banjiName;
    }
    /**
	 * 设置：教室备注
	 */
    public String getBanjiContent() {
        return banjiContent;
    }


    /**
	 * 获取：教室备注
	 */

    public void setBanjiContent(String banjiContent) {
        this.banjiContent = banjiContent;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
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
