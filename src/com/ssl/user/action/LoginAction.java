package com.ssl.user.action;

import java.sql.Timestamp;
import java.util.Map;

import com.framework.Dao.CustomerDao;
import com.lyq.model.all.Customer;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.ssl.user.tool.CheckUserNameType;
import com.ssl.user.tool.Encode;

public class LoginAction extends ActionSupport {
	private String login_username;

	private String login_password;
	private String message;
	private boolean success;
	private Map<String, Object> session = ActionContext.getContext()
			.getSession();

	public String getLogin_username() {
		return login_username;
	}

	public void setLogin_username(String login_username) {
		this.login_username = login_username;
	}

	public String getLogin_password() {
		return login_password;
	}

	public void setLogin_password(String login_password) {
		this.login_password = login_password;
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

	@SuppressWarnings("unused")
	public String execute() throws Exception {

		CustomerDao cd = new CustomerDao();
		Encode encode = new Encode();
		Customer c = new Customer();
		int ca = CheckUserNameType.UserNameType(this.getLogin_username());
		if (ca == 1) 
		{
			c = cd.findByEmail(this.getLogin_username());
		
			if (c == null) 
			{

				success = false;
				message = "登录失败";
				session.clear();

			}

			if (c != null) 
			{
				encode.setSalt(c.getEncry());

				if (encode.authenticatePassword(c.getPassword(),
						this.getLogin_password()))
				{
					success = true;
					message = "登陆成功";
					login_username=c.getUserName();
					session.put("login_username", login_username);
					c.setLastTime(new Timestamp(System.currentTimeMillis()));
				} else
				{
					success = false;
					message = "登陆失败";
					session.clear();
				}

			}
		}

		if (ca == 3) 
		{		
			c = cd.findByUserName(this.getLogin_username());
			if (c == null) 
			{

				success = false;
				message = "登录失败";
				session.clear();

			}

			if (c != null) 
			{
				encode.setSalt(c.getEncry());
				System.out.println(c.getEncry());
				System.out.println(encode.authenticatePassword(c.getPassword(),
						this.getLogin_password()));
				System.out.println(encode.encodeByMD5(this.getLogin_password(), c.getEncry()));

				if (encode.authenticatePassword(c.getPassword(),
						this.getLogin_password())) 
				{
					success = true;
					message = "登陆成功";
					session.put("login_username", login_username);
					c.setLastTime(new Timestamp(System.currentTimeMillis()));
					
				} else 
				{
					success = false;
					message = "登陆失败";
					session.clear();
				}

			}

		}
		if (ca == 2) 
		{
			c = cd.findByMobile(this.getLogin_username());
			if (c == null) 
			{
				success = false;
				message = "登陆失败";
				session.clear();
			}
			if (c != null)
			{

				encode.setSalt(c.getEncry());
				if (encode.authenticatePassword(c.getPassword(),
						this.getLogin_password())) 
				{
					success = true;
					message = "登陆成功";
					login_username = c.getUserName();
					session.put("login_username", login_username);
					c.setLastTime(new Timestamp(System.currentTimeMillis()));
				} else
				{
					success = false;
					message = "登陆失败!";
					session.clear();
				}
			}
		}
		

		return SUCCESS;

	}

}
