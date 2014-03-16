package com.ssl.user.action.admin;

import java.util.Date;

public class ShowCustomer {
	
	
	private Integer customerId;
	
	private String realName;
	
	private String userName;
	
	private String sex;
	
	private String areaString;
	
	private Date birthday;
	
	private String  state;
	
	private Integer score;

	

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
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

	

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "ShowCustomer [customerId=" + customerId + ", realName="
				+ realName + ", userName=" + userName + ", sex=" + sex
				+ ", areaString=" + areaString + ", birthday=" + birthday
				+ ", state=" + state + ", score=" + score + "]";
	}
	
	
	
	

}
