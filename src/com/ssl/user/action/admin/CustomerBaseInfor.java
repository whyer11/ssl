package com.ssl.user.action.admin;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.framework.Dao.AreaDao;
import com.framework.Dao.CustomerDao;
import com.lyq.model.all.Area;
import com.lyq.model.all.Customer;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CustomerBaseInfor extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String realName;
	
	private String  sex;
	
	private Integer  score;
	
	private Timestamp lastVisit;
	
	private Timestamp registerTime;
	
	private Date  birthday;
	
	private Area  city ;
	
	private Area  district;
	
	private Area street;
	
	private Integer areaId;
	
	
	private String areaString;
	
	
	private String avatar;
	
	private boolean success;
	
	private String message;
	
	
	public Integer getAreaId() {
		return areaId;
	}


	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}


	public String getAreaString() {
		return areaString;
	}


	public void setAreaString(String areaString) {
		this.areaString = areaString;
	}


	public String getRealName() {
		return realName;
	}


	public void setRealName(String realName) {
		this.realName = realName;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	


	public Integer getScore() {
		return score;
	}


	public void setScore(Integer score) {
		this.score = score;
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
	


	public Date getBirthday() {
		return birthday;
	}


	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}


	public Area getCity() {
		return city;
	}


	public void setCity(Area city) {
		this.city = city;
	}


	public Area getDistrict() {
		return district;
	}


	public void setDistrict(Area district) {
		this.district = district;
	}


	public Area getStreet() {
		return street;
	}


	public void setStreet(Area street) {
		this.street = street;
	}


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
	
	

	public String getAvatar() {
		return avatar;
	}


	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}


	public Map<String, Object> getSession() {
		return session;
	}


	public void setSession(Map<String, Object> session) {
		this.session = session;
	}


	private Map<String, Object> session = ActionContext.getContext()
			.getSession();

	
	/**
	 * 显示登陆时间，注册时间等信息。
	 */
	public String showBaseInfor(){
		
		SimpleDateFormat sdf1= new SimpleDateFormat("yyyy-MM-dd");
		
		AreaDao areaDao = new AreaDao();
		CustomerDao customerDao = new CustomerDao();
		Customer customer =customerDao.findByUserName((String)session.get("login_username"));
			
		if(customer!=null&&customer.getRealName()!=null)
		this.realName = customer.getRealName();
		if(customer.getSex()!=null)
		this.sex=customer.getSex();
		else this.sex="未知";
		if(customer!=null&&customer.getAvatar()!=null)
		this.avatar = customer.getAvatar();
		if(customer!=null&&customer.getBirthday()!=null)
		this.birthday=customer.getBirthday();
		
		Area area1=new Area();
		Area area2 =new Area();
		Area area3 =new Area();
		 area1=customer.getArea();	
		if(area1!=null)
		{
		area2=areaDao.getSupAreaByArea(area1);
		area3= areaDao.getSupAreaByArea(area2);
		
		this.areaString=area3.getName()+","+area2.getName()+","+area1.getName()+",";
		}else this.areaString="未知";

		//this.areaString="未知";
		if(customer.getAddress()!=null)
		this.areaString+=customer.getAddress();
		this.registerTime = customer.getRegisterTime();
		this.lastVisit    = customer.getLastTime();
		this.score        = customer.getScore();
		
		this.avatar =customer.getAvatar();
		
		return SUCCESS;
	}
	
	/**
	 * 基本信息进行表单提交
	 * @return
	 * @throws ParseException 
	 */
	public String updateBaseInfor() {
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
			CustomerDao customerDao =new CustomerDao();
			AreaDao areaDao = new AreaDao();
			
			Customer customer =customerDao.findByUserName((String)session.get("login_username"));
			customer.setBirthday(this.getBirthday());
			customer.setRealName(this.getRealName());
			customer.setSex(this.parseToSex(this.getSex()));
			if(this.areaId!=null){
			customer.setArea(areaDao.selectById(this.areaId));
			}else 
			customer.setArea(null);
			customerDao.update(customer);
			success=true;
			message="更新成功!";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
		
	}
	
	
	private String parseToSex(String sex){
		
		if(sex.equals("male")) return "男";
		else if(sex.equals("female"))return "女";
		else return "未知";
		
		
	}
	
	
	/**
	 * 图片上传
	 */
	
	public String avatarInforUpdate(){
		CustomerDao customerDao = new CustomerDao();
		Customer customer= customerDao.findByUserName((String)session.get("login_username"));
		
		customer.setAvatar(this.getAvatar());
		
		customerDao.update(customer);
		
		success=true;
		message="上传成功!";		
		return SUCCESS;
	}
	
	/**
	 * 跳转到我的资料页，显示我的资料
	 */
	public  String index(){
		
		CustomerDao customerDao = new CustomerDao();
			
		Customer customer=customerDao.findByUserName((String)session.get("login_username"));
		
		return SUCCESS;
		
	}
	
	

}
