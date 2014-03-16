package com.ssl.user.xuanchuan;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.framework.Dao.AdvertDao;
import com.lyq.model.all.Advert;
import com.opensymphony.xwork2.ActionSupport;
import com.ssl.user.xuanchuan.mode.AdvertMode;

public class AdvertListAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  int  pageSize=8;
	private int  pageNumber;
	private int  totalPage;
	
	
	private String name;
	private String username;
	private Integer advertId;	
	private String address;
	private String subject;
	private String content;
	private Timestamp createTime;
	
	private AdvertDao advertDao = new AdvertDao();
	
	private HttpServletRequest request = ServletActionContext.getRequest ();
	private List<AdvertMode> advertlist= new ArrayList<AdvertMode>();
   
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

	public AdvertDao getAdvertDao() {
		return advertDao;
	}

	public void setAdvertDao(AdvertDao advertDao) {
		this.advertDao = advertDao;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getAdvertId() {
		return advertId;
	}

	public void setAdvertId(Integer advertId) {
		this.advertId = advertId;
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
	

	public List<AdvertMode> getAdvertlist() {
		return advertlist;
	}

	public void setAdvertlist(List<AdvertMode> advertlist) {
		this.advertlist = advertlist;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	} 
	
	
	public String execute(){	
		
		this.pageNumber=1;
		String pageNumberString=request.getParameter("pageNumber");
		if(pageNumberString!=null)	
			pageNumber=	Integer.parseInt(pageNumberString);
		 this.totalPage=((this.advertDao.selectAll().size()-1)/this.pageSize)+1;
		 List<Advert> al= new ArrayList<Advert>();
		 
		 al=advertDao.findAll(this.pageSize, this.pageNumber);
			
		 advertlist=this.parseToAdvertList(al);
		
		return SUCCESS;
		
	}
	private List<AdvertMode> parseToAdvertList(List<Advert> la){
		List<AdvertMode> lam =new ArrayList<AdvertMode>();
		
		for(Advert a :la){
			AdvertMode advertMode=new AdvertMode();
			if(a.getAdvertId()!=null)
		advertMode.setAdvertId(a.getAdvertId());
		advertMode.setAddress(a.getAddress());
		advertMode.setContent(a.getContent());
		advertMode.setCreateTime(a.getCreateTime());
		advertMode.setSubject(a.getSubject());
		lam.add(advertMode);
		}
		
		
		return lam;
	}
	
	

}
