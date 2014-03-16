package com.lyq.action.admin;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.framework.Dao.AreaDao;
import com.framework.Dao.CategoryDao;
import com.framework.Dao.DAOQuery;
import com.framework.Dao.OrderDao;
import com.framework.Dao.OrderpaymentDao;
import com.framework.Dao.OrderproductDao;
import com.framework.Dao.PaymentDao;
import com.framework.Dao.ProductDao;
import com.framework.Dao.StoreDao;
import com.lyq.model.all.Area;
import com.lyq.model.all.Category;
import com.lyq.model.all.Order;
import com.lyq.model.all.Orderpayment;
import com.lyq.model.all.Orderproduct;
import com.lyq.model.all.Payment;
import com.lyq.model.all.Product;
import com.lyq.model.all.Store;
import com.lyq.util1.DateUtil;
import com.lyq.util1.NumberUtil;
import com.opensymphony.xwork2.ActionSupport;

public class OrderDeal extends ActionSupport {
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
	Order order;
	Orderproduct orderproduct;
	Orderpayment orderpayment;
	Payment payment;
	OrderDao orderDao;
	OrderproductDao orderproductDao;
	OrderpaymentDao orderpaymentDao;
	PaymentDao paymentDao;
	List<Order> orderlists;
	List<Orderproduct> orderproductlists;
	List<Orderpayment>orderpaymentlists;
	List<Payment> paymentlists;
	
	
	private String searchClause;
	private boolean hasDeleted;
	private boolean unDeleted;
	private boolean hasAudits;
	private boolean unAudits;
	private String pname;
	private float pprice;
	private String pstoreName;
	private String pcategoryName;
	private String pdescription;

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

	public boolean isHasAudits() {
		return hasAudits;
	}

	public void setHasAudits(boolean hasAudits) {
		this.hasAudits = hasAudits;
	}

	public boolean isUnAudits() {
		return unAudits;
	}

	public void setUnAudits(boolean unAudits) {
		this.unAudits = unAudits;
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
	 * 订单列表
	 */
	public String list() throws Exception{
		
		orderDao=new OrderDao();
		orderlists=orderDao.selectAll();
		
		
		
		return SUCCESS;
	}

	/*
	 * 添加事件
	 */
	public String add() throws Exception {
		product = new Product();
		productDao = new ProductDao();
		return "add_product";
	}

	/*
	 * 确认修改和添加
	 */
	public String Smodified() throws Exception {
		productDao = new ProductDao();
		System.out.println(productId + ",smodified1111111111111");
		if (productId == null) {
			product = new Product();

			areaDao = new AreaDao();
			if (NumberUtil.isNumeric(pstoreName.substring(0, 1))
					&& NumberUtil.isNumeric(pcategoryName.substring(0, 1))) {
				storeDao = new StoreDao();
				categoryDao = new CategoryDao();
				store = storeDao.selectById(Integer.valueOf(pstoreName
						.substring(0, pstoreName.indexOf(" "))));
				category = categoryDao.selectById(Integer.valueOf(pcategoryName
						.substring(0, pcategoryName.indexOf(" "))));
				System.out.println("pdescripti:" + pdescription);
				product.setDescription(pdescription);
				product.setStore(store);
				product.setPrice(pprice);
				product.setCreateTime(Timestamp.valueOf(DateUtil
						.formatDate(new Date())));
				product.setName(pname);
				product.setCategory(category);
//				product.setArea(store.getArea());
				product.setStore(store);
				product.setCategory(category);
				product.setDeleted(false);
//				product.setAuditState(false);
				productDao.save(product);

				System.out.println("aa:" + product.getProductId());
				return list();
			} else {
				return null;
			}

		} else {
			product = productDao.selectById(productId);
			// store=storeDao.selectById(product.getStore().)
			product.setName(pname);
			// product.getStore().setName(pstoreName);
			product.setDescription(pdescription);
			product.setPrice(pprice);
			System.out.println("ccategory:" + pcategoryName);
			// product.getCategory().setName(pcategoryName);
			productDao.update(product);
			return list();
		}

	}

	/*
	 * 删除状态
	 */
	public String deleted() throws Exception {
		productId = -1;
		String abcd = ServletActionContext.getRequest()
				.getParameter("deleteId");
		if (abcd != null) {
			productId = Integer.valueOf(abcd);
		}
		
//		for (String string : checkone) {
//			System.out.println("abc:"+string);
//		}
		
		
		

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
	public String restore() throws Exception {

		productDao = new ProductDao();
		productId = Integer.valueOf(ServletActionContext.getRequest()
				.getParameter("restoreId"));
		product = productDao.selectById(productId);
		product.setDeleted(false);
		productDao.update(product);
		return list();
	}

	/*
	 * 商品审核
	 */
	public String audits() throws Exception {

		productDao = new ProductDao();
		productId = Integer.valueOf(ServletActionContext.getRequest()
				.getParameter("auditId"));
		System.out.println("auditId:"+productId);
//		product = productDao.selectById(productId);
////		product.set(false);
//		productDao.update(product);	
		return list();
	}

	public List<Order> getOrderlists() {
		return orderlists;
	}

	public void setOrderlists(List<Order> orderlists) {
		this.orderlists = orderlists;
	}

	public List<Orderproduct> getOrderproductlists() {
		return orderproductlists;
	}

	public void setOrderproductlists(List<Orderproduct> orderproductlists) {
		this.orderproductlists = orderproductlists;
	}

	public List<Orderpayment> getOrderpaymentlists() {
		return orderpaymentlists;
	}

	public void setOrderpaymentlists(List<Orderpayment> orderpaymentlists) {
		this.orderpaymentlists = orderpaymentlists;
	}

	public List<Payment> getPaymentlists() {
		return paymentlists;
	}

	public void setPaymentlists(List<Payment> paymentlists) {
		this.paymentlists = paymentlists;
	}

}
