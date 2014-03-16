package com.ssl.user.xuanchuan.mode;

public class StoreMode {
	private Integer storeId;
	
	private String name;
	private String realName;
	private Integer maxpeople;
	private Boolean audit;
	private String mobile;
	private String email;
	public Integer getStoreId() {
		return storeId;
	}
	public void setStoreId(Integer storeId) {
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
	public Integer getMaxpeople() {
		return maxpeople;
	}
	public void setMaxpeople(Integer maxpeople) {
		this.maxpeople = maxpeople;
	}
	public Boolean getAudit() {
		return audit;
	}
	public void setAudit(Boolean audit) {
		this.audit = audit;
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
		return "StoreMode [storeId=" + storeId + ", name=" + name
				+ ", realName=" + realName + ", maxpeople=" + maxpeople
				+ ", audit=" + audit + ", mobile=" + mobile + ", emai=" + email
				+ "]";
	};
	
	
	

}
