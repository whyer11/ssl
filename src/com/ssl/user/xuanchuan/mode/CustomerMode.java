package com.ssl.user.xuanchuan.mode;

import java.util.Date;

import com.lyq.model.all.Area;

public class CustomerMode {
	private Integer customerId;
	private String sex;	
	private String realName;
	private String userName;
	private String  areaString;
	private Date birthday;
	private Integer score;
	private String mobile;
	private String email;
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAreaString() {
		return areaString;
	}
	public void setAreaString(String areaString) {
		this.areaString = areaString;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "CustomerMode [customerId=" + customerId + ", sex=" + sex
				+ ", realName=" + realName + ", userName=" + userName
				+ ", areaString=" + areaString + ", birthday=" + birthday
				+ ", score=" + score + ", mobile=" + mobile + ", email="
				+ email + "]";
	}
	
	

}
