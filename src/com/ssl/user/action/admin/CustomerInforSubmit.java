package com.ssl.user.action.admin;

import java.sql.Timestamp;
import java.util.Map;

import com.framework.Dao.CustomerDao;
import com.lyq.model.all.Customer;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.ssl.user.tool.Encode;

public class CustomerInforSubmit extends ActionSupport {
	
	private  boolean  success ;
	
	private String message;
	
	
	private String newUserName ;
	
	private String randomCode;
	
	
	private String newMobile;
	
	
	private String newPassword;
	
	private String newEmail;
	
	
	
	public String getNewEmail() {
		return newEmail;
	}

	public void setNewEmail(String newEmail) {
		this.newEmail = newEmail;
	}


	private Map<String, Object> session = ActionContext.getContext()
			.getSession();
	
	private  Timestamp registerTime;
	
	
	
	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getNewUserName() {
		return newUserName;
	}

	public void setNewUserName(String newUserName) {
		this.newUserName = newUserName;
	}

	public String getRandomCode() {
		return randomCode;
	}

	public void setRandomCode(String randomCode) {
		this.randomCode = randomCode;
	}

	public String getNewMobile() {
		return newMobile;
	}

	public void setNewMobile(String newMobile) {
		this.newMobile = newMobile;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	

	public Timestamp getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Timestamp registerTime) {
		this.registerTime = registerTime;
	}

	/**
	 * 第二步：更换用户名
	 */
	public String updateUserName(){
		
		CustomerDao customerDao = new CustomerDao();	
		
		Customer customer = customerDao.findByUserName((String)session.get("login_username"));
		
		String newUserName =this.getNewUserName();
		if(customer!=null){
			
			customer.setUserName(newUserName);
			session.put("login_username",newUserName);
			customerDao.update(customer);		
			
		}
		System.out.println("更新用户名成功！！");
		return SUCCESS;
		
	}
	
	/*
	 * 进行修改手机号的操作，第四步：检查验证码，成功提交
	 */
	public String updateMobile() {
		String reRandomCode = (String) session.get("updateCheckCode");

		if (reRandomCode.equals(this.getRandomCode())) {
			
			
			CustomerDao cd = new CustomerDao();
			Customer c = cd.findByUserName((String)session.get("login_username"));
		
			c.setMobile(this.getNewMobile());
			cd.update(c);
			success = true;
			message = "密码修改成功！";

		}else {
			
			success=false;
			message="验证码有误，请重新提交！";
		}

		return SUCCESS;
	}
	
	
	
	/**
	 * 修改用户密码：第四步:提交。
	 */
	public String updatePassword(){
		
		String newPassword =this.getNewPassword();
		System.out.println(newPassword);
		CustomerDao customerDao =new CustomerDao();
		Customer customer =customerDao.findByUserName((String)session.get("login_username"));
		this.registerTime=customer.getRegisterTime();
		
		int encry = customer.getEncry();
		Encode encode = new Encode();
		encode.setSalt(encry);
		String encodePassword = encode.encodeByMD5(newPassword, encry);
		customer.setPassword(encodePassword);
		customerDao.update(customer);		
		return SUCCESS;
				
		
	}
	
	
	/**
	 * 修改用户邮箱：第四步：提交
	 */
	public String updateEmail() {
		String reRandomCode = (String) session.get("updateCheckCode");

		if (reRandomCode.equals(this.getRandomCode())) {
			
			
			CustomerDao cd = new CustomerDao();
			Customer c = cd.findByUserName((String)session.get("login_username"));
		
			c.setEmail(this.getNewEmail());
			cd.update(c);
			success = true;
			message = "邮箱修改成功！";
			session.remove("updateCheckCode");

		}else {
			
			success=false;
			message="验证码有误，请重新提交！";
		}
		

		return SUCCESS;
	}
	
	
	
}
