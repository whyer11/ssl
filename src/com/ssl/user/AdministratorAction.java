package com.ssl.user;

import com.opensymphony.xwork2.ActionSupport;

public class AdministratorAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer administratorId;
	private String realName;
	private String password;
	private String phone;
	public Integer getAdministratorId() {
		return administratorId;
	}
	public void setAdministratorId(Integer administratorId) {
		this.administratorId = administratorId;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	/**
	 * 管理员登陆
	 */
	public String login(){
		
		AdministratorDao add = new AdministratorDao();
		if(add.login(realName, password)!=null) return 
				"administration";
		return "administratorLogin";
		
	}
	
	
	

}
