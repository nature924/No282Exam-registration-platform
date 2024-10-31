package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.KaoshiBaomingEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 监考报名
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("kaoshi_baoming")
public class KaoshiBaomingView extends KaoshiBaomingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 申请状态的值
	*/
	@ColumnInfo(comment="申请状态的字典表值",type="varchar(200)")
	private String kaoshiBaomingYesnoValue;

	//级联表 考试
		/**
		* 考试编号
		*/

		@ColumnInfo(comment="考试编号",type="varchar(200)")
		private String kaoshiUuidNumber;
		/**
		* 考试名称
		*/

		@ColumnInfo(comment="考试名称",type="varchar(200)")
		private String kaoshiName;
		/**
		* 考试区域
		*/

		@ColumnInfo(comment="考试区域",type="varchar(200)")
		private String kaoshiQuyu;
		/**
		* 考试类型
		*/
		@ColumnInfo(comment="考试类型",type="int(11)")
		private Integer kaoshiTypes;
			/**
			* 考试类型的值
			*/
			@ColumnInfo(comment="考试类型的字典表值",type="varchar(200)")
			private String kaoshiValue;
		/**
		* 考试人数
		*/

		@ColumnInfo(comment="考试人数",type="int(11)")
		private Integer kaoshiRenshu;
		/**
		* 考试时间
		*/
		@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
		@DateTimeFormat
		@ColumnInfo(comment="考试时间",type="timestamp")
		private Date kaoshiTime;
		/**
		* 考试介绍
		*/

		@ColumnInfo(comment="考试介绍",type="longtext")
		private String kaoshiContent;
	//级联表 老师
		/**
		* 工号
		*/

		@ColumnInfo(comment="工号",type="varchar(200)")
		private String laoshiUuidNumber;
		/**
		* 老师姓名
		*/

		@ColumnInfo(comment="老师姓名",type="varchar(200)")
		private String laoshiName;
		/**
		* 老师手机号
		*/

		@ColumnInfo(comment="老师手机号",type="varchar(200)")
		private String laoshiPhone;
		/**
		* 老师身份证号
		*/

		@ColumnInfo(comment="老师身份证号",type="varchar(200)")
		private String laoshiIdNumber;
		/**
		* 老师头像
		*/

		@ColumnInfo(comment="老师头像",type="varchar(200)")
		private String laoshiPhoto;
		/**
		* 院部
		*/
		@ColumnInfo(comment="院部",type="int(11)")
		private Integer yuanbuTypes;
			/**
			* 院部的值
			*/
			@ColumnInfo(comment="院部的字典表值",type="varchar(200)")
			private String yuanbuValue;
		/**
		* 老师邮箱
		*/

		@ColumnInfo(comment="老师邮箱",type="varchar(200)")
		private String laoshiEmail;



	public KaoshiBaomingView() {

	}

	public KaoshiBaomingView(KaoshiBaomingEntity kaoshiBaomingEntity) {
		try {
			BeanUtils.copyProperties(this, kaoshiBaomingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 申请状态的值
	*/
	public String getKaoshiBaomingYesnoValue() {
		return kaoshiBaomingYesnoValue;
	}
	/**
	* 设置： 申请状态的值
	*/
	public void setKaoshiBaomingYesnoValue(String kaoshiBaomingYesnoValue) {
		this.kaoshiBaomingYesnoValue = kaoshiBaomingYesnoValue;
	}


	//级联表的get和set 考试

		/**
		* 获取： 考试编号
		*/
		public String getKaoshiUuidNumber() {
			return kaoshiUuidNumber;
		}
		/**
		* 设置： 考试编号
		*/
		public void setKaoshiUuidNumber(String kaoshiUuidNumber) {
			this.kaoshiUuidNumber = kaoshiUuidNumber;
		}

		/**
		* 获取： 考试名称
		*/
		public String getKaoshiName() {
			return kaoshiName;
		}
		/**
		* 设置： 考试名称
		*/
		public void setKaoshiName(String kaoshiName) {
			this.kaoshiName = kaoshiName;
		}

		/**
		* 获取： 考试区域
		*/
		public String getKaoshiQuyu() {
			return kaoshiQuyu;
		}
		/**
		* 设置： 考试区域
		*/
		public void setKaoshiQuyu(String kaoshiQuyu) {
			this.kaoshiQuyu = kaoshiQuyu;
		}
		/**
		* 获取： 考试类型
		*/
		public Integer getKaoshiTypes() {
			return kaoshiTypes;
		}
		/**
		* 设置： 考试类型
		*/
		public void setKaoshiTypes(Integer kaoshiTypes) {
			this.kaoshiTypes = kaoshiTypes;
		}


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

		/**
		* 获取： 考试人数
		*/
		public Integer getKaoshiRenshu() {
			return kaoshiRenshu;
		}
		/**
		* 设置： 考试人数
		*/
		public void setKaoshiRenshu(Integer kaoshiRenshu) {
			this.kaoshiRenshu = kaoshiRenshu;
		}

		/**
		* 获取： 考试时间
		*/
		public Date getKaoshiTime() {
			return kaoshiTime;
		}
		/**
		* 设置： 考试时间
		*/
		public void setKaoshiTime(Date kaoshiTime) {
			this.kaoshiTime = kaoshiTime;
		}

		/**
		* 获取： 考试介绍
		*/
		public String getKaoshiContent() {
			return kaoshiContent;
		}
		/**
		* 设置： 考试介绍
		*/
		public void setKaoshiContent(String kaoshiContent) {
			this.kaoshiContent = kaoshiContent;
		}
	//级联表的get和set 老师

		/**
		* 获取： 工号
		*/
		public String getLaoshiUuidNumber() {
			return laoshiUuidNumber;
		}
		/**
		* 设置： 工号
		*/
		public void setLaoshiUuidNumber(String laoshiUuidNumber) {
			this.laoshiUuidNumber = laoshiUuidNumber;
		}

		/**
		* 获取： 老师姓名
		*/
		public String getLaoshiName() {
			return laoshiName;
		}
		/**
		* 设置： 老师姓名
		*/
		public void setLaoshiName(String laoshiName) {
			this.laoshiName = laoshiName;
		}

		/**
		* 获取： 老师手机号
		*/
		public String getLaoshiPhone() {
			return laoshiPhone;
		}
		/**
		* 设置： 老师手机号
		*/
		public void setLaoshiPhone(String laoshiPhone) {
			this.laoshiPhone = laoshiPhone;
		}

		/**
		* 获取： 老师身份证号
		*/
		public String getLaoshiIdNumber() {
			return laoshiIdNumber;
		}
		/**
		* 设置： 老师身份证号
		*/
		public void setLaoshiIdNumber(String laoshiIdNumber) {
			this.laoshiIdNumber = laoshiIdNumber;
		}

		/**
		* 获取： 老师头像
		*/
		public String getLaoshiPhoto() {
			return laoshiPhoto;
		}
		/**
		* 设置： 老师头像
		*/
		public void setLaoshiPhoto(String laoshiPhoto) {
			this.laoshiPhoto = laoshiPhoto;
		}
		/**
		* 获取： 院部
		*/
		public Integer getYuanbuTypes() {
			return yuanbuTypes;
		}
		/**
		* 设置： 院部
		*/
		public void setYuanbuTypes(Integer yuanbuTypes) {
			this.yuanbuTypes = yuanbuTypes;
		}


			/**
			* 获取： 院部的值
			*/
			public String getYuanbuValue() {
				return yuanbuValue;
			}
			/**
			* 设置： 院部的值
			*/
			public void setYuanbuValue(String yuanbuValue) {
				this.yuanbuValue = yuanbuValue;
			}

		/**
		* 获取： 老师邮箱
		*/
		public String getLaoshiEmail() {
			return laoshiEmail;
		}
		/**
		* 设置： 老师邮箱
		*/
		public void setLaoshiEmail(String laoshiEmail) {
			this.laoshiEmail = laoshiEmail;
		}


	@Override
	public String toString() {
		return "KaoshiBaomingView{" +
			", kaoshiBaomingYesnoValue=" + kaoshiBaomingYesnoValue +
			", kaoshiUuidNumber=" + kaoshiUuidNumber +
			", kaoshiName=" + kaoshiName +
			", kaoshiQuyu=" + kaoshiQuyu +
			", kaoshiRenshu=" + kaoshiRenshu +
			", kaoshiTime=" + DateUtil.convertString(kaoshiTime,"yyyy-MM-dd") +
			", kaoshiContent=" + kaoshiContent +
			", laoshiUuidNumber=" + laoshiUuidNumber +
			", laoshiName=" + laoshiName +
			", laoshiPhone=" + laoshiPhone +
			", laoshiIdNumber=" + laoshiIdNumber +
			", laoshiPhoto=" + laoshiPhoto +
			", laoshiEmail=" + laoshiEmail +
			"} " + super.toString();
	}
}
