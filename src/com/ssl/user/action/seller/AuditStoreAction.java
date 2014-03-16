package com.ssl.user.action.seller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.framework.Dao.AreaDao;
import com.framework.Dao.CustomerDao;
import com.framework.Dao.DAOQuery;
import com.framework.Dao.StoreDao;
import com.lyq.model.all.Area;
import com.lyq.model.all.Customer;
import com.lyq.model.all.Store;
import com.opensymphony.xwork2.ActionSupport;

public class AuditStoreAction extends ActionSupport {
	
	private Store store;
	private String storeId;
	private String searchClause;
	private String columClause;
	private String pageNumber;
	private String audit;
	private String state;
	private String all;
	
	private  int pageSize =5;//设置页大小
	private int    totalPage;
	
	
	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getSearchClause() {
		return searchClause;
	}

	public void setSearchClause(String searchClause) {
		this.searchClause = searchClause;
	}

	public String getColumClause() {
		return columClause;
	}

	public void setColumClause(String columClause) {
		this.columClause = columClause;
	}

	public String getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(String pageNumber) {
		this.pageNumber = pageNumber;
	}

	public String getAudit() {
		return audit;
	}

	public void setAudit(String audit) {
		this.audit = audit;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getAll() {
		return all;
	}

	public void setAll(String all) {
		this.all = all;
	}

	public List<ShowStore> getStoreList() {
		return storeList;
	}

	public void setStoreList(List<ShowStore> storeList) {
		this.storeList = storeList;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	/**
	 * state 1 表示删除，0表示未删除
	 */
	
	private List<ShowStore> storeList =new ArrayList<ShowStore>(); 
	private HttpServletRequest request = ServletActionContext.getRequest (); 
	
	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}
	
	private String work;
	
	public String getWork() {
		return work;
	}

	public void setWork(String work) {
		this.work = work;
	}
	
	private String areaString(Area area3){
		AreaDao areaDao = new AreaDao();
		if(area3!=null){
			Area area2 =areaDao.getSupAreaByArea(area3);
			Area area1=areaDao.getSupAreaByArea(area2);
		   return area1.getName()+","+area2.getName()+","+area3.getName();
				   
		}
		else return "未知";
	}
	
	//获得所有条件查询得到的Store
	private List<Store> showAll(int pageNumber,int pageSize,
			String searchClause,String columClause,
			String delete,String audit,String all){
		
		StoreDao storeDao = new StoreDao();
		DAOQuery  dq = new DAOQuery();
		
		
		dq.set_pageIndex(pageNumber-1);
		dq.set_pageSize(pageSize);
		String like="";
		if(columClause!=null&&columClause.length()!=0)
			like=columClause+" like '%" + searchClause + "%'";
		else like="";
		
		if(delete!=null&&delete.equals("true"))
			
		{
			if(like.length()==0)like="state=1";
			else like+="AND state=1";
		}
		
		if(audit!=null&&audit.equals("true")){
			
			if(like.length()==0) like="audit=1";
			else like+="AND audit=1";
		}
		if(audit!=null&&audit.equals("false")){
			if(like.length()==0) like="audit=0";
			else like+="AND audit=0";
			
		}
		if(all!=null&&all.equals("true")){
			
			if(like.length()==0)like="";
			else like+="";
		}
		
		dq.set_whereClause(like);		
		
		return  storeDao.select(dq);
		
	}
	//获得总的页数
	private int getTotal(String searchClause,String columClause,
			String delete,String audit,String all){
		
		StoreDao storeDao = new StoreDao();
		DAOQuery  dq = new DAOQuery();
		
		String like="";
		if(columClause!=null&&columClause.length()!=0)
			like=columClause+" like '%" + searchClause + "%'";
		else like="";
		
		if(delete!=null&&delete.equals("true"))
			
		{
			if(like.length()==0)like="state=1";
			else like+="AND state=1";
		}
		
		if(audit!=null&&audit.equals("true")){
			
			if(like.length()==0) like="audit=1";
			else like+="AND audit=1";
		}
		
		if(audit!=null&&audit.equals("false")){
			if(like.length()==0) like="audit=0";
			else like+="AND audit=0";
			
		}
		
		if(all!=null&&all.equals("true")){
			
			if(like.length()==0)like="";
			else like+="";
		}
		
		dq.set_whereClause(like);		
		
		return  storeDao.select(dq).size();
	
		
	}
	
	
	//将store转化为showstore输出
	
	private ShowStore StoreToShowStore(Store store){
		
		ShowStore showStore =new ShowStore();
		Customer customer =null;
		CustomerDao customerDao  = new CustomerDao();
		if(store.getCustomer()!=null)
	 customer =customerDao.selectById((store.getCustomer()).getCustomerId());
		
		
		if(store.getAudit()!=null&&(store.getAudit()).equals("true"))
			
		    showStore.setAudit("审核通过");
		
		else showStore.setAudit("还未审核");
		
		showStore.setMobile("未知");
		if(store.getMobile()!=null&&store.getMobile().length()!=0)
		showStore.setMobile(store.getMobile());
		showStore.setName(store.getName());
		
		showStore.setRealName("未知");
		if((customer!=null&&customer.getRealName()!=null)&&customer.getRealName().length()!=0)
		showStore.setRealName(customer.getRealName());
		
		
		
		showStore.setSex("未知");
		if(customer!=null&&(customer.getSex())!=null&&(customer.getSex()).length()!=0)
		showStore.setSex(customer.getSex());
		
		
		if((store.getState()!=null)&&(store.getState()).equals("true"))
		
			showStore.setState("已删除");
		else showStore.setState("未删除");
		
		
		showStore.setTel("未知");
		if(store.getTel()!=null&&(store.getTel()).length()!=0)
		showStore.setTel(store.getTel());
		showStore.setStoreId(store.getStoreId());	
		
		return showStore;
		
		
	}
	
	
	
	
	
	/*管理员审核店铺信息
	 * (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String  execute(){
		
		String storeId =request.getParameter("storeId");
		String searchClause =request.getParameter("searchClause");
		String searchColum =request.getParameter("searchColum");
		
		int pageNumber=0;
		String pageNumberString =request.getParameter("pageNumber");
		if(pageNumberString==null||pageNumberString.length()==0) this.pageNumber="1";
		else this.pageNumber=pageNumberString;
		 pageNumber=new Integer(this.pageNumber).intValue();
	
		String audit =request.getParameter("audit");
		String state =request.getParameter("state");
		String all =request.getParameter("all");
		
		List<Store> list =this.showAll(pageNumber, this.pageSize, searchClause, 
				searchColum, state, audit, all);
		System.out.println("---------"+list.size());
		Iterator it =list.iterator();	
		int total=this.getTotal(searchClause, 
				searchColum, state, audit, all);
		this.totalPage=(total-1)/this.pageSize+1;	
		
		while(it.hasNext()){
		storeList.add(this.StoreToShowStore((Store)it.next()));
		}
		
		return SUCCESS;
	}
		

}
