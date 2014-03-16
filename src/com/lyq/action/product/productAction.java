package com.lyq.action.product;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSONArray;

import org.codehaus.jettison.json.JSONObject;
import org.apache.commons.lang.SystemUtils;
import org.apache.struts2.json.annotations.JSON;
import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;
import org.omg.CORBA.PRIVATE_MEMBER;









import com.Yun.UpYun;
import com.framework.Dao.CategoryDao;
import com.framework.Dao.CustomerDao;
import com.framework.Dao.DAOQuery;
import com.framework.Dao.ProductDao;
import com.framework.Dao.StoreDao;
import com.lyq.action.BaseAction;
import com.lyq.model.all.Area;
import com.lyq.model.all.Category;
import com.lyq.model.all.Customer;
import com.lyq.model.all.Product;
import com.lyq.model.all.Store;
import com.lyq.productserialization.PostJSONSerializer;
import com.lyq.util1.UploadUtil;


/* sunbiao
 * 
 */

public class productAction extends BaseAction {
	/**
	 * 
	 */
    private Integer currentPage;
	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	private Integer sellCount;

	public Integer getSellCount() {
		return sellCount;
	}

	public void setSellCount(Integer sellCount) {
		this.sellCount = sellCount;
	}

	private String[] imageLinkArray;

	public String[] getImageLinkArray() {
		return imageLinkArray;
	}

	public void setImageLinkArray(String[] imageLinkArray) {
		this.imageLinkArray = imageLinkArray;
	}

	private static String picLink = "";

	public static String getPicLink() {
		return picLink;
	}

	public static void setPicLink(String picLink) {
		productAction.picLink = picLink;
	}

	private static final String BUCKET_NAME = "sunbiaobiaooooo";
	private static final String USER_NAME = "sunbiaobiaooooo";
	private static final String USER_PWD = "sunbiaobiao";
	/** 绑定的域名 */
	private static final String URL = "http://" + BUCKET_NAME
			+ ".b0.upaiyun.com";

	/** 根目录 */
	private static final String DIR_ROOT = "/";

	/** 上传到upyun的图片名 */
	private static final String PIC_NAME = "14.png";

	/** 本地待上传的测试文件 */
	private static final String SAMPLE_PIC_FILE = System
			.getProperty("user.dir") + "/WebRoot/upload/15.png";

	private static UpYun upyun = null;
	static {
		File picFile = new File(SAMPLE_PIC_FILE);

		if (!picFile.isFile()) {
			System.out.println("本地待上传的测试文件不存在!");
		}
	}

	private String youpaiFilePath;

	public String getYoupaiFilePath() {
		return youpaiFilePath;
	}

	public void setYoupaiFilePath(String youpaiFilePath) {
		this.youpaiFilePath = youpaiFilePath;
	}

	private Integer procategoryId;

	public Integer getProcategoryId() {
		return procategoryId;
	}

	public void setProcategoryId(Integer procategoryId) {
		this.procategoryId = procategoryId;
	}

	private Integer categoryId;

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	private Integer storeId;

