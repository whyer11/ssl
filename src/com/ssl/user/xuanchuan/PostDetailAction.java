package com.ssl.user.xuanchuan;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.framework.Dao.AdvertDao;
import com.lyq.model.all.Advert;
import com.opensymphony.xwork2.ActionSupport;


public class PostDetailAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int  advertId;
	private String name;
	private String address;
	private String subject;
	private String content;
	private Timestamp createTime;
	private HttpServletRequest request = ServletActionContext.getRequest (); 
	
	
	
	public int getAdvertId() {
		return advertId;
	}



	public void setAdvertId(int advertId) {
		this.advertId = advertId;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getSubject() {
		return subject;
	}



	public void setSubject(String subject) {
		this.subject = subject;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}



	public Timestamp getCreateTime() {
		return createTime;
	}



	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}



	public HttpServletRequest getRequest() {
		return request;
	}



	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public String execute(){
		AdvertDao advertDao = new AdvertDao();
		this.advertId =new Integer(request.getParameter("advertId"));
		Advert ad =advertDao.selectById(this.advertId);
		
		this.address=ad.getAddress();
		//this.content=this.htmlspecialchars(ad.getContent());
		this.content=ad.getContent();
		System.out.println("-------"+ad.getContent());
		this.createTime=ad.getCreateTime();
		this.subject=ad.getSubject();
		
		return SUCCESS;
	}
	private String htmlspecialchars(String str) {
		str = str.replaceAll("&", "&amp;");
		str = str.replaceAll("<", "&lt;");
		str = str.replaceAll(">", "&gt;");
		str = str.replaceAll("\"", "&quot;");
		return str;
	}

	

}
