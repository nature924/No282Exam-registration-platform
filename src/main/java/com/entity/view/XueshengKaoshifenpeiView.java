package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.XueshengKaoshifenpeiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 考试分配
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("xuesheng_kaoshifenpei")
public class XueshengKaoshifenpeiView extends XueshengKaoshifenpeiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表

	//级联表 教室
		/**
		* 教室编号
		*/

		@ColumnInfo(comment="教室编号",type="varchar(200)")
		private String banjiUuidNumber;
		/**
		* 楼栋
		*/

		@ColumnInfo(comment="楼栋",type="varchar(200)")
		private String banjiLoudong;
		/**
		* 楼层
		*/

		@ColumnInfo(comment="楼层",type="varchar(200)")
		private String banjiLouceng;
		/**
		* 教室名称
		*/

		@ColumnInfo(comment="教室名称",type="varchar(200)")
		private String banjiName;
		/**
		* 教室备注
		*/

		@ColumnInfo(comment="教室备注",type="longtext")
		private String banjiContent;
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
	//级联表 学生
		/**
		* 学号
		*/

		@ColumnInfo(comment="学号",type="varchar(200)")
		private String xueshengUuidNumber;
		/**
		* 学生姓名
		*/

		@ColumnInfo(comment="学生姓名",type="varchar(200)")
		private String xueshengName;
		/**
		* 学生手机号
		*/

		@ColumnInfo(comment="学生手机号",type="varchar(200)")
		private String xueshengPhone;
		/**
		* 学生身份证号
		*/

		@ColumnInfo(comment="学生身份证号",type="varchar(200)")
		private String xueshengIdNumber;
		/**
		* 学生头像
		*/

		@ColumnInfo(comment="学生头像",type="varchar(200)")
		private String xueshengPhoto;
		/**
		* 学生邮箱
		*/

		@ColumnInfo(comment="学生邮箱",type="varchar(200)")
		private String xueshengEmail;



	public XueshengKaoshifenpeiView() {

	}

	public XueshengKaoshifenpeiView(XueshengKaoshifenpeiEntity xueshengKaoshifenpeiEntity) {
		try {
			BeanUtils.copyProperties(this, xueshengKaoshifenpeiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}





	//级联表的get和set 教室

		/**
		* 获取： 教室编号
		*/
		public String getBanjiUuidNumber() {
			return banjiUuidNumber;
		}
		/**
		* 设置： 教室编号
		*/
		public void setBanjiUuidNumber(String banjiUuidNumber) {
			this.banjiUuidNumber = banjiUuidNumber;
		}

		/**
		* 获取： 楼栋
		*/
		public String getBanjiLoudong() {
			return banjiLoudong;
		}
		/**
		* 设置： 楼栋
		*/
		public void setBanjiLoudong(String banjiLoudong) {
			this.banjiLoudong = banjiLoudong;
		}

		/**
		* 获取： 楼层
		*/
		public String getBanjiLouceng() {
			return banjiLouceng;
		}
		/**
		* 设置： 楼层
		*/
		public void setBanjiLouceng(String banjiLouceng) {
			this.banjiLouceng = banjiLouceng;
		}

		/**
		* 获取： 教室名称
		*/
		public String getBanjiName() {
			return banjiName;
		}
		/**
		* 设置： 教室名称
		*/
		public void setBanjiName(String banjiName) {
			this.banjiName = banjiName;
		}

		/**
		* 获取： 教室备注
		*/
		public String getBanjiContent() {
			return banjiContent;
		}
		/**
		* 设置： 教室备注
		*/
		public void setBanjiContent(String banjiContent) {
			this.banjiContent = banjiContent;
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
	//级联表的get和set 学生

		/**
		* 获取： 学号
		*/
		public String getXueshengUuidNumber() {
			return xueshengUuidNumber;
		}
		/**
		* 设置： 学号
		*/
		public void setXueshengUuidNumber(String xueshengUuidNumber) {
			this.xueshengUuidNumber = xueshengUuidNumber;
		}

		/**
		* 获取： 学生姓名
		*/
		public String getXueshengName() {
			return xueshengName;
		}
		/**
		* 设置： 学生姓名
		*/
		public void setXueshengName(String xueshengName) {
			this.xueshengName = xueshengName;
		}

		/**
		* 获取： 学生手机号
		*/
		public String getXueshengPhone() {
			return xueshengPhone;
		}
		/**
		* 设置： 学生手机号
		*/
		public void setXueshengPhone(String xueshengPhone) {
			this.xueshengPhone = xueshengPhone;
		}

		/**
		* 获取： 学生身份证号
		*/
		public String getXueshengIdNumber() {
			return xueshengIdNumber;
		}
		/**
		* 设置： 学生身份证号
		*/
		public void setXueshengIdNumber(String xueshengIdNumber) {
			this.xueshengIdNumber = xueshengIdNumber;
		}

		/**
		* 获取： 学生头像
		*/
		public String getXueshengPhoto() {
			return xueshengPhoto;
		}
		/**
		* 设置： 学生头像
		*/
		public void setXueshengPhoto(String xueshengPhoto) {
			this.xueshengPhoto = xueshengPhoto;
		}

		/**
		* 获取： 学生邮箱
		*/
		public String getXueshengEmail() {
			return xueshengEmail;
		}
		/**
		* 设置： 学生邮箱
		*/
		public void setXueshengEmail(String xueshengEmail) {
			this.xueshengEmail = xueshengEmail;
		}


	@Override
	public String toString() {
		return "XueshengKaoshifenpeiView{" +
			", kaoshiUuidNumber=" + kaoshiUuidNumber +
			", kaoshiName=" + kaoshiName +
			", kaoshiQuyu=" + kaoshiQuyu +
			", kaoshiRenshu=" + kaoshiRenshu +
			", kaoshiTime=" + DateUtil.convertString(kaoshiTime,"yyyy-MM-dd") +
			", kaoshiContent=" + kaoshiContent +
			", banjiUuidNumber=" + banjiUuidNumber +
			", banjiLoudong=" + banjiLoudong +
			", banjiLouceng=" + banjiLouceng +
			", banjiName=" + banjiName +
			", banjiContent=" + banjiContent +
			", xueshengUuidNumber=" + xueshengUuidNumber +
			", xueshengName=" + xueshengName +
			", xueshengPhone=" + xueshengPhone +
			", xueshengIdNumber=" + xueshengIdNumber +
			", xueshengPhoto=" + xueshengPhoto +
			", xueshengEmail=" + xueshengEmail +
			"} " + super.toString();
	}
}
