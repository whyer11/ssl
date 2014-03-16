package com.lyq.action.product;

import java.io.File;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hibernate.Transaction;

import com.framework.Dao.DAOQuery;
import com.framework.Dao.ProductDao;
import com.lyq.model.all.Product;
import com.lyq.util1.DateUtil;
import com.lyq.util1.UploadUtil;
import com.opensymphony.xwork2.ActionSupport;

public class FproductAction extends ActionSupport {
	private Integer productId;
	private Integer storeId;
	private Integer areaId;
	private Integer categoryId;
	private String name;
	private File pictures;
	private Float price;
	private String description;
	private Timestamp createTime;
	private Boolean deleted;
	private String picturesFileName;
	Transaction transaction = null;

	Product product;
	List<Product> listProducts;

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

	public List<Product> getListProducts() {
		return listProducts;
	}

	public void setListProducts(List<Product> listProducts) {
		this.listProducts = listProducts;
	}

	public String getPicturesFileName() {
		return picturesFileName;
	}

	public void setPicturesFileName(String picturesFileName) {
		this.picturesFileName = picturesFileName;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getStoreId() {
		return storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public File getPictures() {
		return pictures;
	}

	public void setPictures(File pictures) {
		this.pictures = pictures;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		Date date = new Date();
		ProductDao productDao = new ProductDao();
		// addProducts(date, productDao);
		System.out.println(productId);
//		deleteProducts(productDao);
		updateProducts(date, productDao);
		// }
		// System.out.println(product.getPictures());
		// productDao.save(product);
		// selectAll(productDao);
		// String whereClause = "";
		// String orderbyClause = " createTime desc";
		// int pageIndex=0;
		// int pageSize=50;
		// queryProducts(productDao, whereClause, orderbyClause, pageIndex,
		// pageSize);
		//
		// for (Product p : listProducts) {
		// System.out.println("a" + p.getPictures());
		// }
		return SUCCESS;
	}

	/**
	 * @param productDao
	 * @param whereClause
	 * @param orderbyClause
	 * @param pageIndex
	 * @param pageSize
	 */
	public void queryProducts(ProductDao productDao, String whereClause,
			String orderbyClause, int pageIndex, int pageSize) {
		DAOQuery _DaoQuery = new DAOQuery();
		if (whereClause != null && whereClause != "") {

			System.out.println("enter the method");
			_DaoQuery.set_whereClause(whereClause);
		}
		if (orderbyClause != null && orderbyClause != "") {
			_DaoQuery.set_orderByString(orderbyClause);
		}
		_DaoQuery.set_pageIndex(pageIndex);
		_DaoQuery.set_pageSize(pageSize);
		// System.out.println("s"+_DaoQuery.getQueryString());
		listProducts = productDao.select(_DaoQuery);

		// listProducts = productDao.selectAll();

	}

	/**
	 * @param date
	 * @param productDao
	 */
	public void updateProducts(Date date, ProductDao productDao) {
		product = productDao.selectById(productId);
		if (this.areaId != null && this.areaId != 0) {
			product.setAreaId(areaId);
		}
		if (this.name != null && this.name != "") {
			product.setName(name);
		}
		if (this.price != null && this.price != 0) {
			product.setPrice(price);
		}
		if (this.storeId != null && this.storeId != 0) {
			product.setStoreId(storeId);
		}
		if (this.categoryId != null && this.categoryId != 0) {
			product.setCategoryId(categoryId);
		}
		if (this.picturesFileName != null && this.picturesFileName != "") {
			try {
				UploadUtil.uploadFile(pictures, picturesFileName, date);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			product.setPictures(UploadUtil.FILENAME + UploadUtil.FILETYPE);
		}
		// if () {
		createTime = Timestamp.valueOf(DateUtil.formatDate(date));
		product.setCreateTime(createTime);

		try {
			transaction = productDao.beginTransaction();
			productDao.update(product);
			transaction.commit();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			transaction.rollback();
			transaction = null;
			e.printStackTrace();
		}
	}

	/**
	 * @param productDao
	 */
	public void deleteProducts(ProductDao productDao) {
		product = productDao.selectById(productId);
		product.setDeleted(true);
		System.out.println("product:" + product.getPictures());
		System.out.println("productDeleted:" + product.getDeleted());
		transaction = productDao.beginTransaction();
		try {
			productDao.update(product);
			transaction.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			transaction.rollback();
			transaction = null;
			e.printStackTrace();
		}

	}

	public void addProducts(Date date, ProductDao productDao) throws Exception {
		createTime = Timestamp.valueOf(DateUtil.formatDate(date));

		// System.out.println(createTime);

		try {
			transaction = productDao.beginTransaction();
			if (UploadUtil.uploadFile(pictures, picturesFileName, date)) {
				System.out.println("文件保存成功");

				product = new Product();
				product.setAreaId(areaId);
				product.setName(name);
				product.setPrice(price);
				product.setStoreId(storeId);
				product.setCategoryId(categoryId);
				product.setPictures(UploadUtil.FILENAME + UploadUtil.FILETYPE);
				product.setCreateTime(createTime);
				productDao.save(product);
				transaction.commit();
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block

			// UploadUtil.deleteFile(UploadUtil.FILENAME,UploadUtil.SAVEPATH);
			transaction.rollback();
			transaction = null;
			e.printStackTrace();
		}
	}

}
