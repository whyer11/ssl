package com.ssl.user.action.seller;

public class ShowStore {
	
	private int storeId;
	private String name ;
	private String realName;
	private String sex;
	private String areaString;
	
	private String mobile;
	private String tel;
	private String  audit;
	private String state;
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
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
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
	public String getAudit() {
		return audit;
	}
	public void setAudit(String audit) {
		this.audit = audit;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "ShowStore [storeId=" + storeId + ", name=" + name
				+ ", realName=" + realName + ", sex=" + sex + ", areaString="
				+ areaString + ", mobile=" + mobile + ", tel=" + tel
				+ ", audit=" + audit + ", state=" + state + "]";
	}
	
	
	
	

}
