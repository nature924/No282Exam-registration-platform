package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.KaoshiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 考试
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("kaoshi")
public class KaoshiView extends KaoshiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 考试类型的值
	*/
	@ColumnInfo(comment="考试类型的字典表值",type="varchar(200)")
	private String kaoshiValue;




	public KaoshiView() {

	}

	public KaoshiView(KaoshiEntity kaoshiEntity) {
		try {
			BeanUtils.copyProperties(this, kaoshiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 考试类型的值
	*/
	public String getKaoshiValue() {
		return kaoshiValue;
	}
	/**
	* 设置： 考试类型的值
	*/
	public void setKaoshiValue(String kaoshiValue) {
		this.kaoshiValue = kaoshiValue;
	}




	@Override
	public String toString() {
		return "KaoshiView{" +
			", kaoshiValue=" + kaoshiValue +
			"} " + super.toString();
	}
}
