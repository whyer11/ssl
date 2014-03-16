package com.lyq.action.admin;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.struts2.ServletActionContext;
import org.hibernate.type.IntegerType;

import com.framework.Dao.AreaDao;
import com.framework.Dao.CategoryDao;
import com.framework.Dao.CustomerDao;
import com.framework.Dao.DAOQuery;
import com.framework.Dao.ProductDao;
import com.framework.Dao.StoreDao;
import com.framework.Dao.TuanDao;
import com.framework.Dao.areaStoreDao;
import com.lyq.model.all.Area;
import com.lyq.model.all.AreaStore;
import com.lyq.model.all.AreaStoreId;
import com.lyq.model.all.Customer;
import com.lyq.model.all.Product;
import com.lyq.model.all.Store;
import com.lyq.util1.DateUtil;
import com.opensymphony.xwork2.ActionSupport;

public class StoreDeal extends ActionSupport {

	ProductDao productDao;
	String searchClause;
	boolean unDeleted;
	boolean hasDeleted;
	Integer pageIndex;
	Integer pageCount;
	List<Store> lists;
	StoreDao storeDao;
	private Integer storeId;
	private String selectValue;
	private Store store;
	private String sname;
	private Integer scustomerId;
	private String stel;
	private String smobile;
	private String saddress;
	private Integer sstartTime;
	private Integer sendTime;
	private float sshipPrice;
	private float sshipFee;
	private Integer smaxpeople;
	private String saudit;
	private Integer customerIdAdd;
	private String slogo;
	private String[] areaScope;
	private Integer reachTime;
	private Integer sendorno;
	private Integer categoryId;

	Integer s1;
	Integer s2;
	Integer s3;
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public Integer getCategoryId() {
		return categoryId;
	}

	public void setSendorno(Integer sendorno) {
		this.sendorno = sendorno;
	}

	public Integer getSendorno() {
		return sendorno;
	}

	public void setReachTime(Integer reachTime) {
		this.reachTime = reachTime;
	}

	public Integer getReachTime() {
		return reachTime;
	}

	public void setAreaScope(String[] areaScope) {
		this.areaScope = areaScope;
	}

	public String[] getAreaScope() {
		return areaScope;
	}

	public void setCustomerIdAdd(Integer customerIdAdd) {
		this.customerIdAdd = customerIdAdd;
	}

	public Integer getCustomerIdAdd() {
		return customerIdAdd;
	}

	public void setSlogo(String slogo) {
		this.slogo = slogo;
	}

	public String getSlogo() {
		return slogo;
	}

	public void setSaudit(String saudit) {
		this.saudit = saudit;
	}

	public String getSaudit() {
		return saudit;
	}


	public void setStore(Store store) {
		this.store = store;
	}

	public Store getStore() {
		return store;
	}

	public void setSelectValue(String selectValue) {
		this.selectValue = selectValue;
	}

	public String getSelectValue() {
		return selectValue;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		productDao = new ProductDao();
		// lists = productDao.selectAll();
		return SUCCESS;
	}

	/*
	 * 添加店铺事件
	 */

	public String add() throws Exception {
		store = new Store();
		// mySanji = new ArrayList<MySelect>();
		// MySelect mySelect = new MySelect();
		// mySelect.childId = 1;
		// mySelect.parentId = 0;
		// mySelect.name = "abc";
		// mySanji.add(mySelect);

		return "add_store";
	}

