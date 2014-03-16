package com.ssl.user.xuanchuan;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.framework.Dao.StoreDao;
import com.lyq.model.all.Store;
import com.opensymphony.xwork2.ActionSupport;
import com.ssl.user.xuanchuan.mode.StoreMode;
public class SendSMSStoreAdvertAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String type;
    private Integer storeId;
	private String name;
	private String realName;
	private Integer maxpeople;
	private Boolean audit;
	private String mobile;
	private String areaId;
	
	private int pageSize=8;
	private int pageNumber;
	private int totalPage;
	private List<StoreMode> storeList =new ArrayList<StoreMode>(); 
	private StoreDao storeDao=new StoreDao();
	private HttpServletRequest request = ServletActionContext.getRequest (); 
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getStoreId() {
		return storeId;
	}
	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public Integer getMaxpeople() {
		return maxpeople;
	}
	public void setMaxpeople(Integer maxpeople) {
		this.maxpeople = maxpeople;
	}
	public Boolean getAudit() {
		return audit;
	}
	public void setAudit(Boolean audit) {
		this.audit = audit;
	}
	public String getMobile() {
		return mobile;
	}
	
	public List<StoreMode> getStoreList() {
		return storeList;
	}
	public void setStoreList(List<StoreMode> storeList) {
		this.storeList = storeList;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAreaId() {
		return areaId;
	}
	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}
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
	
	public String show(){		
		this.pageNumber=1;
		String pageNumberString=request.getParameter("pageNumber");
		if(pageNumberString!=null) this.pageNumber=Integer.parseInt(pageNumberString);
		this.areaId=request.getParameter("areaId");
		this.totalPage=((this.storeDao.findAll(this.areaId)).size()-1)/this.pageSize+1;	
		storeList=this.parseToStoreMode(storeDao.findAll(this.pageNumber,this.pageSize, this.areaId));		
		return SUCCESS;
	}
	
	private List<StoreMode> parseToStoreMode(List<Store> ls){
		List<StoreMode> lsm = new ArrayList<StoreMode>();	
		for(Store store:ls){
			StoreMode storeMode =new StoreMode();
			storeMode.setAudit(store.getAudit());
			storeMode.setEmail(store.getCustomer().getEmail());
			storeMode.setMaxpeople(store.getMaxpeople());
			storeMode.setMobile(store.getMobile());
			storeMode.setName(store.getName());
			storeMode.setRealName(store.getCustomer().getRealName());
			storeMode.setStoreId(store.getStoreId());
			lsm.add(storeMode);			
		}
		
		return lsm;
		
		
	}

}
