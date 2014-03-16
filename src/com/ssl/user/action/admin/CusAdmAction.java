package com.ssl.user.action.admin;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.framework.Dao.AreaDao;
import com.framework.Dao.CustomerDao;
import com.framework.Dao.DAOQuery;
import com.lyq.model.all.Area;
import com.lyq.model.all.Customer;
import com.opensymphony.xwork2.ActionSupport;

public class CusAdmAction extends ActionSupport {

	private String realName;

	private String sex;

	private Date birthday;

	private String userName;

	private String areaString;

	private String area1;

	private String area2;

	private String area3;

	private File avatar;
	
	
	private  int pageSize =5;//页大小
	
	private int pageNumber; //页码
	
	private int    totalPage;//总页数
	
	private String  delete;//删除
	private String  work;//已审核
	private String  unwork; //未审核
	
	private String searchClause;//搜索
	private String SearchColum;
	
	

	/**
	 * 状态为1表示未审核，
	 * 状态为2表示已审核，
	 * 状态为3表示已删除。
	 */
	
	public String getSearchColum() {
		return SearchColum;
	}

	public void setSearchColum(String searchColum) {
		SearchColum = searchColum;
	}

	public String getSearchClause() {
		return searchClause;
	}

	public void setSearchClause(String searchClause) {
		this.searchClause = searchClause;
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

	public String getUnwork() {
		return unwork;
	}

	public void setUnwork(String unwork) {
		this.unwork = unwork;
	}

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

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	private void setAvatar(File avatar) {
		this.avatar = avatar;
	}

	public String getArea1() {
		return area1;
	}

	public void setArea1(String area1) {
		this.area1 = area1;
	}

	public String getArea2() {
		return area2;
	}

	public void setArea2(String area2) {
		this.area2 = area2;
	}

	public String getArea3() {
		return area3;
	}

	public void setArea3(String area3) {
		this.area3 = area3;
	}

	public File getAvatar() {
		return avatar;
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
	
	

	/**
	 * 管理员插入级联地区信息
	 */
	public String InsertArea() {

		Area areaLever1 = new Area();

		Area areaLever2 = new Area();

		Area areaLever3 = new Area();

		AreaDao areaDao = new AreaDao();

		// 插入第一级
		areaLever1.setName(this.getArea1());
		areaLever1.setParentId(0);
		areaDao.save(areaLever1);
		Area areaReturn1 = areaDao.selectAll().get(0);

		// 插入第二级
		areaLever2.setName(this.getArea2());
		areaLever2.setParentId(areaReturn1.getAreaId());
		areaDao.save(areaLever2);
		Area areaReturn2 = areaDao.selectAll().get(0);

		// 插入第二级
		areaLever3.setName(this.getArea3());
		areaLever3.setParentId(areaReturn2.getAreaId());
		areaDao.save(areaLever3);

		return SUCCESS;

	}

	// 显示所有的会员信息
	private List<ShowCustomer> customerList = new ArrayList<ShowCustomer>();

	public List<ShowCustomer> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(List<ShowCustomer> customerList) {
		this.customerList = customerList;
	}

	@SuppressWarnings("null")
	public String show() {
		
		
		String deleteString = request.getParameter("delete");
		
		
		
		String workString = request.getParameter("work");
		String unworkString = request.getParameter("unwork");
		String totalString = request.getParameter("total");
		String searchClause = request.getParameter("searchClause");
		String searchColum = request.getParameter("searchColum");
		String whereClause="";
		
		//searchColum="userName";
		//searchClause="zhan";
		
		
	  String pageNumberString = request.getParameter("pageNumber");
	  if(pageNumberString==null||pageNumberString.equals(""))  pageNumber=1;
	  else pageNumber= new Integer(pageNumberString).intValue();
		
		DAOQuery daoQuery = new DAOQuery();
		
		
	
		daoQuery.set_pageIndex(pageNumber-1);
		daoQuery.set_pageSize(pageSize);
		
		if (searchClause != null &&searchClause != "") {
			whereClause=searchColum+" like '%" + searchClause + "%'";
		}
		
		
		if(deleteString!=null&&deleteString.equals("true")){
			if(whereClause.equals(""))whereClause="state=3";
			else whereClause+="AND state=3";
		}
		
		if(workString!=null&&workString.equals("true")){
			if(whereClause.equals("")) whereClause="state=2";
			else whereClause+="AND state=2";
		}
		
		System.out.println("work String : "+workString );
		System.out.println("where clause "+whereClause);	
			
		
		if(unworkString!=null&&unworkString.equals("true")){
			if(whereClause.equals("")) whereClause="state <>2";
			else whereClause+="AND state <> 2";
		}
		
        CustomerDao cu = new CustomerDao();
        
        DAOQuery dq = new DAOQuery();
        dq.set_whereClause(whereClause);
		
		totalPage=(cu.select(dq).size()-1)/pageSize+1;
			
		System.out.println("-------"+whereClause);
				
		
			daoQuery.set_whereClause(whereClause);

		CustomerDao customerDao = new CustomerDao();
		List<Customer> customerList1 = customerDao.select(daoQuery);
		
		
		
		
		Iterator it =customerList1.iterator();
		
		while(it.hasNext()){
			System.out.println(((Customer)it.next()).toString());
		}	
		AreaDao areaDao = new AreaDao();
		

		for (int i = 0; i < customerList1.size(); i++) {
			Customer customer = new Customer();
			ShowCustomer showCustomer = new ShowCustomer();
			customer = customerList1.get(i);

			showCustomer.setCustomerId(customer.getCustomerId());
			
			showCustomer.setUserName(customer.getUserName());
			
			showCustomer.setBirthday(customer.getBirthday());
			String realNameString="未知";
			if(customer.getRealName()!=null) realNameString= customer.getRealName();
			showCustomer.setRealName(realNameString);
			String sexString="未知";
			if(customer.getSex()!=null) sexString= customer.getSex();
			showCustomer.setSex(sexString);
			
			
			if(customer.getState()!=null)

			switch (customer.getState()) {
			case 1:
				showCustomer.setState("未审核");
				break;
			case 2:
				showCustomer.setState("已审核");
				break;
			case 3:
				showCustomer.setState("已删除");
				break;
			default:
				break;
			}
			
			showCustomer.setScore(customer.getScore());
		
			Area area3 = customer.getArea();
			if (area3 != null) {
				System.out.println(area3);
				Area area2 = areaDao.getSupAreaByArea(area3);
				Area area1 = areaDao.getSupAreaByArea(area2);

				showCustomer.setAreaString(area1.getName() + ","
						+ area2.getName() + "," + area3.getName());
			} else{
				showCustomer.setAreaString("未知");
				}
			
			customerList.add(showCustomer);
			

		}
		System.out.println("-----------------"+customerList.size());

		return SUCCESS;
	}

	public String execute() {
		return "success";

	}
		
	

}