	public String Smodified() throws Exception {
		AreaStore areastore;
		List<AreaStore> areaStoreList = new ArrayList<AreaStore>();
		areaStoreDao _areaStoreDao = new areaStoreDao();
		Date date = new Date();
		AreaDao areaDao = new AreaDao();
		storeDao = new StoreDao();
		CustomerDao customerDao = new CustomerDao();
		Customer customer = customerDao.selectById(scustomerId);
		boolean audits = false;
		System.out.println("categoryId:"+categoryId);
		// System.out.println("areaScope:"+areaScope[0]+","+areaScope[1]);
		/*
		 * storeId页面隐藏域值,用于区分是新增和修改操作
		 * 页面添加和修改在同一方法内，jsp的页面添加页和修改页使用同一页面。
		 */
		if (storeId == null) {
			store = new Store();
			System.out.println("streo:" + storeId);
			System.out.println("s3:" + s3);
			System.out.println("slogoL:" + slogo);
			store.setAddress(saddress);
			store.setName(sname);
			store.setCustomer(customer);
			store.setTel(stel);
			store.setMobile(smobile);
			store.setMaxpeople(smaxpeople);
			store.setShipFee(sshipFee);
			store.setShipPrice(sshipFee);
			store.setStartTime(sstartTime);
			store.setEndTime(sendTime);
			store.setLogo(slogo);
			store.setCategoryId(categoryId);
			store.setAudit(audits);
			store.setCrateTime(Timestamp.valueOf(DateUtil.formatDate(date)));
			store.setSendorno(sendorno);
			store.setState(false);
			storeDao.save(store);
			

		} else {
			store = storeDao.selectById(storeId);
			System.out.println("storeId:" + storeId);			
			
			/*
			 * 删除原来的关联 
			 */
			DAOQuery daoQuery=new DAOQuery();
			daoQuery.set_whereClause("store.storeId="+storeId );
			List<AreaStore> listas=_areaStoreDao.select(daoQuery);
			
			for (AreaStore areaStore2 : listas) {
				_areaStoreDao.delete(areaStore2);
			}			
			System.out.println("slogoL:" + slogo);
			store.setAddress(saddress);
			store.setName(sname);
			store.setCustomer(customer);
			store.setTel(stel);
			store.setMobile(smobile);
			store.setCategoryId(categoryId);
			store.setMaxpeople(smaxpeople);
			store.setShipFee(sshipFee);
			store.setShipPrice(sshipFee);
			store.setStartTime(sstartTime);
			store.setEndTime(sendTime);
			store.setLogo(slogo);
			store.setSendorno(sendorno);
			store.setCrateTime(Timestamp.valueOf(DateUtil.formatDate(date)));
			store.setState(false);
			System.out.println(store.getAreaStores().size() + "大小");
			storeDao.update(store);
		}
		/*
		 * 添加areaStore关联
		 */

		for (int i = 0; i < areaScope.length; i++) {
			System.out.println(areaScope[i] + "abcde");
		}
		AreaStoreId areaStoreId;
		for (int i = 0; i < areaScope.length; i++) {
			areastore = new AreaStore();
			areaStoreId = new AreaStoreId();
			areaStoreId.setStoreId(store.getStoreId());
			areaStoreId.setAreaId(Integer.valueOf(areaScope[i]));
			areastore.setStore(store);
			System.out.println(store.getStoreId() + ",22222sdd");
			areastore.setArea(areaDao.selectById(Integer
					.valueOf(areaScope[i])));
			areastore.setReachTime(120);//送达时间
			areastore.setId(areaStoreId);
			// areastore.setReachTime(reachTime);
			_areaStoreDao.save(areastore);
		}
		return list();
	}

