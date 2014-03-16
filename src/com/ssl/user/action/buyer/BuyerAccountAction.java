package com.ssl.user.action.buyer;

import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.framework.Dao.CustomerDao;
import com.lyq.model.all.Customer;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class BuyerAccountAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String userName;
	
	private String mobile;
	
	private String password;
	private String email;
	
	private Map<String ,Object> session =ActionContext.getContext().getSession();

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String account(){
		ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
		this.userName=(String)session.get("login_username");
		CustomerDao customerDao = new CustomerDao();
		Customer customer = customerDao.findByUserName(this.userName);
		
		String tem=customer.getMobile();
		this.email=customer.getEmail();
		System.out.println("-----"+customer.getEmail());
		if(tem.length()!=0)
		this.mobile=tem.substring(0, 2)+"******"+tem.substring(8, 11);
		else this.mobile=null;
		this.password=customer.getPassword();
		
		return SUCCESS;
	}
	
	
	
	

}
