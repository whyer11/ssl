package com.ssl.user.action.seller;

import java.util.Map;

import com.framework.Dao.CustomerDao;
import com.lyq.model.all.Customer;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CustomerIndexAction extends ActionSupport {
	
	private Map<String, Object> session = null;
	
	
	


	/**
	 * 通过用户类型分发到不同的页面
	 * @return
	 */
	public String  index(){
		session = ActionContext.getContext()
				.getSession();
		
		CustomerDao customerDao = new CustomerDao();
		Customer customer =customerDao.findByUserName((String)session.get("login_username"));
		System.out.println(customer);
		
		if(customer!=null&&customer.getType()!=null&&customer.getType())
		{
			
			return "seller";
		}
		
		else 
			return "buyer";
			
		
	} 
	
	
	

}
