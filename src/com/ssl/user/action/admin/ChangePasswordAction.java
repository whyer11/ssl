package com.ssl.user.action.admin;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import com.framework.Dao.CustomerDao;
import com.lyq.model.all.Customer;
import com.lyq.util1.StringUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.ssl.user.email.Config;
import com.ssl.user.email.MailSenderInfo;
import com.ssl.user.email.SimpleMailSender;
import com.ssl.user.tool.CheckUserNameType;
import com.ssl.user.tool.Encode;
import com.ssl.user.tool.SMSend;

public class ChangePasswordAction extends ActionSupport {
	
	/**
	 * 1邮箱，2电话，3昵称
	 */
	
	
	private String emo;
	
	
	private String message;
	
	private boolean success;
	
	private String randomCode;
	
	private String password;
	
	private String repassword;
	
	
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	public String getRandomCode() {
		return randomCode;
	}

	public void setRandomCode(String randomCode) {
		this.randomCode = randomCode;
	}



	private Map<String, Object> session = ActionContext.getContext().getSession();
	
	
	private Map<String ,Object> map=new HashMap<String, Object>();

	public String getEmo() {
		return emo;
	}

	public void setEmo(String emo) {
		this.emo = emo;
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
	
	
	@SuppressWarnings({ "unused", "unchecked" })
	private Map  UsernameType(Map map,String emo){
		CustomerDao customerDao =  new CustomerDao();		
		
		
		int ca =CheckUserNameType.UserNameType((String)map.get("emo"));
		
		if(ca==1){
			
			map.put("type", 1);
			session.put("Customer", customerDao.findByEmail(emo));
			System.out.println("----email-----"+session.get("Customer"));
		}
			
		else if(ca==2){
			map.put("type", 2);
			session.put("Customer", customerDao.findByMobile(emo));
			System.out.println("----mobile-----"+session.get("Customer"));
		}else map=null;
		return map;		
	}
	
	/**
	 * 找回密码第一步：检查输入的字段是否在数据库中存在
	 */
	
	public  String checkEmo()
	{
		
		this.map.put("emo", this.emo);
	    Map map=this.UsernameType(this.map,this.emo);
			
			if(map!=null){
			success=true;
			if(((Integer)map.get("type")).intValue()==1&&session.get("Customer")!=null) message="此邮箱存在数据库中！操作合法！";
			else if(((Integer)map.get("type")).intValue()==2&&session.get("Customer")!=null)
				
		          message="此手机号存在数据库中！操作合法！";
			else 
			{

				success=false;
				message="输入手机号或者邮箱有误，请重新输入！";
				
			}
			
			}
		
		else 
		{
			success=false;
			message="输入手机号或者邮箱有误，请重新输入！";
		}
		
		return SUCCESS;
	}
	
	
	
	/**
	 * 找回密码第二步：利用邮箱或者手机发送验证码
	 * @throws NoSuchAlgorithmException 
	 * @throws IOException 
	 */
	private boolean SendToMobile(String emo,String Info) throws NoSuchAlgorithmException, IOException
	
	{
		
		SMSend sms = new SMSend();
		sms.setAction("SendSms");
		sms.setMessage(Info);
		sms.setMobileNO(emo);
		sms.setPassword("l123454321");
		sms.setUserID("5998");
		sms.setUrl("http://www.72dns.com/smsadmin/Sms_Api.aspx?");
		sms.lastMessage();
		String returnState = sms.sendMessage();
		System.out.println(sms.CheckSendState(returnState));	
		return true;
	}
	
	
	private boolean sendToMailBox(String emo,String Info)
	{
		MailSenderInfo mailInfo = new MailSenderInfo();
        mailInfo.setMailServerHost(Config.MailServerHost);
        mailInfo.setMailServerPort(Config.MailServerPort);
        mailInfo.setValidate(true);
        mailInfo.setFromAddress(Config.fromAddress);
      
        mailInfo.setToAddress(emo);
        mailInfo.setUserName(Config.username);
        mailInfo.setPassword(Config.password);
        mailInfo.setSubject(Config.verify);
        
        
        mailInfo.setContent(Info);
        boolean isSend =   SimpleMailSender.sendTextMail(mailInfo);
		
		return true ;
		
		
	}
	
	
	
	public String sendRandomCode() 
	{
		
		try {
			String randomCode =StringUtil.getCheckCode();
			System.out.println("-----"+randomCode);
			session.put("randomCode", randomCode);
			String Info="用户" 
					+ "your random code is：["
					+ randomCode + "]";
		
			
			this.map.put("emo", this.emo);
			Map map=this.UsernameType(this.map,this.emo);
			if(map!=null){						
				if(((Integer)map.get("type")).intValue()==1)  this.sendToMailBox(this.emo, Info);
				
				if(((Integer)map.get("type")).intValue()==2) this.SendToMobile(this.emo, Info);
				
			}
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		return "next";
		
	}
	
	
	
	public String resetPassword(){
		
		success=this.checkReset(this.randomCode, this.password, this.repassword);
		if(success){
			CustomerDao customerDao =new CustomerDao();
			Customer customer=(Customer)session.get("Customer");
			System.out.println(customer);
			Encode encode= new Encode();
			customer.setPassword(encode.encodeByMD5(this.password,customer.getEncry()));
			session.clear();
			customerDao.save(customer);
			message="密码修改成功！！";
		}
		else {
			success=false;
			message="密码修改失败！！";
		}
			
		return "win";
	}
	
	
	@SuppressWarnings("unused")
	private boolean checkReset(String randomCode ,String password,String repassword){
		boolean flag=true;
		
		
		if(!(randomCode!=null&&randomCode.length()!=0&&randomCode.equals(session.get("randomCode")))) flag=false;
		if(!(randomCode!=null&&randomCode.length()!=0&&password.equals(repassword)))flag=false;
		return flag;
		
		
	}
	
	

}
