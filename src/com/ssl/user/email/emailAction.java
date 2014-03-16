package com.ssl.user.email;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.framework.Dao.AreaDao;
import com.framework.Dao.CustomerDao;
import com.framework.Dao.DAOQuery;
import com.framework.Dao.MailDao;
import com.lyq.model.all.Customer;
import com.lyq.model.all.Mail;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.ssl.user.tool.Encode;

public class emailAction extends ActionSupport {
	
	private String email;
	
	private String username;
	private String password;
	
	private String repassword;
	
	private Integer areaId ;
	private String address;
	
	
	public Integer getAreaId() {
		return areaId;
	}



	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}



	private String message="";
	
	private boolean success;
	
	private HttpServletRequest request = ServletActionContext.getRequest (); 
	private Map<String, Object> session =ActionContext.getContext().getSession();
	
	
	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



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

	

	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	/**
	 * 第一步:检查邮箱是否存在
	 * 
	 */
	
	public String checkEmail(){
		
		CustomerDao cd = new CustomerDao();
		DAOQuery dq = new DAOQuery();
		dq.set_whereClause("email=:email");
		HashMap<String, Object> map1 = new HashMap<String, Object>();
		map1.put("email", this.getEmail());
		dq.set_parameters(map1);
		if (cd.select(dq).size() != 0){
			message = "邮箱已被占用";
			success=false;
		}
			
		else{
			message = "邮箱可用";
			
			success=true;
		}
			
		return SUCCESS;
		
		
	}
	
	/**
	 * 第二步：检查用户名是否可用
	 */
	
	
	
	public String checkUserName(){
		
		CustomerDao cd = new CustomerDao();
		DAOQuery dq = new DAOQuery();
		dq.set_whereClause("userName=:UserName");
		HashMap<String, Object> map1 = new HashMap<String, Object>();
		map1.put("UserName", this.getUsername());
		dq.set_parameters(map1);
		if (cd.select(dq).size() != 0){
			message = "邮箱已被占用";
			success=false;
		}
			
		else{
			message = "邮箱可用";		
			success=true;
		}
		return SUCCESS;
		
		
	}
	
	/**
	 * 第三步：检查重复输入密码是否一致
	 */
	
	public String checkNewpassWord(){	
		
		if(this.getPassword().equals(this.getRepassword())){
			success=true;
			message="输入正确！";					
		}else if(this.getRepassword().length()==0){
			success=false;
			message="请输入重复密码！";
			
		}
		else{
			success=false;
			message="输入错误！";
		}
		
		return SUCCESS;
	}
	
	
	/**
	 * 第四步：提交：发送信息到邮箱，把数据存入临时表
	 */
	public  String sendToMailBox(){
		
		MailSenderInfo mailInfo = new MailSenderInfo();
        mailInfo.setMailServerHost(Config.MailServerHost);
        mailInfo.setMailServerPort(Config.MailServerPort);
        mailInfo.setValidate(true);
        mailInfo.setFromAddress(Config.fromAddress);
        System.out.println("----toaddress---"+this.email);
        mailInfo.setToAddress(this.email);
        mailInfo.setUserName(Config.username);
        mailInfo.setPassword(Config.password);
        mailInfo.setSubject(Config.verify);
        
    	int salt=(int) System.currentTimeMillis();
        
             
        MailDao mailDao = new MailDao();       
        Mail mail=this.SetMail(this.getUsername(), this.getPassword(), this.getEmail(),salt,this.getAreaId(),this.getAddress());
        mailDao.save(mail);        
        mailInfo.setContent(this.checkUrl(Config.mailBoxUrl,mail.getMailId(),salt));
        boolean isSend =   SimpleMailSender.sendHtmlMail(mailInfo);
       

        success=true;
        message="发送验证邮箱成功！";
        
		return SUCCESS;
		
	}
	
	
	/**
	 * 第五步：注册激活，提交到Customer表
	 */
	
	public  String  ReSuccess(){
		
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String email=request.getParameter("email");	
		int id = Integer.parseInt(request.getParameter("mailId"));
		System.out.println(id+"----------");
		success=this.checkInfor(username, password, email, id);

		if(success){
			MailDao mailDao = new MailDao();
			
			Mail mail =mailDao.selectById(id);		
			
			success=this.insertCustomer(mail);	
			mailDao.delete(mail);
			if(session.get("login_username")!=null)
			session.remove("login_username");
			session.put("login_username", username);
		}
		
		
		
		return SUCCESS;
		
	}
	
	
	
	private boolean insertCustomer(Mail mail){
		
		int mailId=mail.getMailId();
		
		Customer _customer=new Customer();
		CustomerDao cusDao=new CustomerDao();
		AreaDao areaDao = new AreaDao();

		// c.setEmail(email);
	
		Timestamp registerTime = new Timestamp(new Date().getTime());
		_customer.setRegisterTime(registerTime);
		// 將salt轉換為String
		
		_customer.setEncry(mail.getSalt());
		
		_customer.setUserName(mail.getUsername());
		_customer.setPassword(mail.getPassword());
		_customer.setEmail(mail.getEmail());
		
		_customer.setLastTime(registerTime);
		_customer.setScore(0);
		_customer.setLastVisit(registerTime);
		_customer.setType(false);//设置会员类型为买家
		
		
		
		_customer.setArea(areaDao.selectById(mail.getAreaId()));
		_customer.setAddress(mail.getAddress());
		cusDao.save(_customer);
		if(_customer.getCustomerId()!=null) return true;
		
		else return false;	
		
	}
	
	
	private String encry(String code,int salt){
		Encode encode = new Encode();
		return encode.encodeByMD5(code, salt);		
	}
	
	private Mail SetMail(String username,String password,String email,int salt,int areaId,String address){
		
		Mail mail = new Mail();
		mail.setEmail(email);
		mail.setPassword(this.encry(password,salt));
		mail.setUsername(username);
		mail.setSalt(salt);
		mail.setAreaId(areaId);
		mail.setAddress(address);
		return mail;	
	}
	
	private String checkUrl(String url,int id,int salt){
		
		
		String temp1="您好！你正在进行南京送送乐公司邮箱激活注册信息的操作";
		String tempUrl= url+"user/jihuo_ReSuccess.html?username="+this.getUsername()+
				"&password="+this.encry(this.getPassword(),salt)+
				"&email="+this.getEmail()+"&mailId="+id+"&areaId="+this.getAreaId()+"&address="+this.getAddress();
		
		System.out.println(tempUrl);
		
		return temp1+ "<a href="+tempUrl+">点击激活</a><br>"
				+ "如果点击失效，请将【】中的链接粘贴在浏览器地址栏中，回车进行激活【"
				+tempUrl+"】";
	}
	
	
	
	private boolean checkInfor(String username,String password,String email,int id ){
		
		
		boolean flag=false;
		
		MailDao mailDao = new MailDao();
		Mail mail =mailDao.selectById(id);
		
		if(mail!=null){
		if(username.equals(mail.getUsername()))   flag=true;
		
		if(password.equals(mail.getPassword()))   flag=true;
		
		if(email.equals(mail.getEmail()))         flag =true;	
			
		}
		return flag;
	
	}
	
	
	

}
