package com.lyq.action.admin;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.framework.Dao.AreaDao;
import com.framework.Dao.CategoryDao;
import com.framework.Dao.DAOQuery;
import com.framework.Dao.ProductDao;
import com.framework.Dao.SlidesDao;
import com.framework.Dao.StoreDao;
import com.framework.Dao.TuanDao;
import com.lyq.model.all.Area;
import com.lyq.model.all.Category;
import com.lyq.model.all.Product;
import com.lyq.model.all.Slides;
import com.lyq.model.all.Store;
import com.lyq.model.all.Tuan;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author fallowu
 * 
 */
public class JSONDeal extends ActionSupport {
	List<Product> listsProducts;
	List<Store> listsStores;
	List<Integer> abcdList;
	List<String> productNameList;
	List<String> cateNameList;
	List<Category> categoryList;
	List<Tuan> listTuans;
	private JSONArray jsonArray;
	private JSONArray categoryJsonArray;
	private JSONArray storeArray;
	Map<Integer, String> sanMap;
	Map<Integer, String> sanMapArea;
	Integer[] sanjivalue;
	Integer sanjiId;
	Integer categoryId;
	Map<Integer, String> storeMap;
	private Integer storeId;
	Integer[] sanjiArea;

	public void setSanjiArea(Integer[] sanjiArea) {
		this.sanjiArea = sanjiArea;
	}

	public Integer[] getSanjiArea() {
		return sanjiArea;
	}

	public void setSanMapArea(Map<Integer, String> sanMapArea) {
		this.sanMapArea = sanMapArea;
	}

