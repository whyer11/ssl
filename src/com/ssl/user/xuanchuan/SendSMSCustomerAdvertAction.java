package com.ssl.user.xuanchuan;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.framework.Dao.AreaDao;
import com.framework.Dao.CustomerDao;
import com.lyq.model.all.Area;
import com.lyq.model.all.Customer;
import com.opensymphony.xwork2.ActionSupport;
import com.ssl.user.xuanchuan.mode.CustomerMode;


public class SendSMSCustomerAdvertAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String type ;//区分是会员还是店铺
	private Integer customerId;
	private Integer areaId;
	private String sex;	
	private String realName;
	private String userName;
	private String  areaString;
	private Date birthday;
	private Integer score;
	private String mobile;
	
	public List<CustomerMode> getCustomerList() {
		return customerList;
	}
	public void setCustomerList(List<CustomerMode> customerList) {
		this.customerList = customerList;
	}

	private int pageSize=8;
	private int pageNumber;
	private int totalPage;
	private List<CustomerMode> customerList =new ArrayList<CustomerMode>(); 
	private CustomerDao customerDao=new CustomerDao();
	private HttpServletRequest request = ServletActionContext.getRequest ();	
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAreaString() {
		return areaString;
	}
	public void setAreaString(String areaString) {
		this.areaString = areaString;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	
	
	public Integer getAreaId() {
		return areaId;
	}
	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}
	public String show(){
		
		this.pageNumber=1;
		String pageNumberString=request.getParameter("pageNumber");
		if(pageNumberString!=null) this.pageNumber=Integer.parseInt(pageNumberString);
		
		this.sex=request.getParameter("sex");
		this.areaId=Integer.parseInt(request.getParameter("areaId"));
		this.totalPage=((this.customerDao.findALL(this.sex,this.areaId)).size()-1)/this.pageSize+1;		
		customerList=this.parseToCustomer(
				customerDao.findAll(this.pageSize,this.pageNumber, this.sex,this.areaId));	
		
		return SUCCESS;
		
	}
	@SuppressWarnings("null")
	private List<CustomerMode> parseToCustomer(List<Customer> lc){
		List<CustomerMode> lcm=new ArrayList<CustomerMode>();	
		
		for(Customer customer :lc){
			CustomerMode customerMode=new CustomerMode();
			customerMode.setAreaString(this.parseToAreaString(customer.getArea()));	
			
			customerMode.setBirthday(customer.getBirthday());
			
			customerMode.setCustomerId(customer.getCustomerId());
			
			
			customerMode.setEmail(customer.getEmail());
			
			customerMode.setMobile(customer.getMobile());
			
			customerMode.setRealName(customer.getRealName());
			
			customerMode.setScore(customer.getScore());
			
			customerMode.setSex(customer.getSex());	
			
			customerMode.setUserName(customer.getUserName());
			
			lcm.add(customerMode);
		}	
		return lcm;
		
	}
	
	private String parseToAreaString(Area area){
		AreaDao areaDao =new AreaDao();
		Area area2= areaDao.getSupAreaByArea(area);
		Area area3=areaDao.getSupAreaByArea(area2);
		

		return area3.getName()+","+area2.getName()+","+area.getName();
		
	}
	
	
	
	
	

}
