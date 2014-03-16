package com.ssl.user.action;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

import com.framework.Dao.AreaDao;
import com.framework.Dao.CustomerDao;
import com.lyq.model.all.Customer;
import com.lyq.util1.StringUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.ssl.user.tool.Encode;
import com.ssl.user.tool.SMSend;

public class SMSAction extends ActionSupport {
	/**
	 * 中国联动接口
	 */
	private static final long serialVersionUID = 1L;
	private SMSend sms = new SMSend();
	private String userName;


	private String randomCode;              
	private String mobileNO;
	private String password;
	private String message;
	private String action;
	private String last;
	private String rm;//发送短信后返回的信息
	private String nicknam;
	private String mobilenum;
	private String mobilephone_code;
	private Integer areaId;
	private String address;
	
	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public String getMobilephone_code() {
		return mobilephone_code;
	}

	public void setMobilephone_code(String mobilephone_code) {
		this.mobilephone_code = mobilephone_code;
	}

	public String getMobilenum() {
		return mobilenum;
	}

	public void setMobilenum(String mobilenum) {
		this.mobilenum = mobilenum;
	}

	public String getNicknam() {
		return nicknam;
	}

	public void setNicknam(String nicknam) {
		this.nicknam = nicknam;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRandomCode() {
		return randomCode;
	}

	public void setRandomCode(String randomCode) {
		this.randomCode = randomCode;
	}



	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	
	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public SMSend getSms() {
		return sms;
	}

	public void setSms(SMSend sms) {
		this.sms = sms;
	}

	public String getMobileNO() {
		return mobileNO;
	}

	public void setMobileNO(String mobileNO) {
		this.mobileNO = mobileNO;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
	
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	ActionContext actionContext = ActionContext.getContext();
    Map<String, Object> session = actionContext.getSession();
	
	public String sendMessage() throws IOException, NoSuchAlgorithmException{
		
		String randomCode= StringUtil.getCheckCode();
		System.out.println("the random code is "+randomCode);
		sms.setAction("SendSms");

        session.put("randomCode", randomCode);
        String random="your random code is ["
				+ randomCode + "]";
        
		sms.setMessage(random);
		sms.setMobileNO(this.mobileNO);
		sms.setPassword("l123454321");
		sms.setUserID("5998");
		sms.setUrl("http://www.72dns.com/smsadmin/Sms_Api.aspx?");
		sms.lastMessage();
		String returnState = sms.sendMessage();
		System.out.println(sms.CheckSendState(returnState));
			
		return "checkCode";
		
	}
	
	
	public String regSuccess(){
		
        String s1=(String) session.get("randomCode");
      
		if(s1!=null&&s1.equals(mobilephone_code)){
		Customer _customer=new Customer();
		CustomerDao cusDao=new CustomerDao();
		
		AreaDao areaDao = new AreaDao();
		Encode encode = new Encode();
		// c.setEmail(email);
		int salt=(int) System.currentTimeMillis();
		Timestamp registerTime = new Timestamp(new Date().getTime());
		_customer.setRegisterTime(registerTime);
		// 將salt轉換為String
		
		_customer.setEncry(salt);
		encode.setSalt(salt);
		_customer.setPassword(encode.encodeByMD5(this.getPassword(), salt));
		_customer.setUserName(this.getNicknam());
		_customer.setMobile(this.getMobilenum());
		
		_customer.setLastTime(registerTime);
		_customer.setScore(0);
		_customer.setLastVisit(registerTime);
		_customer.setType(false);//设置会员类型为买家
		
		if(this.areaId!=null)
		_customer.setArea(areaDao.selectById(this.areaId));
		_customer.setAddress(this.getAddress());
		if(session.get("login_username")!=null)
		session.remove("login_username");
		session.put("login_username", this.getNicknam());
		
		cusDao.save(_customer);
		}
		
		return "success";
	}
	

	

}
