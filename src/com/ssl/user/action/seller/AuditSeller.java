package com.ssl.user.action.seller;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.framework.Dao.CustomerDao;
import com.framework.Dao.StoreDao;
import com.framework.Dao.areaStoreDao;
import com.lyq.model.all.Customer;
import com.lyq.model.all.Store;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AuditSeller extends ActionSupport {
	
	//private String myfile;
	
	private String tel;
	
	private String mobile;
	
	private String address;
	
	
	private String  startTime;
	private String endTime;
	
	
	private Float shipPrice;//起送价格
	private Float shipFee;//配送费用
	
	private Integer maxpeople;
	
	private String[]  areaIds ;
	private String name;
	
	private String  categoryId;
	
	
	


	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	

	public String[] getAreaIds() {
		return areaIds;
	}

	public void setAreaIds(String[] areaIds) {
		this.areaIds = areaIds;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public Float getShipPrice() {
		return shipPrice;
	}

	public void setShipPrice(Float shipPrice) {
		this.shipPrice = shipPrice;
	}

	public Float getShipFee() {
		return shipFee;
	}

	public void setShipFee(Float shipFee) {
		this.shipFee = shipFee;
	}

	public Integer getMaxpeople() {
		return maxpeople;
	}

	public void setMaxpeople(Integer maxpeople) {
		this.maxpeople = maxpeople;
	}
	
	
	
	/**
	 * 上传店铺logo
	 */
	
	public String logo(){
		
		
		
		return SUCCESS;
		
		
	}
	
	Map<String, Object> session = ActionContext.getContext().getSession();
	
	
	/**
	 * 提交店铺审核信息,第一步：提交基本信息。
	 * @throws ParseException 
	 */
	public String auditSeller() throws ParseException{
		
		CustomerDao customerDao =  new CustomerDao() ;
		areaStoreDao areaStoreDao = new areaStoreDao();
		Customer customer =customerDao.findByUserName((String)session.get("login_username"));
		
		
		StoreDao storeDao = new StoreDao();	
		Store store = new Store();
				
		
		//String logo = this.getMyfile();
		String tel =this.getTel();
		String mobile =this.getMobile();
		String address =this.getAddress();
		
		Date startTime =this.StringToDate(this.startTime);
		Date endTime = this.StringToDate(this.endTime);
		
		Float shipPrice = new Float(this.getShipPrice());
		Float shipFee = new Float(this.getShipFee());
	
		Integer maxpeople =new Integer(this.getMaxpeople());
		//store.setLogo(logo);
		store.setAddress(address);
		store.setTel(tel);
		store.setName(this.getName());
		store.setMobile(mobile);
		store.setStartTime(new Integer((int) startTime.getTime()));
		store.setEndTime(new Integer((int)endTime.getTime()));
		store.setCrateTime(new Timestamp(System.currentTimeMillis()));
		store.setCategoryId(new Integer(this.getCategoryId()));
		System.out.println(this.getCategoryId()+"---------");
		
		store.setShipPrice(shipPrice);
		store.setShipFee(shipFee);
		store.setMaxpeople(maxpeople);
		store.setAudit(false);
		store.setSendorno(new Integer(0));
		store.setCustomer(customer);
		
		storeDao.save(store);
		
		areaStoreDao.insertCoverStore(this.getAreaIds(), store);
	
		customer.setStoreId(new Integer(store.getStoreId()));
		
			
		return SUCCESS;	
			
		
	}
	
	
	private Date StringToDate(String date) throws ParseException{
		
		SimpleDateFormat sdf =new SimpleDateFormat("HH:mm");
		
		return sdf.parse(date);
			
	}
	


}
