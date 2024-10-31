package com.entity.vo;

import com.entity.XueshengKaoshifenpeiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 考试分配
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("xuesheng_kaoshifenpei")
public class XueshengKaoshifenpeiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 考试
     */

    @TableField(value = "kaoshi_id")
    private Integer kaoshiId;


    /**
     * 教室
     */

    @TableField(value = "banji_id")
    private Integer banjiId;


    /**
     * 学生
     */

    @TableField(value = "xuesheng_id")
    private Integer xueshengId;


    /**
     * 座位号
     */

    @TableField(value = "xuesheng_kaoshifenpei_name")
    private String xueshengKaoshifenpeiName;


    /**
     * 备注
     */

    @TableField(value = "xuesheng_kaoshifenpei_content")
    private String xueshengKaoshifenpeiContent;


    /**
     * 分配时间
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
	 * 设置：考试
	 */
    public Integer getKaoshiId() {
        return kaoshiId;
    }


    /**
	 * 获取：考试
	 */

    public void setKaoshiId(Integer kaoshiId) {
        this.kaoshiId = kaoshiId;
    }
    /**
	 * 设置：教室
	 */
    public Integer getBanjiId() {
        return banjiId;
    }


    /**
	 * 获取：教室
	 */

    public void setBanjiId(Integer banjiId) {
        this.banjiId = banjiId;
    }
    /**
	 * 设置：学生
	 */
    public Integer getXueshengId() {
        return xueshengId;
    }


    /**
	 * 获取：学生
	 */

    public void setXueshengId(Integer xueshengId) {
        this.xueshengId = xueshengId;
    }
    /**
	 * 设置：座位号
	 */
    public String getXueshengKaoshifenpeiName() {
        return xueshengKaoshifenpeiName;
    }


    /**
	 * 获取：座位号
	 */

    public void setXueshengKaoshifenpeiName(String xueshengKaoshifenpeiName) {
        this.xueshengKaoshifenpeiName = xueshengKaoshifenpeiName;
    }
    /**
	 * 设置：备注
	 */
    public String getXueshengKaoshifenpeiContent() {
        return xueshengKaoshifenpeiContent;
    }


    /**
	 * 获取：备注
	 */

    public void setXueshengKaoshifenpeiContent(String xueshengKaoshifenpeiContent) {
        this.xueshengKaoshifenpeiContent = xueshengKaoshifenpeiContent;
    }
    /**
	 * 设置：分配时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：分配时间
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
