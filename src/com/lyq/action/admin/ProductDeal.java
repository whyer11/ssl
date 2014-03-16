package com.lyq.action.admin;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.framework.Dao.AreaDao;
import com.framework.Dao.CategoryDao;
import com.framework.Dao.DAOQuery;
import com.framework.Dao.ProductDao;
import com.framework.Dao.StoreDao;
import com.framework.Dao.TuanDao;
import com.lyq.action.product.productAction;
import com.lyq.model.all.Area;
import com.lyq.model.all.Category;
import com.lyq.model.all.Product;
import com.lyq.model.all.Store;
import com.lyq.model.all.Tuan;
import com.lyq.util1.DateUtil;
import com.opensymphony.xwork2.ActionSupport;

public class ProductDeal extends ActionSupport {
	List<Product> lists;
	ProductDao productDao;
	Product product;
	Integer productId;
	List<String> nameList;
	CategoryDao categoryDao;
	StoreDao storeDao;
	Category category;
	Store store;
	Area area;
	AreaDao areaDao;
	Integer pageIndex;
	Integer pageCount;
	Integer parentId;
	Integer categoryId;
	List<Category> listsCategories;
	List<Category> listsCategories2;
	List<Category> listsCategories3;
	private Integer storeId;
	private String storeName;

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getStoreName() {
		return storeName;
	}

	private String selectValue;

	private float tuanPrice;

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	public Integer getStoreId() {
		return storeId;
	}

	public void setSelectValue(String selectValue) {
		this.selectValue = selectValue;
	}

	public String getSelectValue() {
		return selectValue;
	}

	public void setTuanPrice(float tuanPrice) {
		this.tuanPrice = tuanPrice;
	}

	public float getTuanPrice() {
		return tuanPrice;
	}

	String tuanRadio;

	public void setTuanRadio(String tuanRadio) {
		this.tuanRadio = tuanRadio;
	}

