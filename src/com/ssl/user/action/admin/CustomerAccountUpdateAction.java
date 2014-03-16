package com.ssl.user.action.admin;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.Map;

import com.framework.Dao.CustomerDao;
import com.lyq.model.all.Customer;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.ssl.user.email.Config;
import com.ssl.user.email.MailSenderInfo;
import com.ssl.user.email.SimpleMailSender;
import com.ssl.user.tool.CheckCode;
import com.ssl.user.tool.Encode;
import com.ssl.user.tool.SMSend;

public class CustomerAccountUpdateAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String mobile;
	private String randomCode;
	private String newPassword;
	private String currentPassword;
	private String reNewPassword;
	
	private String currentMobile;
	private String newMobile;
	private String newUserName ;
	
	
	
	private String currentEmail;
	private String newEmail;
	
	
	
	

	public String getCurrentEmail() {
		return currentEmail;
	}

	public void setCurrentEmail(String currentEmail) {
		this.currentEmail = currentEmail;
	}

	public String getNewEmail() {
		return newEmail;
	}

	public void setNewEmail(String newEmail) {
		this.newEmail = newEmail;
	}

	private  Timestamp registerTime;
	
	private String message;
	private boolean success;
	private Map<String, Object> session = ActionContext.getContext()
			.getSession();

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getRandomCode() {
		return randomCode;
	}

	public void setRandomCode(String randomCode) {
		this.randomCode = randomCode;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
	
		

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getNewUserName() {
		return newUserName;
	}

	public void setNewUserName(String newUserName) {
		this.newUserName = newUserName;
	}
	
	

	public String getCurrentMobile() {
		return currentMobile;
	}

	public void setCurrentMobile(String currentMobile) {
		this.currentMobile = currentMobile;
	}
	
	
	

	public String getNewMobile() {
		return newMobile;
	}

	public void setNewMobile(String newMobile) {
		this.newMobile = newMobile;
	}
	
	

	public String getCurrentPassword() {
		return currentPassword;
	}

	public void setCurrentPassword(String currentPassword) {
		this.currentPassword = currentPassword;
	}
	
	

	public String getReNewPassword() {
		return reNewPassword;
	}

	public void setReNewPassword(String reNewPassword) {
		this.reNewPassword = reNewPassword;
	}
	
	
	

	/**
	 * 修改信息之前检测一下此用户是否存在
	 * 
	 * @return
	 */
	/*public String CheckUpdateMobile() {

		CustomerDao cd = new CustomerDao();
		Customer c = cd.findByMobile(this.getCurrentMobile());
		if (c != null) {
			message = "用户存在！";
			success = true;
		} else {
			message = "用户不存在！";
			success = false;
		}

		return SUCCESS;
	}
	*/
	
	public Timestamp getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Timestamp registerTime) {
		this.registerTime = registerTime;
	}
	
	
	//第一步:检查用户名
	
	public String checkUserName(){
        CustomerDao customerDao = new CustomerDao();	
		Customer customer = customerDao.findByUserName((String)session.get("login_username"));
		System.out.println("____________login_username- "+session.get("login_username"));
		System.out.println(customer);
		if(customer!=null){
			String newUserName =this.getNewUserName();
			if(newUserName.length()!=0){
			Customer tmp =customerDao.findByUserName(newUserName);
			
			if(tmp!=null){
				
				success =false;
				message="此用户名已在数据库中被占用，请更换！";
			}else {
				success=true;
				message="用户名可用";
			}
			}else {
				success=false;
				message="输入新用户名为空！";
			}
			
			
		}else {
			success=false;
			message="非法操作！";
		}
				
		return SUCCESS;
			
		
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
	

	/**
	 * 进行修改手机号的操作，第一步：检测当前手机号输入是否正确
	 */
	
	public String checkCurrentMobile(){
		
		CustomerDao customerDao =new CustomerDao();
		Customer customer =customerDao.findByUserName((String)session.get("login_username"));
		
		
		
		
		String currentMobile = this.getCurrentMobile();
		if(currentMobile.length()!=11){
			success=false;
			message="输入号码没有11位，长度错误";
			
		}else if (currentMobile.length()!=0&&currentMobile.equals(customer.getMobile())){
			
			success=true;
			message="输入正确！";		
		
		}else {
			success =false;
			message="输入手机号不正确！";
		}
		
		if(customer.getMobile()==null){
			success=true;
			message="当前没有绑定手机号";
		}
		
		return SUCCESS;
		
	}
	
	
	/**
	 * 进行修改手机号的操作，第二步：检测新输入手机号是否正确
	 */
	public String checkNewMobile(){
		CustomerDao customerDao =new CustomerDao();
		Customer customer =customerDao.findByUserName((String)session.get("login_username"));		
		String newMobile=this.getNewMobile();
		Customer templateCustomer =customerDao.findByMobile(newMobile);
				
		if(newMobile.length()!=11){
			success=false;
			message="输入号码没有11位，长度错误";
			
		}else if(customer.getMobile()!=null&&newMobile.equals(customer.getMobile())){
			success=false;
			message="两次输入一致，无需更改！";
			
		}else if(templateCustomer!=null){
			
			success=false;
			message="输入新的手机号已经存在数据库中，请更换";
			
		}else {
			success=true;
			message="输入新手机号正确";
		}
		
		
		return SUCCESS;
		
	}
	

	/**
	 * 进行修改手机号的操作，第三步：发送验证码
	 * 
	 * @return
	 * @throws IOException
	 * @throws NoSuchAlgorithmException
	 */
	public String sendUpdateCheckCode() throws NoSuchAlgorithmException,
			IOException {

		CustomerDao cd = new CustomerDao();
		Customer c = cd.findByUserName((String)session.get("login_username"));// 通过用户名，查询到该用户的信息
		SMSend sms = new SMSend();
		System.out.println(c);
		sms.setMobileNO(this.getNewMobile());
		String randomCode = CheckCode.CheckCode();
		ActionContext actionContext = ActionContext.getContext();// 用session保存验证码
		session = actionContext.getSession();
		System.out.println(randomCode);
		session.put("updateCheckCode", randomCode);
		sms.setMobileNO(this.getNewMobile());
		String upadateMessage = "用户" + c.getUserName()
				+ "your random code is ["
				+ randomCode + "]";
		sms.setMessage(upadateMessage);
		sms.setAction("SendSms");
		sms.setPassword("l123454321");
		sms.setUrl("http://www.72dns.com/smsadmin/Sms_Api.aspx?");
		sms.setUserID("5998");
		String type = sms.sendMessage();
		System.out.println(sms.CheckSendState(type));
		
		success=true;
		message="发送成功！";
		
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
			message = "手机号修改成功！";
			session.remove("updateCheckCode");

		}else {
			
			success=false;
			message="验证码有误，请重新提交！";
		}

		return SUCCESS;
	}
	
	
	
	/**
	 * 修改用户密码，第一步：输入原密码。验证是否正确。
	 */
	public String checkCurrentPassword(){
		
		String currentPassword =this.getCurrentPassword();
		CustomerDao customerDao =new CustomerDao();
		Customer customer =customerDao.findByUserName((String)session.get("login_username"));
		
		
		int encry = customer.getEncry();
		Encode encode = new Encode();
		encode.setSalt(encry);
		System.out.println("currentPassword---------"+currentPassword);
		String encodePassword = encode.encodeByMD5(currentPassword, encry);
		if(encodePassword.equals(customer.getPassword()))
		{
			success=true;
			message="输入原密码正确！";
		}else{
			success=false;
			message="输入原密码不正确，请重新输入！";
		}
				
		return SUCCESS;	
		
	}
	
	/**
	 * 修改用户密码，第二步：输入新密码。验证是否正确。
	 * @return
	 */
	
	public String checkNewPassword(){
		
		if(this.getCurrentPassword().length()!=0&&this.getCurrentPassword().equals(this.getNewPassword())){
			success=false;
			message="输入新密码和原密码相同，请重新输入";					
		}else if(this.getNewPassword().length()==0){
			success=false;
			message="输入新密码为空，请重新输入";
			
		}
		else{
			success=true;
			message="输入正确";
		}
		
		return SUCCESS;
	}
	
	/**
	 * 修改用户密码：第三步:再次输入新密码。验证是否正确
	 */
	public String recheckNewPassword(){
		
		
		String reNewPassword =this.getReNewPassword();
		String newPassword =this.getNewPassword();
		if(newPassword.length()!=0){
		if(newPassword.equals(reNewPassword)){
			success =true;
			message="重新输入正确!";
		}
		else {
			success=false;
			message="输入错误！请重新输入";
		}
		}else {
			success=false;
			message="重新输入为空！";
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
	 * 修改用户邮箱的操作，第一步：检测当前邮箱号输入是否正确
	 */
	
	
	
	public String checkCurrentEmail(){
		
		CustomerDao customerDao =new CustomerDao();
		Customer customer =customerDao.findByUserName((String)session.get("login_username"));
		
		String currentEmail = this.getCurrentEmail();

	    if (currentEmail.length()!=0&&currentEmail.equals(customer.getEmail())){
			
			success=true;
			message="输入正确！";		
		
		}else {
			success =false;
			message="输入邮箱不正确！";
		}
		
		if(customer.getEmail()==null){
			success=true;
			message="当前没有绑定邮箱";
		}
		
		return SUCCESS;
		
	}
	
	
	/**
	 * 进行修改邮箱的操作，第二步：检测新输入邮箱是否正确
	 */
	public String checkNewEmail(){
		CustomerDao customerDao =new CustomerDao();
		Customer customer =customerDao.findByUserName((String)session.get("login_username"));		
		String newEmail=this.getNewEmail();
		Customer templateCustomer =customerDao.findByEmail(newEmail);
		
		
		if(newEmail.equals(customer.getEmail())){
			success=false;
			message="两次输入一致，无需更改！";
			
		}else if(templateCustomer!=null){
			
			success=false;
			message="输入新的邮箱号已经存在数据库中，请更换";
			
		}else {
			success=true;
			message="输入新邮箱号正确";
		}
		
		
		return SUCCESS;
		
	}
	

	/**
	 * 进行修改邮箱的操作，第三步：发送验证码
	 * 
	 * @return
	 * @throws IOException
	 * @throws NoSuchAlgorithmException
	 */
	public String sendUpdateCheckCodeToEmail() throws NoSuchAlgorithmException,
			IOException {

		CustomerDao cd = new CustomerDao();
		Customer c = cd.findByUserName((String)session.get("login_username"));// 通过用户名，查询到该用户的信息
		
		
		
		MailSenderInfo mailInfo = new MailSenderInfo();
        mailInfo.setMailServerHost(Config.MailServerHost);
        mailInfo.setMailServerPort(Config.MailServerPort);
        mailInfo.setValidate(true);
        mailInfo.setFromAddress(Config.fromAddress);
       
        mailInfo.setToAddress(this.currentEmail);
        mailInfo.setUserName(Config.username);
        mailInfo.setPassword(Config.password);
        mailInfo.setSubject(Config.verify);
		
		String randomCode = CheckCode.CheckCode();
		ActionContext actionContext = ActionContext.getContext();// 用session保存验证码
		session = actionContext.getSession();
		System.out.println(randomCode);
		session.put("updateCheckCode", randomCode);
		
		String upadateMessage = "用户" + c.getUserName()
				+ "your random code is ["
				+ randomCode + "]";
		
		mailInfo.setContent(upadateMessage);
		SimpleMailSender.sendHtmlMail(mailInfo);
		
		success=true;
		message="发送成功！";
		return SUCCESS;

	}

	/*
	 * 进行修改邮箱的操作，第四步：检查验证码，成功提交
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