	public Map<Integer, String> getSanMapArea() {
		return sanMapArea;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	public Integer getStoreId() {
		return storeId;
	}

	public void setCategoryJsonArray(JSONArray categoryJsonArray) {
		this.categoryJsonArray = categoryJsonArray;
	}

	public JSONArray getCategoryJsonArray() {
		return categoryJsonArray;
	}

	public void setStoreMap(Map<Integer, String> storeMap) {
		this.storeMap = storeMap;
	}

	public Map<Integer, String> getStoreMap() {
		return storeMap;
	}

	public void setStoreArray(JSONArray storeArray) {
		this.storeArray = storeArray;
	}

	public JSONArray getStoreArray() {
		return storeArray;
	}

	public void setJsonArray(JSONArray jsonArray) {
		this.jsonArray = jsonArray;
	}

	public JSONArray getJsonArray() {
		return jsonArray;
	}

	public void setSanMap(Map<Integer, String> sanMap) {
		this.sanMap = sanMap;
	}

	public Map<Integer, String> getSanMap() {
		return sanMap;
	}

	public void setProductNameList(List<String> productNameList) {
		this.productNameList = productNameList;
	}

	public List<String> getProductNameList() {
		return productNameList;
	}

	public void setCateNameList(List<String> cateNameList) {
		this.cateNameList = cateNameList;
	}

	public List<String> getCateNameList() {
		return cateNameList;
	}

	public void setAbcdList(List<Integer> abcdList) {
		this.abcdList = abcdList;
	}

	public List<Integer> getAbcdList() {
		return abcdList;
	}

	public String productInfo() throws Exception {
		String qreString = new String(ServletActionContext.getRequest()
				.getParameter("qproduct"));
		DAOQuery daoQuery = new DAOQuery();
		if (storeId != null) {
			daoQuery.set_whereClause(" store.storeId=" + storeId);
		}
		ProductDao productDao = new ProductDao();
		listsProducts = productDao.select(daoQuery);
		productNameList = new ArrayList<String>();
		for (Product product : listsProducts) {
			if (product.getName().contains(qreString)) {
				System.out.println("aaaaaa:" + product.getName());
				// productNameList.add(i++ + product.getName());
				productNameList.add(product.getName());

			}
		}
		return SUCCESS;
	}
	
	public String productInfo1() throws Exception {
		String qreString = new String(ServletActionContext.getRequest()
				.getParameter("qproduct"));
		DAOQuery daoQuery = new DAOQuery();
		if (storeId != null) {
			daoQuery.set_whereClause(" store.storeId=" + storeId);
		}
		ProductDao productDao = new ProductDao();
		listsProducts = productDao.select(daoQuery);
		productNameList = new ArrayList<String>();
		for (Product product : listsProducts) {
			if (product.getName().contains(qreString)) {
				System.out.println("aaaaaa:" + product.getName());
				// productNameList.add(i++ + product.getName());
				productNameList.add(product.getName());

			}
		}
		return SUCCESS;
	}
	

	public String tuanInfo() throws Exception {
		String qreString = new String(ServletActionContext.getRequest()
				.getParameter("qproduct"));
		TuanDao tuanDao = new TuanDao();
		listTuans = tuanDao.selectAll();
		productNameList = new ArrayList<String>();
		for (Tuan tuan : listTuans) {
			if (tuan.getProduct().getName().contains(qreString)) {
				System.out.println("aaaaaa:" + tuan.getProduct().getName());
				// productNameList.add(i++ + product.getName());
				productNameList.add(tuan.getProduct().getName());

			}
		}
		return SUCCESS;

	}

	public String storeauditInfo() throws UnsupportedEncodingException {
		String qreString = new String(ServletActionContext.getRequest()
				.getParameter("qstore"));

		StoreDao storeDao = new StoreDao();
		DAOQuery daoQuery = new DAOQuery();
		daoQuery.set_whereClause("audit=false");
		storeArray = new JSONArray();
		JSONObject jsonObject = new JSONObject();

		listsStores = storeDao.select(daoQuery);
		storeMap = new HashMap<Integer, String>();
		productNameList = new ArrayList<String>();
		for (Store store : listsStores) {
			if (store.getName().contains(qreString)) {
				jsonObject.put("storeId", store.getStoreId());
				jsonObject.put("name", store.getName());
				storeArray.add(jsonObject);
				productNameList.add(store.getStoreId() + " " + store.getName());

			}
		}
		return SUCCESS;
	}

	public String sanlianCategory() throws Exception {
		CategoryDao categoryDao = new CategoryDao();
		AreaDao areaDao = new AreaDao();
		sanjivalue = new Integer[3];
		sanjiArea = new Integer[3];
		System.out.println("categoryId:" + categoryId + ",");
		sanMap = new HashMap<Integer, String>();
		sanMapArea = new HashMap<Integer, String>();
		if (categoryId != null) {
			sanjivalue[0] = categoryDao.selectById(categoryId).getCategoryId();
			sanjivalue[1] = categoryDao.selectById(sanjivalue[0]).getParentId();
			// sanjivalue[2] = areaDao.selectById(sanjivalue[1]).getParentId();
			sanMap.put(sanjivalue[0], categoryDao.selectById(sanjivalue[0])
					.getName());
			sanMap.put(sanjivalue[1], categoryDao.selectById(sanjivalue[1])
					.getName());
			// sanMap.put(sanjivalue[2], areaDao.selectById(sanjivalue[2])
			// .getName());

			// sanjivalue[0]=areaDao.selectById(sanjiId).getAreaId();
			// sanjivalue[1]=areaDao.selectById(sanjivalue[0]).getParentId();
			// sanjivalue[2]=areaDao.selectById(sanjivalue[1]).getParentId();
		}

		if (sanjiId != null) {
			sanjiArea[0] = areaDao.selectById(sanjiId).getAreaId();
			sanjiArea[1] = areaDao.selectById(sanjiArea[0]).getParentId();
			// sanjivalue[2] = areaDao.selectById(sanjivalue[1]).getParentId();
			sanMapArea.put(sanjiArea[0], areaDao.selectById(sanjiArea[0]).getName());
			sanMapArea.put(sanjiArea[1], areaDao.selectById(sanjiArea[1]).getName());
			// sanMap.put(sanjivalue[2], areaDao.selectById(sanjivalue[2])
			// .getName());

			// sanjivalue[0]=areaDao.selectById(sanjiId).getAreaId();
			// sanjivalue[1]=areaDao.selectById(sanjivalue[0]).getParentId();
			// sanjivalue[2]=areaDao.selectById(sanjivalue[1]).getParentId();
		}
		System.out.println(sanjiArea + "sanjiArea");

		return SUCCESS;
	}

	public String slidesInfo() throws Exception {

		String qreString = new String(ServletActionContext.getRequest()
				.getParameter("qslides"));
		SlidesDao slidesDao = new SlidesDao();
		List<Slides> slideslist = slidesDao.selectAll();
		productNameList = new ArrayList<String>();
		for (Slides slides : slideslist) {
			if (slides.getPicname().contains(qreString)) {
				productNameList.add(slides.getPicname());
			}
		}

		return SUCCESS;
	}

	public String categoryInfo() throws UnsupportedEncodingException {

		ServletRequest request = ServletActionContext.getRequest();
		ServletResponse response = ServletActionContext.getResponse();

		// request.setCharacterEncoding("utf-8");
		// response.setCharacterEncoding("text/html;charset=utf-8");
		// reques
		// ServletActionContext.getResponse().setCharacterEncoding("text/html;charset=utf-8");
		String qreString = new String(request.getParameter("vcategory")
				);
		System.out.println("v:" + qreString);

		CategoryDao categoryDao = new CategoryDao();

		// abcdList=new String[5];
		// abcdList[0]="abc";
		// abcdList[1]="cdf";
		DAOQuery daoQuery = new DAOQuery();
		daoQuery.set_whereClause(" name like '%" + qreString + "%'");
		cateNameList = new ArrayList<String>();
		List<Category> categoryList = categoryDao.select(daoQuery);
		for (Category category : categoryList) {
			// System.out.println(product.getName());
			cateNameList.add(category.getCategoryId() + " "
					+ category.getName());
			System.out.println("11：" + category.getName());
		}

		return SUCCESS;
	}

	/*
	 * 地区三级分类和经营二级分类
	 */
	public String areaInfo() throws Exception {
		AreaDao areaDao = new AreaDao();
		CategoryDao categoryDao = new CategoryDao();
		List<Category> categories = categoryDao.selectAll();
		List<Area> arealists = areaDao.selectAll();
		JSONObject jsonObject = new JSONObject();
		jsonArray = new JSONArray();
		categoryJsonArray = new JSONArray();
		for (Area area : arealists) {
			if (area.getParentId() == 0) {
				jsonObject.put("pid", "根目录");
			} else {
				jsonObject.put("pid", area.getParentId());
			}
			jsonObject.put("cid", area.getAreaId());
			jsonObject.put("name", area.getName());
			jsonArray.add(jsonObject);
		}
		System.out.println(jsonArray.get(0) + "jsong");
		for (Category category : categories) {

			if (category.getParentId() == 0) {
				jsonObject.put("pid", "根目录");
			} else {
				jsonObject.put("pid", category.getParentId());

			}
			jsonObject.put("cid", category.getCategoryId());
			jsonObject.put("name", category.getName());
			categoryJsonArray.add(jsonObject);
		}

		return SUCCESS;
	}
	

	/*
	 *使用storeInfo方法
	 */
	public String storeInfo() throws UnsupportedEncodingException {
		String qreString = new String(ServletActionContext.getRequest()
				.getParameter("qstore"));

		StoreDao storeDao = new StoreDao();
		storeArray = new JSONArray();
		JSONObject jsonObject = new JSONObject();
		listsStores = storeDao.selectAll();
		storeMap = new HashMap<Integer, String>();
		productNameList = new ArrayList<String>();
		for (Store store : listsStores) {
			if (store.getName().contains(qreString)) {
				jsonObject.put("storeId", store.getStoreId());
				jsonObject.put("name", store.getName());
				storeArray.add(jsonObject);
				productNameList.add(store.getStoreId() + " " + store.getName());

			}
		}
		return SUCCESS;
	}
	public Integer[] getSanjivalue() {
		return sanjivalue;
	}

	public void setSanjivalue(Integer[] sanjivalue) {
		this.sanjivalue = sanjivalue;
	}

	public Integer getSanjiId() {
		return sanjiId;
	}

	public void setSanjiId(Integer sanjiId) {
		this.sanjiId = sanjiId;
	}

}
