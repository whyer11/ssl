package com.ssl.user.xuanchuan;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.framework.Dao.AdvertDao;
import com.framework.Dao.CustomerDao;
import com.framework.Dao.DAOQuery;
import com.framework.Dao.StoreDao;
import com.lyq.model.all.Advert;
import com.lyq.model.all.Customer;
import com.lyq.model.all.Store;
import com.opensymphony.xwork2.ActionSupport;
import com.ssl.user.action.sms.SMS;
import com.ssl.user.email.Config;
import com.ssl.user.email.MailSenderInfo;
import com.ssl.user.email.SimpleMailSender;

public class EditorAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String address;
	private String subject;
	
	private String content;
	
	private Boolean  success;
	
	private String message;
	
	
	private String flag;
	
	private SimpleMailSender  sendEmail = new SimpleMailSender();
	private SMS sendMobile =new SMS();
	
	
	
	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String sendToEmail() {
		
		
		System.out.println("-----"+this.getAddress());

		MailSenderInfo mailInfo =new MailSenderInfo();
		
		mailInfo.setMailServerHost(Config.MailServerHost);
		mailInfo.setMailServerPort(Config.MailServerPort);
		mailInfo.setPassword(Config.password);
		mailInfo.setFromAddress(Config.fromAddress);
		mailInfo.setUserName(Config.username);
		mailInfo.setValidate(true);	
		
		mailInfo.setSubject(this.getSubject());
		mailInfo.setContent(this.getContent());
		mailInfo.setToAddress(this.getAddress());		
		sendEmail.sendHtmlMail(mailInfo);
		
		
		this.insertInAdvert();
		
		
		
		
			
		return SUCCESS;
	}

	private void insertInAdvert() {
		AdvertDao advertDao =new AdvertDao();
		Advert advert =new Advert();
		advert.setAddress(this.address);
		advert.setSubject(this.subject);
		advert.setType(this.flag);
		advert.setContent(this.content);
		
		Timestamp time =new Timestamp(System.currentTimeMillis());
		advert.setCreateTime(time);
		advertDao.save(advert);
	}


	public  String sendToMobile(){	
		
		sendMobile.sendSMS(Config.shujuUserName, 
				Config.shujuPassWord, this.address.replace(';', ','), "smsSend", this.content);		
		this.insertInAdvert();
		
		return SUCCESS;
	}

	
	public String execute(){
		System.out.println("------"+this.getFlag());
	
		return SUCCESS;
	}
	
	
	
}