	/*
	 * 审核店铺列表
	 */
	public String auditsStoreList() {

		try {
			storeDao = new StoreDao();
			DAOQuery daoQuery = new DAOQuery();
			Integer pageSize = 5;
			Integer rowCount = -1;
			selectValue = ServletActionContext.getRequest().getParameter(
					"selectValue");
			daoQuery.set_orderByString(" crateTime ");
			if (selectValue != null) {
				ActionDealHelper.selectValueMethod(daoQuery, selectValue,
						"maxpeople", "area", "name", "storeId");
			}
			System.out.println("audit=false");
			daoQuery.set_whereClause("audit=false ");
			System.out.println("after:audit");
			if (searchClause != null && searchClause != "") {
				searchClause = new String(searchClause.getBytes("iso-8859-1"),
						"utf-8");
				daoQuery.set_whereClause(" audit=false and name like '%"
						+ searchClause + "%'");
				rowCount = storeDao
						.selectCount("select count(*) from Store where audit=false and name like '%"
								+ searchClause + "%'");
			}
			String sqlCountString = "select count(*) from Store where audit=false and state=";
			if (unDeleted) {
				System.out.println(searchClause);
				sqlCountString += "false ";
				if (searchClause != null && searchClause != "") {
					sqlCountString += "and name like '%" + searchClause + "%'";
				}
				System.out.println(sqlCountString);
				daoQuery.set_whereClause(" and state=false and name like '%"
						+ searchClause + "%'");
				rowCount = storeDao.selectCount(sqlCountString);
			}
			if (hasDeleted) {
				sqlCountString += "true ";
				if (searchClause != null && searchClause != "") {
					sqlCountString += "and name like '%" + searchClause + "%'";
				}
				System.out.println(sqlCountString);
				daoQuery.set_whereClause(" and state=true and name like '%"
						+ searchClause + "%'");
				rowCount = storeDao.selectCount(sqlCountString);
			}
			if (rowCount == -1) {
				rowCount = storeDao
						.selectCount("select count(*) from Store where audit=false ");
			}
			System.out.println("rowCount:" + rowCount);
			if (rowCount >= 1) {
				pageCount = (rowCount - 1) / pageSize + 1;
			} else {
				pageCount = 0;
			}
			if (pageIndex == null || pageIndex <= 0) {
				pageIndex = 1;
			}
			if (pageIndex > pageCount) {
				pageIndex = pageCount;
			}
			daoQuery.set_pageIndex(pageIndex - 1);
			daoQuery.set_pageSize(pageSize);
			lists = storeDao.select(daoQuery);
			return "audits_store";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * 審核店鋪
	 */
	public String auditsStore() throws Exception {
		storeDao = new StoreDao();
		store = storeDao.selectById(storeId);
		if (store.getAudit() == false) {
			store.setAudit(true);
		} else {
			store.setAudit(false);
		}

		storeDao.update(store);

		if (store.getAudit() == true) {
			return auditsStoreList();
		} else {
			return list();
		}

	}

	/*
	 * 修改事件
	 */
	public String modified() {
		storeId = Integer.valueOf(ServletActionContext.getRequest()
				.getParameter("modifiedId"));
		pageIndex = Integer.valueOf(ServletActionContext.getRequest()
				.getParameter("pageIndex"));
		System.out.println("modified:" + storeId);
		storeDao = new StoreDao();
		store = storeDao.selectById(storeId);
		return "modified";
	}
	
	/**
	 * @param selectValue 页面列表排序字段
	 * @param pageSize 页面列表每页显示条数
	 * @param rouCount 数据库中总条数
	 * @param pageIndex 当前页面页码
	 * @param unDeleted 未删除字段
	 * @param searchClause 页面列表查询条件
	 * @author follow5
	 * 
	 */
	public String list() throws Exception {
		try {
			storeDao = new StoreDao();
			DAOQuery daoQuery = new DAOQuery();
			Integer pageSize = 5;
			Integer rowCount = -1;
			//daoQuery 设置查询条件
			selectValue = ServletActionContext.getRequest().getParameter(
					"selectValue");
			daoQuery.set_whereClause("audit=true");
			if (selectValue != null) {
				ActionDealHelper.selectValueMethod(daoQuery, selectValue,
						"maxpeople", "crateTime", "name", "");
			}
			if (searchClause != null && searchClause != "") {
			
				daoQuery.set_whereClause(" audit=true and name like '%"
						+ searchClause + "%'");
				rowCount = storeDao
						.selectCount("select count(*) from Store where audit=true and name like '%"
								+ searchClause + "%'");
			}
			String sqlCountString = "select count(*) from Store where audit=true and state=";
			if (unDeleted) {
				System.out.println(searchClause);
				sqlCountString += "false ";
				if (searchClause != null && searchClause != "") {
					sqlCountString += "and name like '%" + searchClause + "%'";
				}
				System.out.println(sqlCountString);
				daoQuery.set_whereClause(" state=false and name like '%"
						+ searchClause + "%'");
				rowCount = storeDao.selectCount(sqlCountString);
			}
			if (hasDeleted) {
				sqlCountString += "true ";
				if (searchClause != null && searchClause != "") {
					sqlCountString += "and name like '%" + searchClause + "%'";
				}
				System.out.println(sqlCountString);
				daoQuery.set_whereClause(" state=true and name like '%"
						+ searchClause + "%'");
				rowCount = storeDao.selectCount(sqlCountString);
			}
			if (rowCount == -1) {
				rowCount = storeDao
						.selectCount("select count(*) from Store where audit=true");
			}
			if (rowCount >= 1) {
				pageCount = (rowCount - 1) / pageSize + 1;
			} else {
				pageCount = 0;
			}
			if (pageIndex == null || pageIndex <= 0) {
				pageIndex = 1;
			}
			if (pageIndex > pageCount) {
				pageIndex = pageCount;
			}
			daoQuery.set_pageIndex(pageIndex - 1);
			daoQuery.set_pageSize(pageSize);
			lists = storeDao.select(daoQuery);

			for (Store sto : lists) {
				int i = 0;
				Iterator<AreaStore> iterator = sto.getAreaStores().iterator();
				while (iterator.hasNext()) {
					AreaStore areaStore = iterator.next();
					System.out.println(i++);
					System.out.println(areaStore.getArea().getName());

				}
				System.out.println(sto.getAreaStores() + "aaaaa");
				System.out.println(sto.getAreaStores());
			}

			return SUCCESS;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String deleted() throws Exception {
		storeId = -1;
		String abcd = ServletActionContext.getRequest()
				.getParameter("deleteId");
		if (abcd != null) {
			storeId = Integer.valueOf(abcd);
		}
		if (storeId != -1) {

			storeDao = new StoreDao();
			store = storeDao.selectById(storeId);
			System.out.println("product:" + store.getName());
			// productDao.beginTransaction();
			store.setState(true);
			storeDao.update(store);
		}

		return list();
	}

	/*
	 * 恢复删除的商品
	 */
	public String restore() throws Exception {

		storeDao = new StoreDao();
		storeId = Integer.valueOf(ServletActionContext.getRequest()
				.getParameter("restoreId"));
		store = storeDao.selectById(storeId);
		store.setState(false);
		storeDao.update(store);
		return list();
	}

	public String shows() {
		pageIndex = Integer.valueOf(ServletActionContext.getRequest()
				.getParameter("pageIndex"));
		
		// System.out.println("sss:"
		// + ServletActionContext.getRequest().getParameter("showsId"));
		// storeId = Integer.valueOf(ServletActionContext.getRequest()
		// .getParameter("showsId"));
		System.out.println("storeId:" + storeId);
		storeDao = new StoreDao();
		store = storeDao.selectById(storeId);

		return "store_show";
	}

	public ProductDao getProductDao() {
		return productDao;
	}

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	public String getSearchClause() {
		return searchClause;
	}

	public void setSearchClause(String searchClause) {
		this.searchClause = searchClause;
	}

	public boolean isUnDeleted() {
		return unDeleted;
	}

	public void setUnDeleted(boolean unDeleted) {
		this.unDeleted = unDeleted;
	}

	public boolean isHasDeleted() {
		return hasDeleted;
	}

	public void setHasDeleted(boolean hasDeleted) {
		this.hasDeleted = hasDeleted;
	}

	public Integer getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public List<Store> getLists() {
		return lists;
	}

	public void setLists(List<Store> lists) {
		this.lists = lists;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public Integer getScustomerId() {
		return scustomerId;
	}

	public void setScustomerId(Integer scustomerId) {
		this.scustomerId = scustomerId;
	}

	public String getStel() {
		return stel;
	}

	public void setStel(String stel) {
		this.stel = stel;
	}

	public String getSmobile() {
		return smobile;
	}

	public void setSmobile(String smobile) {
		this.smobile = smobile;
	}

	public String getSaddress() {
		return saddress;
	}

	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}

	public Integer getSstartTime() {
		return sstartTime;
	}

	public void setSstartTime(Integer sstartTime) {
		this.sstartTime = sstartTime;
	}

	public Integer getSendTime() {
		return sendTime;
	}

	public void setSendTime(Integer sendTime) {
		this.sendTime = sendTime;
	}

	public float getSshipPrice() {
		return sshipPrice;
	}

	public void setSshipPrice(float sshipPrice) {
		this.sshipPrice = sshipPrice;
	}

	public float getSshipFee() {
		return sshipFee;
	}

	public void setSshipFee(float sshipFee) {
		this.sshipFee = sshipFee;
	}

	public Integer getSmaxpeople() {
		return smaxpeople;
	}

	public void setSmaxpeople(Integer smaxpeople) {
		this.smaxpeople = smaxpeople;
	}

	public Integer getS1() {
		return s1;
	}

	public void setS1(Integer s1) {
		this.s1 = s1;
	}

	public Integer getS2() {
		return s2;
	}

	public void setS2(Integer s2) {
		this.s2 = s2;
	}

	public Integer getS3() {
		return s3;
	}

	public void setS3(Integer s3) {
		this.s3 = s3;
	}

	public Integer getStoreId() {
		return storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

}
