package com.ssl.user.action.seller;

import java.util.Map;

import com.framework.Dao.CustomerDao;
import com.lyq.model.all.Customer;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class JoinAction extends ActionSupport {
	
	private boolean success;
	
	
	private String message;
	
	private Map<String, Object> session = ActionContext.getContext()
			.getSession();

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

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	
	public String join ()
	{
		
		CustomerDao customerDao = new CustomerDao();
		
		Customer customer=customerDao.findByUserName((String)session.get("login_username"));
		
		
		if(customer!=null&&customer.getType()!=null&&customer.getType())
		{
			success=true;
			message="跳转成功！";
			return "seller";
		}else {
			success=true;
			message="你还未通过审核，正在跳转到会员中心！";
			return "buyer";
		}
		
		
	}
	
	/**
	 * 退出登录
	 */
	public  String logout(){
				
		session.clear();
		success=true;
		message="session 已经清空！";
		System.out.println("session 已经清空！");		
		return SUCCESS;
		
	}
	
	

}
