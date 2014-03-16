package com.ssl.user.action;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.framework.Dao.CustomerDao;
import com.framework.Dao.DAOQuery;
import com.lyq.model.all.Customer;
import com.opensymphony.xwork2.ActionSupport;
import com.ssl.user.tool.CheckCode;
import com.ssl.user.tool.CheckUserNameType;
import com.ssl.user.tool.Encode;

public class CustomerAction extends ActionSupport {

	private String userName;
	private String password;
	private String mobileNO;
	private Integer customerId;
	private String realName;
	private Short state;
	private Integer score;
	private String avatar;
	private String sex;
	private Date birthday;
	private Timestamp lastVisit;
	private Timestamp registerTime;
	private Timestamp lastTime;
	private Timestamp encry; // 加密salt
	private String email;


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

	public Short getState() {
		return state;
	}

	public void setState(Short state) {
		this.state = state;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Timestamp getLastVisit() {
		return lastVisit;
	}

	public void setLastVisit(Timestamp lastVisit) {
		this.lastVisit = lastVisit;
	}

	public Timestamp getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Timestamp registerTime) {
		this.registerTime = registerTime;
	}

	public Timestamp getLastTime() {
		return lastTime;
	}

	public void setLastTime(Timestamp lastTime) {
		this.lastTime = lastTime;
	}

	public Timestamp getEncry() {
		return encry;
	}

	public void setEncry(Timestamp encry) {
		this.encry = encry;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public String getMobileNO() {
		return mobileNO;
	}

	public void setMobileNO(String mobileNO) {
		this.mobileNO = mobileNO;
	}

	private String message = "";
	private boolean success = false;
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



	public String login() {
		CustomerDao cd = new CustomerDao();
		Encode encode = new Encode();
		Customer c = new Customer();
		System.out.println(this.getUserName() + "  " + this.getPassword());
		int ca =CheckUserNameType.UserNameType(this.getUserName());
		switch(ca){
		case 3 :
			c = cd.findByUserName(this.getUserName());

			if (c != null) {
				if (encode.authenticatePassword(c.getPassword(),
						this.getPassword()))
				{   message="登陆成功！";
					
					}
				else {
					message="登陆失败！";
					
				}
			
		}
			
		case 2 : 
			c = cd.findByMobile(this.getUserName());
			if (c != null) {
				if (encode.authenticatePassword(c.getPassword(),
						this.getPassword())){
					  message="登陆成功！";
					
					}
				else{
					  message="登陆失败！";
					
				}
			}
				
				case 1 :
					c = cd.findByEmail(this.getUserName());
					if (c != null) {
						if (encode.authenticatePassword(c.getPassword(),
								this.getPassword())){
							  message="登陆成功！";
							
							}
						else{
							  message="登陆失败！";
							
						}
					}
							
					}
		        message="登陆成功";
			
					System.out.println(message);
					return SUCCESS;
  	    
	}

	public String getCheckCode() {
		String s = "";
		s = CheckCode.CheckCode();
		System.out.println(s);
		return SUCCESS;

	}



	// 检查用户名是否存在
	public String checkUserName() {
		CustomerDao cd = new CustomerDao();
		DAOQuery dq = new DAOQuery();
		dq.set_whereClause("userName=:UserName");
		HashMap<String, Object> map1 = new HashMap<String, Object>();
		map1.put("UserName", this.getUserName());
		dq.set_parameters(map1);
		if (cd.select(dq).size() != 0)
		{
			message = "fail";
			success =false;
		}
		else
		{
			message = "succ";
			success = true;
		}
		return SUCCESS;

	}

	// 检查手机号是否存在
	public String checkMobileNO() {
		System.out.println(this.getMobileNO());

		CustomerDao cd = new CustomerDao();
		DAOQuery dq = new DAOQuery();
		dq.set_whereClause("mobile=:mobile");
		Map<String ,Object> map2 = new HashMap<String, Object>();
		if(this.getMobileNO().length()!=11) message="fail";
		map2.put("mobile", this.getMobileNO());
		dq.set_parameters(map2);
		
		if (cd.select(dq) .size()!= 0)
		{
			message = "fail";
			success = false;
		}
		else{
			message = "succ";
			success = true;}
		return SUCCESS;
	}

	// 检查邮箱号是否存在
	public String checkEmail() {
		CustomerDao cd = new CustomerDao();
		DAOQuery dq = new DAOQuery();
		dq.set_whereClause("email=:email");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("email", this.getEmail());
		dq.set_parameters(params);
		if (cd.select(dq).size() != 0)  { 
			message = "fail";
			success = false;}
		else{
			message= "succ";
			success = true;}
		return SUCCESS;
	}

	
	public String updateCustomer(Customer c) {
		CustomerDao cd = new CustomerDao();
		c.setAvatar(this.getAvatar());
		c.setBirthday(this.getBirthday());
		c.setEmail(this.getEmail());
		c.setLastTime(this.getLastTime());
		c.setLastVisit(this.getLastVisit());
		c.setMobile(this.getMobileNO());
		Encode encode = new Encode();
		   int salt =c.getEncry();
		c.setPassword(encode.encodeByMD5(this.getPassword(), salt));
		c.setRealName(this.getRealName());
		c.setScore(this.getScore());
		c.setSex(this.getSex());
		c.setState(this.getState());
		c.setUserName(this.getUserName());
		cd.update(c);
		return SUCCESS;
	}

	// 通过验证码修改用户密码
	private String newPassWord;

	public String getNewPassWord() {
		return newPassWord;
	}

	public void setNewPassWord(String newPassWord) {
		this.newPassWord = newPassWord;
	}

	
}
