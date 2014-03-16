package com.lyq.action.admin;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.framework.Dao.AreaDao;
import com.framework.Dao.CategoryDao;
import com.framework.Dao.DAOQuery;
import com.framework.Dao.ProductDao;
import com.framework.Dao.StoreDao;
import com.framework.Dao.TuanDao;
import com.lyq.model.all.Area;
import com.lyq.model.all.Category;
import com.lyq.model.all.Product;
import com.lyq.model.all.Store;
import com.lyq.model.all.Tuan;
import com.opensymphony.xwork2.ActionSupport;

public class TuanDeal extends ActionSupport {
	List<Tuan> lists;
	TuanDao tuanDao;
	Tuan tuan;
	Integer tuanId;
	List<String> nameList;
	CategoryDao categoryDao;
	StoreDao storeDao;
	Category category;
	Integer categoryId;
	Store store;
	Area area;
	AreaDao areaDao;
	Integer pageIndex;
	Integer pageCount;
	private String searchClause;
	private boolean hasDeleted;
	private boolean unDeleted;
	private String pname;
	private float pprice;
	private String pstoreName;
	private String pcategoryName;
	private String pdescription;
	private float tuanPrice;
	private Integer limitCount;
	private String selectValue;
	
	public void setSelectValue(String selectValue) {
		this.selectValue = selectValue;
	}
	public String getSelectValue() {
		return selectValue;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setLimitCount(Integer limitCount) {
		this.limitCount = limitCount;
	}

	public Integer getLimitCount() {
		return limitCount;
	}

	public void setTuanPrice(float tuanPrice) {
		this.tuanPrice = tuanPrice;
	}

	public float getTuanPrice() {
		return tuanPrice;
	}

	public void setLists(List<Tuan> lists) {
		this.lists = lists;
	}

	public List<Tuan> getLists() {
		return lists;
	}

	public void setSearchClause(String searchClause) {
		this.searchClause = searchClause;
	}

	public String getSearchClause() {
		return searchClause;
	}

	public Integer getPageIndex() throws Exception {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex)
			throws ExceptionInInitializerError {
		this.pageIndex = pageIndex;
	}

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public void setNameList(List<String> nameList) {
		this.nameList = nameList;
	}

	public List<String> getNameList() {
		return nameList;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public float getPprice() {
		return pprice;
	}

	public void setPprice(float pprice) {
		this.pprice = pprice;
	}

	public String getPstoreName() {
		return pstoreName;
	}

	public void setPstoreName(String pstoreName) {
		this.pstoreName = pstoreName;
	}

	public String getPdescription() {
		return pdescription;
	}

	public void setPdescription(String pdescription) {
		this.pdescription = pdescription;
	}

	public void setTuanId(Integer tuanId) {
		this.tuanId = tuanId;
	}

	public Integer getTuanId() {
		return tuanId;
	}

	public void setTuan(Tuan tuan) {
		this.tuan = tuan;
	}

	public Tuan getTuan() {
		return tuan;
	}

	public String getPcategoryName() {
		return pcategoryName;
	}

	public void setPcategoryName(String pcategoryName) {
		this.pcategoryName = pcategoryName;
	}

	public boolean isHasDeleted() {
		return hasDeleted;
	}

	public void setHasDeleted(boolean hasDeleted) {
		this.hasDeleted = hasDeleted;
	}

	public boolean isUnDeleted() {
		return unDeleted;
	}

	public void setUnDeleted(boolean unDeleted) {
		this.unDeleted = unDeleted;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub

		tuanDao = new TuanDao();
		tuanDao.beginTransaction();
		lists = tuanDao.selectAll();
		return SUCCESS;
	}

	/*
	 * 商品列表
	 */
	public String list() {
		try {
			tuanDao = new TuanDao();
			DAOQuery daoQuery = new DAOQuery();
			Integer pageSize = 5;
			// productDao.beginTransaction();
//			String pageIndexTemp = ServletActionContext.getRequest()
//					.getParameter("pageIndex");
			Integer rowCount = -1;			
			if (searchClause==null) {
				searchClause="";
			}
			selectValue=ServletActionContext.getRequest().getParameter("selectValue");
			if (selectValue!=null) {				
				ActionDealHelper.selectValueMethod(daoQuery, selectValue,"store", "createTime", "product.category",
						"currentPrice");				
			}						
			if (searchClause != null && searchClause != "") {
				 searchClause=new String(searchClause.getBytes("iso-8859-1"), "utf-8");
				daoQuery.set_whereClause(" product.name like '%" + searchClause+ "%'");
				rowCount = tuanDao
						.selectCount("select count(*) from Tuan where  product.name like '%"
								+ searchClause + "%'");
			}			
			String sqlCountString="select count(*) from Tuan where state=";
			if (unDeleted) {
				sqlCountString+="false ";
				System.out.println("searchCluse:"+searchClause+",");
				if (searchClause!=null&&searchClause!="") {
					System.out.println("searchCluse:"+searchClause+",,");
					sqlCountString+="and product.name like '%"+searchClause+"%'";
				}				
				daoQuery.set_whereClause(" state=false and product.name like '%"+searchClause+"%'");
				rowCount = tuanDao
						.selectCount(sqlCountString);	
			}
			if (hasDeleted) {
				sqlCountString+="true ";
				if (searchClause!=null&&searchClause!="") {
					sqlCountString+="and name like '%"+searchClause+"%'";
				}
				daoQuery.set_whereClause(" state=true and product.name like '%"+searchClause+"%'");
				rowCount = tuanDao
						.selectCount(sqlCountString);
			}

			if (rowCount == -1) {
				rowCount = tuanDao.selectCount("select count(*) from Tuan ");
			}
			System.out.println("rowCount:" + rowCount);

			
			if (rowCount >= 1) {
				pageCount = (rowCount - 1) / pageSize + 1;
			} else {
				pageCount = 0;
			}
//			if (pageIndexTemp != null && pageIndexTemp != "") {
//				System.out.println(pageIndexTemp);
//				pageIndex = Integer.valueOf(pageIndexTemp);
//			} else {
//				pageIndex = 1;
//			}
			if(pageIndex==null||pageIndex<=0)
			{
				pageIndex=1;
			}
			if (pageIndex > pageCount) {
				pageIndex = pageCount;
			}
			daoQuery.set_pageIndex(pageIndex - 1);
			daoQuery.set_pageSize(pageSize);
			lists = tuanDao.select(daoQuery);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * 添加事件
	 */
	// public String add() throws Exception {
	// product = new Product();
	// productDao = new ProductDao();
	// return "add_product";
	// }
	//
	// /*
	// * 确认修改和添加
	// */
	public String Smodified() throws Exception {
		pageIndex=Integer.valueOf(ServletActionContext.getRequest()
					.getParameter("pageIndex"));
		tuanDao = new TuanDao();
		// System.out.println(productId + ",smodified1111111111111");
		System.out.println("tuanId:" + tuanId);
		tuan = tuanDao.selectById(tuanId);

		// store=storeDao.selectById(product.getStore().)
		tuan.getProduct().setPrice(pprice);
		tuan.getProduct().setName(pname);
		tuan.setCurrentPrice(tuanPrice);
		/*
		 * 团购时间未做
		 */
		// tuan.getProduct().setDescription(pdescription);
		// product.getStore().setName(pstoreName);
		categoryDao=new CategoryDao();
		
		category=categoryDao.selectById(categoryId);
		tuan.getProduct().setDescription(pdescription);
		tuan.getProduct().setCategory(category);
		tuan.setLimitCount(limitCount);
		// product.getCategory().setName(pcategoryName);
		tuanDao.update(tuan);
		return list();

	}

	// /*
	// * 删除状态
	// */
	public String deleted() {
		tuanId = -1;
		String abcd = ServletActionContext.getRequest()
				.getParameter("deleteId");
		if (abcd != null) {
			tuanId = Integer.valueOf(abcd);
		}

		// for (String string : checkone) {
		// System.out.println("abc:"+string);
		// }
		if (tuanId != -1) {

			tuanDao = new TuanDao();
			tuan = tuanDao.selectById(tuanId);
			System.out.println("product:" + tuan.getProduct().getName());
			// productDao.beginTransaction();
			tuan.setState(true);
			tuanDao.update(tuan);
		}

		return list();
	}

	//
	/*
	 * 修改事件
	 */
	public String modified() {

		tuanId = Integer.valueOf(ServletActionContext.getRequest()
				.getParameter("modifiedId"));
		pageIndex=Integer.valueOf(ServletActionContext.getRequest().getParameter("pageIndex"));
		System.out.println("modified:" + tuanId);
		tuanDao = new TuanDao();
		tuan = tuanDao.selectById(tuanId);

		return "modified";
	}

	//
	// /*
	// * 商品查看
	// */
	public String shows() {

		tuanId = Integer.valueOf(ServletActionContext.getRequest()
				.getParameter("showsId"));
		tuanDao = new TuanDao();
		tuan = tuanDao.selectById(tuanId);
		pageIndex=Integer.valueOf(ServletActionContext.getRequest().getParameter("pageIndex"));
		return "tuan_show";
	}

	//
	/*
	 * 恢复删除的商品
	 */
	public String restore() {

		tuanDao = new TuanDao();
		tuanId = Integer.valueOf(ServletActionContext.getRequest()
				.getParameter("restoreId"));
		tuan = tuanDao.selectById(tuanId);
		tuan.setState(false);
		tuanDao.update(tuan);
		return list();
	}

	// /*

}
