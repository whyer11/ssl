 package com.ssl.user.action.admin;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.framework.Dao.CustomerDao;
import com.lyq.model.all.Customer;
import com.opensymphony.xwork2.ActionSupport;

public class CustomerStateAction extends ActionSupport {

	/**
	 * 状态为1表示未审核，
	 * 状态为2表示已审核，
	 * 状态为3表示已删除。
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String delete;
	
	
	private String work;
	
	
	private String detail;
	
	
	private String customerId;
	
	
	private HttpServletRequest request = ServletActionContext.getRequest ();  

	public String getCustomerId() {
		return customerId;
	}


	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}


	public String getDelete() {
		return delete;
	}


	public void setDelete(String delete) {
		this.delete = delete;
	}


	public String getWork() {
		return work;
	}


	public void setWork(String work) {
		this.work = work;
	}


	public String getDetail() {
		return detail;
	}


	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	
	public String delete(){
		
		CustomerDao customerDao = new CustomerDao();
		String deleteString  =request.getParameter("delete");
		System.out.println(deleteString);
		
		Customer customer =customerDao.selectById(new Integer(deleteString));
		
		customer.setState(new Short((short)3));
		
		customerDao.save(customer);	
		
		return SUCCESS;			
		
	}
	
	public String detail (){
		
		return SUCCESS;
				
		
	}
	
	public String work(){
		
       CustomerDao customerDao = new CustomerDao();
     
       
       String workString=request.getParameter("work");
 
       
		Customer customer =customerDao.selectById(new Integer( workString));
		
		customer.setState(new Short((short)2));
		
		customerDao.save(customer);
		
		
		return SUCCESS;
		
	}
	
	
	
	
	
	
	

}