	public Integer getStoreId() {
		return storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	private String categoryName;

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	private Integer productId;
	private Category category;
	private Area area;
	private Store store;
	private String name;
	private String pictures;
	private Float price;
	private String description;
	private Timestamp createTime;
	private Boolean deleted;
	private Boolean auditState;
	private Set orderproducts = new HashSet(0);
	private Set tuans = new HashSet(0);
	private Set comments = new HashSet(0);
	private Product _pro;
	private File myfile;

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	private String fileName;
	private String result;
	private Map<String, String> map = new HashMap<String, String>();


	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public File getMyfile() {
		return myfile;
	}

	public void setMyfile(File myfile) {
		this.myfile = myfile;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPictures() {
		return pictures;
	}

	public void setPictures(String pictures) {
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

	public Boolean getAuditState() {
		return auditState;
	}

	public void setAuditState(Boolean auditState) {
		this.auditState = auditState;
	}

	public Set getOrderproducts() {
		return orderproducts;
	}

	public void setOrderproducts(Set orderproducts) {
		this.orderproducts = orderproducts;
	}

	public Set getTuans() {
		return tuans;
	}

	public void setTuans(Set tuans) {
		this.tuans = tuans;
	}

	public Set getComments() {
		return comments;
	}

	public void setComments(Set comments) {
		this.comments = comments;
	}

	public Product get_pro() {
		return _pro;
	}

	public void set_pro(Product _pro) {
		this._pro = _pro;
	}

	public CategoryDao get_categoryDao() {
		return _categoryDao;
	}

	public void set_categoryDao(CategoryDao _categoryDao) {
		this._categoryDao = _categoryDao;
	}

	public ProductDao get_product() {
		return _product;
	}

	public void set_product(ProductDao _product) {
		this._product = _product;
	}

	// 添加商品图片t
	private String massage;

	public String getMassage() {
		return massage;
	}

	public void setMassage(String massage) {
		this.massage = massage;
	}

	// 把图片上传到又拍服务器上去
	public String savaPicToyoupai() throws IOException {
		upyun = new UpYun(BUCKET_NAME, USER_NAME, USER_PWD);
		upyun.setDebug(true);
		// testWriteFile();
		// 上传后文件位置
		String filePath = DIR_ROOT + this.myfile.getName();
		// 本地文件位置
		// File file = new File(SAMPLE_PIC_FILE);
		upyun.setContentMD5(UpYun.md5(myfile));
		upyun.setFileSecret("bac");

		// 上传文件，并自动创建父级目录（最多10级）
		boolean result = upyun.writeFile(filePath, myfile, true);
		System.out.println(filePath + " 上传" + isSuccess(result));

		// 获取上传文件后的信息（仅图片空间有返回数据）
		System.out.println("\r\n****** " + myfile.getName() + " 的图片信息 *******");
		// 图片宽度
		System.out.println("图片宽度:" + upyun.getPicWidth());
		// 图片高度
		System.out.println("图片高度:" + upyun.getPicHeight());
		// 图片帧数
		System.out.println("图片帧数:" + upyun.getPicFrames());
		// 图片类型
		System.out.println("图片类型:" + upyun.getPicType());

		System.out.println("****************************************\r\n");

		System.out.println("若设置过访问密钥(bac)，且缩略图间隔标志符为'!'，则可以通过以下路径来访问图片：");
		System.out.println(URL + filePath + "!bac");
		System.out.println();
		youpaiFilePath = URL + filePath;
		this.picLink = this.picLink + "," + this.youpaiFilePath;
		System.out.println(this.picLink);
		map.put("fileName", this.youpaiFilePath);
		return SUCCESS;
	}

	// 保存商品信息到数据库

	public String SaveProductInfo() {
		StoreDao storeDao = new StoreDao();
		Store store = new Store();
		Product pro = new Product();
		String userName = (String) session.get("login_username");
		Customer customer = new Customer();

		CustomerDao customerDao = new CustomerDao();
		customer = customerDao.findByUserName(userName);
		System.out.println(customer.getRealName());
		store = storeDao.selectById(customer.getStoreId());
		System.out.println(store.getName());
		System.out.println(Integer.valueOf(this.categoryId));
		category = _categoryDao.selectById(Integer.valueOf(this.categoryId));
		System.out.println(category.getName());
		pro.setCategory(category);
		pro.setDescription(description);
		pro.setPrice(price);
		pro.setName(this.name);
		pro.setDeleted(true);
		pro.setStore(store);
	//	pro.setArea(store.getArea());
		pro.setPictures(picLink);

		pro.setCreateTime(new Timestamp(new Date().getTime()));
		ProductDao productDao = new ProductDao();
		productDao.save(pro);
		picLink = "";
		return SUCCESS;
	}

	public String savaProductPic() throws Exception {
		UploadUtil.uploadFile(myfile, "sssss.jpg", new Date());
		// this.fileName="sdfs";

		this.fileName = "\\Shop\\upload\\" + UploadUtil.FILENAME + ".jpg";
		System.out.println(this.fileName);

		map.put("fileName", this.fileName);
		JSONObject jo = new JSONObject();
		jo.put("fileName", this.fileName);

		System.out.println(this.result);

		return SUCCESS;
	}

	List<Category> categories;

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public String execute() {
		CategoryDao _categoryDao = new CategoryDao();
		DAOQuery _DaoQuery = new DAOQuery();
		_DaoQuery.set_whereClause("parentId=" + this.procategoryId);
		_DaoQuery.set_pageIndex(0);
		_DaoQuery.set_pageSize(10);
		this.categories = _categoryDao.select(_DaoQuery);
		

		return SUCCESS;
	}

	// 查询最新上架的商品
	public String latestProduct() {
		DAOQuery _DaoQuery = new DAOQuery();
		_DaoQuery.set_whereClause(" categoryId=" + this.categoryId);
		_DaoQuery.set_pageIndex(0);
		_DaoQuery.set_pageSize(4);
		_DaoQuery.set_orderByString("createTime");
		this.products = _product.select(_DaoQuery);
		for (Product product : products) {
			product.setImageLinkArray(product.getPictures().split(","));

		}

		return "product_list";
	}

	// 查询销量最高的商品

	public String largeSellCountPro() {
		DAOQuery _DaoQuery = new DAOQuery();
		_DaoQuery.set_whereClause(" categoryId=" + this.categoryId);
		_DaoQuery.set_pageIndex(0);
		_DaoQuery.set_pageSize(4);
		_DaoQuery.set_orderByString("sellCount");
		this.products = _product.select(_DaoQuery);
		for (Product product : products) {
			product.setImageLinkArray(product.getPictures().split(","));

		}

		return "product_list";
	}

	// 查询某一类别下的所有商品
	// 根据类别id查询所有的商品
	private CategoryDao _categoryDao = new CategoryDao();
	List<Product> products;

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	ProductDao _product = new ProductDao();

	public String getAllByCategoryId() {
		DAOQuery _DaoQuery = new DAOQuery();
		_DaoQuery.set_whereClause("categoryid="+procategoryId);
		
		_DaoQuery.set_pageIndex(0);
		_DaoQuery.set_pageSize(9);
		this.products = _product.select(_DaoQuery);
		for (Product product : products) {
			product.setImageLinkArray(product.getPictures().split(","));

		}
		
		return "product_list1";
	}
    
    
   JSONArray jsonArray=new JSONArray();

	public JSONArray getJsonArray() {
	return jsonArray;
}


	
public void setJsonArray(JSONArray jsonArray) {
	this.jsonArray = jsonArray;
}

net.sf.json.JSONObject jsonObject=new net.sf.json.JSONObject();

	public net.sf.json.JSONObject getJsonObject() {
	return jsonObject;
}

public void setJsonObject(net.sf.json.JSONObject jsonObject) {
	this.jsonObject = jsonObject;
}

	public String getAllByCategoryId1() {
		DAOQuery _DaoQuery = new DAOQuery();
		_DaoQuery.set_whereClause("categoryid="+procategoryId);
		System.out.println(this.currentPage);
		if(this.currentPage != null){
			_DaoQuery.set_pageIndex(this.currentPage);
		}
		else{
			_DaoQuery.set_pageIndex(0);
		}
		
		_DaoQuery.set_pageSize(9);
		this.products = _product.select(_DaoQuery);
		for (Product product : products) {
			product.setImageLinkArray(product.getPictures().split(","));

		}
		System.out.println(products.get(0).getImageLinkArray().toString());
		this.jsonArray=PostJSONSerializer.tosimpleArray(this.products);
		
		 System.out.println(jsonArray);
		return SUCCESS;
	}

	//返回单个商品的信息
	public String getProDetailInfo(){
		System.out.println(this.productId);
		_pro=_product.selectById(this.productId);
		_pro.setImageLinkArray(_pro.getPictures().split(","));
		
		System.out.println(_pro.getImageLinkArray()[1]);
		//jsonObject=PostJSONSerializer.toSimpleObject(product);
		System.out.println(_pro.getName());
		return "singlePro";
	}
	
	
	private static String isSuccess(boolean result) {
		return result ? " 成功" : " 失败";
	}

}