	public String getTuanRadio() {
		return tuanRadio;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getParentId() {
		return parentId;
	}

	private String searchClause;
	private boolean hasDeleted;
	private boolean unDeleted;
	private String pname;
	private float pprice;
	private String pstoreName;
	private String pcategoryName;
	private String pdescription;
	private HttpServletRequest request = ServletActionContext.getRequest();

	public void setListsCategories(List<Category> listsCategories) {
		this.listsCategories = listsCategories;
	}

	public List<Category> getListsCategories() {
		return listsCategories;
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

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Product getProduct() {
		return product;
	}

	public void setLists(List<Product> lists) {
		this.lists = lists;
	}

	public List<Product> getLists() {
		return lists;
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

	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub

		productDao = new ProductDao();
		productDao.beginTransaction();
		lists = productDao.selectAll();
		return null;
	}

	/*
	 * 设为团购
	 */

	public String setTuan() throws Exception {
		productDao = new ProductDao();
		TuanDao tuanDao = new TuanDao();
		Tuan tuan = new Tuan();
		Date date = new Date();
		productId = Integer.valueOf(request.getParameter("productId"));
		pageIndex = Integer.valueOf(request.getParameter("pageIndex"));
		// selectValue=request.getParameter("selectValue");
		product = productDao.selectById(productId);
		tuan.setProduct(product);
		tuan.setStore(product.getStore());
		tuan.setCreateTime(Timestamp.valueOf(DateUtil.formatDate(date)));
		tuan.setCurrentPrice(product.getPrice());
		tuan.setStartTime(Timestamp.valueOf(DateUtil.formatDate(date)));
		tuan.setState(false);
		tuan.setDeadTime(Timestamp.valueOf(DateUtil.formatDate(date)));
		tuan.setLimitCount(13);
		tuanDao.save(tuan);
		return list();
	}

	/*
	 * 商品列表
	 */
	public String list() {
		try {
			productDao = new ProductDao();
			DAOQuery daoQuery = new DAOQuery();
			Integer rowCount = -1;
			Integer pageSize = 8;
			String storeIdWhere = " ";
			// String showsIdString = request.getParameter("showsId");
			// ActionDealHelper actionDealHelper=new ActionDealHelper();
			// actionDealHelper.setSearchClause(searchClause);
			// actionDealHelper.setDaoQuery(daoQuery);
			// actionDealHelper.setProductDao(productDao);
			// actionDealHelper.setRowCount(rowCount);
			// actionDealHelper.setSelectValue(selectValue);
			// actionDealHelper.setShowsIdString(showsIdString);
			// actionDealHelper.setStoreId(storeId);
			// actionDealHelper.setUnDeleted(unDeleted);
			// actionDealHelper.setHasDeleted(hasDeleted);
			// actionDealHelper.setRowCount(rowCount);
			// actionDealHelper.setPageIndex(pageIndex);
			// actionDealHelper.setPageSize(pageSize);
			// actionDealHelper.setLists(lists);
			// actionDealHelper.listFunction();
			// lists=actionDealHelper.getLists();
			// System.out.println(lists+"123");

			if (storeId != null) {
				storeIdWhere = " and store.storeId=" + storeId;
				daoQuery.set_whereClause("store.storeId=" + storeId);
				// daoQuery.set_whereClause("store.storeId=" + storeId);
			} else {

			}

			if (searchClause != null && searchClause != "") {
				
				System.out.println("searchCluasePage:" + searchClause);
				daoQuery.set_whereClause(" name like '%" + searchClause + "%' "
						+ storeIdWhere);
				rowCount = productDao
						.selectCount("select count(*) from Product where  name like '%"
								+ searchClause + "%' " + storeIdWhere);
			}
			// selectValue = request.getParameter("selectValue");
			// if (showsIdString != null && showsIdString != "") {
			// storeId = Integer.valueOf(showsIdString);
			// }

			System.out.println("storeId:" + storeId);
			if (selectValue != null) {
				ActionDealHelper.selectValueMethod(daoQuery, selectValue,
						"price", "createTime", "category", "store");
			}
			String sqlCountString = "select count(*) from Product where deleted=";
			if (unDeleted) {
				sqlCountString += "false ";
				if (searchClause != null && searchClause != "") {
					sqlCountString += "and name like '%" + searchClause + "%'";
				}
				daoQuery.set_whereClause(" deleted=false and name like '%"
						+ searchClause + "%' " + storeIdWhere);
				rowCount = productDao
						.selectCount(sqlCountString + storeIdWhere);
			}

			if (hasDeleted) {
				sqlCountString += "true ";
				if (searchClause != null && searchClause != "") {
					sqlCountString += "and name like '%" + searchClause + "%' "
							+ storeIdWhere;
				}
				System.out.println(sqlCountString);
				daoQuery.set_whereClause(" deleted=true and name like '%"
						+ searchClause + "%' " + storeIdWhere);
				rowCount = productDao
						.selectCount(sqlCountString + storeIdWhere);
			}
			if (rowCount == -1) {
				if (storeId != null) {
					rowCount = productDao
							.selectCount("select count(*) from Product where store.storeId="
									+ storeId);
				} else {
					rowCount = productDao
							.selectCount("select count(*) from Product ");
				}

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
			lists = productDao.select(daoQuery);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * 添加事件
	 */
	public String add() throws Exception {
		product = new Product();
		// productDao = new ProductDao();
		// categoryDao = new CategoryDao();
		// DAOQuery daoQuery = new DAOQuery();
		//
		// daoQuery.set_whereClause("parentId=" + categoryId);
		// listsCategories = categoryDao.select(daoQuery);
		if (storeId!=null) {
			storeDao=new StoreDao();
			store=storeDao.selectById(storeId);
			storeName=store.getName();
		}
		// 查询所有的一级分类
		return "add_product";
	}

	/*
	 * 确认修改和添加
	 */
	public String Smodified() throws Exception {
		productDao = new ProductDao();
		System.out.println(productId + ",smodified1111111111111");
		System.out.println("picutres:" + productAction.getPicLink());
		categoryDao = new CategoryDao();
		System.out.println("tuanRadio:" + tuanRadio);
		storeDao = new StoreDao();
		store=storeDao.selectById(storeId);
		System.out.println(store.getName());
		if (productId == null) {
			product = new Product();
			TuanDao tuanDao = new TuanDao();
			Tuan tuan = new Tuan();
			
			
			areaDao = new AreaDao();
			area=areaDao.selectById(11);
			{
				Date date = new Date();
				
				
				System.out.println("categoryId:" + categoryId);
				category = categoryDao.selectById(categoryId);
				System.out.println("pdescripti:" + pdescription);
				product.setDescription(pdescription);
				product.setPictures(productAction.getPicLink());
				product.setStore(store);
				product.setPrice(pprice);
				product.setCreateTime(Timestamp.valueOf(DateUtil
						.formatDate(date)));
				product.setName(pname);
				product.setCategory(category);
//				product.setArea(store.getArea());
				product.setArea(area);
				product.setStore(store);
				product.setCategory(category);
				product.setDeleted(false);

				productDao.save(product);

				System.out.println("aa:" + product.getProductId());
				if (tuanRadio.equals("1")) {
					tuan.setProduct(product);
					tuan.setStore(store);
					tuan.setCreateTime(Timestamp.valueOf(DateUtil
							.formatDate(date)));
					tuan.setCurrentPrice(tuanPrice);
					tuan.setStartTime(Timestamp.valueOf(DateUtil
							.formatDate(date)));
					tuan.setState(false);
					tuan.setDeadTime(Timestamp.valueOf(DateUtil
							.formatDate(date)));
					tuan.setLimitCount(13);
					tuanDao.save(tuan);
				}
				productAction.setPicLink("");
				return list();
			}

		} else {
			product = productDao.selectById(productId);
			// store=storeDao.selectById(product.getStore().)
			
			product.setName(pname);
			if (categoryId != null) {
				System.out.println("categoryaaaaaaaaaaaa:" + categoryId);
				category = categoryDao.selectById(categoryId);
				product.setCategory(category);
			}
			// product.getStore().setName(pstoreName);
			product.setDescription(pdescription);
			product.setPrice(pprice);
			product.setStore(store);
			System.out.println("ccategory:" + pcategoryName);
			// product.getCategory().setName(pcategoryName);
			productDao.update(product);
			return list();
		}

	}

	/*
	 * 删除状态
	 */
	public String deleted() {
		productId = -1;
		String abcd = ServletActionContext.getRequest()
				.getParameter("deleteId");
		if (abcd != null) {
			productId = Integer.valueOf(abcd);
		}

		// for (String string : checkone) {
		// System.out.println("abc:"+string);
		// }

		if (productId != -1) {

			productDao = new ProductDao();
			product = productDao.selectById(productId);
			System.out.println("product:" + product.getName());
			// productDao.beginTransaction();
			product.setDeleted(true);
			productDao.update(product);
		}

		return list();
	}

	/*
	 * 修改事件
	 */
	public String modified() {

		productId = Integer.valueOf(ServletActionContext.getRequest()
				.getParameter("modifiedId"));

		System.out.println("modified:" + productId);
		productDao = new ProductDao();
		product = productDao.selectById(productId);

		return "modified";
	}

	/*
	 * 商品查看
	 */
	public String shows() {

		productId = Integer.valueOf(ServletActionContext.getRequest()
				.getParameter("showsId"));
		productDao = new ProductDao();
		product = productDao.selectById(productId);
		return "product_show";
	}

	/*
	 * 恢复删除的商品
	 */
	public String restore() {

		productDao = new ProductDao();
		productId = Integer.valueOf(ServletActionContext.getRequest()
				.getParameter("restoreId"));
		product = productDao.selectById(productId);
		product.setDeleted(false);
		productDao.update(product);
		return list();
	}

	// /*
	// * 商品审核
	// */
	// public String audits() {
	//
	// productDao = new ProductDao();
	// productId = Integer.valueOf(ServletActionContext.getRequest()
	// .getParameter("auditId"));
	// System.out.println("auditId:"+productId);
	// product = productDao.selectById(productId);
	// productDao.update(product);
	// return list();
	// }
	public List<Category> getListsCategories2() {
		return listsCategories2;
	}

	public void setListsCategories2(List<Category> listsCategories2) {
		this.listsCategories2 = listsCategories2;
	}

	public List<Category> getListsCategories3() {
		return listsCategories3;
	}

	public void setListsCategories3(List<Category> listsCategories3) {
		this.listsCategories3 = listsCategories3;
	}

}
