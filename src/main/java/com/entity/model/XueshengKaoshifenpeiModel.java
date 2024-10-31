package com.entity.model;

import com.entity.XueshengKaoshifenpeiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 考试分配
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class XueshengKaoshifenpeiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 考试
     */
    private Integer kaoshiId;


    /**
     * 教室
     */
    private Integer banjiId;


    /**
     * 学生
     */
    private Integer xueshengId;


    /**
     * 座位号
     */
    private String xueshengKaoshifenpeiName;


    /**
     * 备注
     */
    private String xueshengKaoshifenpeiContent;


    /**
     * 分配时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


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

    }
