package com.lyq.action.admin;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.framework.Dao.DAOQuery;
import com.framework.Dao.ProductDao;
import com.lyq.model.all.Product;

public  class ActionDealHelper {
/*	 String searchClause;
	 DAOQuery daoQuery;
	 Integer rowCount;
	 ProductDao productDao;
	 String showsIdString;
	 Integer storeId;
	 String selectValue;
	 boolean unDeleted;
	 boolean hasDeleted;
	 Integer pageCount;
	 Integer pageSize = null;
	 Integer pageIndex = null;
	 List<Product> lists;
	 Map<String, Object> maps;
	 */
	
	/**
	 * @param daoQuery
	 * @param selectOne
	 * @param selectTwo
	 * @param selectThird
	 * @param selectFour
	 */
	 /*
	  * 列表排序使用
	  */
	
	 
	public static void selectValueMethod(DAOQuery daoQuery, String selectValue, String selectOne,
			String selectTwo, String selectThird, String selectFour) {
		if (selectValue.equals(selectOne)) {					
			daoQuery.set_orderByString(selectOne);
		}
		if (selectValue.equals(selectTwo)) {
			daoQuery.set_orderByString(selectTwo+" desc");
		}
		if (selectValue.equals(selectThird)) {
			daoQuery.set_orderByString(selectThird);
		}
		if (selectValue.equals(selectFour)) {
			daoQuery.set_orderByString("");
		}
	}
	/**
	 * @param daoQuery
	 * @param rowCount
	 * @param storeId
	 * @param pageSize
	 * @param showsIdString
	 * @throws UnsupportedEncodingException
	 * @throws NumberFormatException
	 */
	/*public  Map<String, Object>  listFunction()throws UnsupportedEncodingException, NumberFormatException {
		if (searchClause!=null&&searchClause!="") {
			 searchClause=new String(searchClause.getBytes("iso-8859-1"), "utf-8");
			 System.out.println("searchCluasePage:"+searchClause);
			 daoQuery.set_whereClause(" name like '%" + searchClause + "%'");
				rowCount = productDao
						.selectCount("select count(*) from Product where  name like '%"
								+ searchClause + "%'");
		}						
		
		if (showsIdString != null && showsIdString != "") {
			storeId = Integer.valueOf(showsIdString);
		}
		if (storeId != -1) {
			daoQuery.set_whereClause("store.storeId=" + storeId);
		}			
		
		if (selectValue != null) {
			ActionDealHelper.selectValueMethod(daoQuery, selectValue,
					"price", "store", "category", "createTime");
		}
		String sqlCountString="select count(*) from Product where deleted=";
		
		if (unDeleted) {
			sqlCountString+="false ";
			if (searchClause!=null&&searchClause!="") {
				sqlCountString+="and name like '%"+searchClause+"%'";
			}
			daoQuery.set_whereClause(" deleted=false and name like '%"+searchClause+"%'");
			rowCount = productDao
					.selectCount(sqlCountString);
		}	
		
		
		if (hasDeleted) {				
			sqlCountString+="true ";
			if (searchClause!=null&&searchClause!="") {
				sqlCountString+="and name like '%"+searchClause+"%'";
			}				
			System.out.println(sqlCountString);
			daoQuery.set_whereClause(" deleted=true and name like '%"+searchClause+"%'");
			rowCount = productDao
					.selectCount(sqlCountString);
		}
		if (rowCount == -1) {
			rowCount = productDao
					.selectCount("select count(*) from Product ");
		}
		
		if (rowCount >= 1) {
			pageCount = (rowCount - 1) / pageSize + 1;
		} else {
			pageCount = 0;
		}
		
		if (pageIndex==null||pageIndex<=0) {
			pageIndex=1;
		}
		if (pageIndex > pageCount) {
			pageIndex = pageCount;
		}
		daoQuery.set_pageIndex(pageIndex - 1);
		daoQuery.set_pageSize(pageSize);		
		 lists = productDao.select(daoQuery);
		 maps=new HashMap<String, Object>();
		 maps.put("searchClause", searchClause);
		 
		return null;
	}
	public String getSearchClause() {
		return searchClause;
	}
	public void setSearchClause(String searchClause) {
		this.searchClause = searchClause;
	}
	public DAOQuery getDaoQuery() {
		return daoQuery;
	}
	public void setDaoQuery(DAOQuery daoQuery) {
		this.daoQuery = daoQuery;
	}
	public Integer getRowCount() {
		return rowCount;
	}
	public void setRowCount(Integer rowCount) {
		this.rowCount = rowCount;
	}
	public ProductDao getProductDao() {
		return productDao;
	}
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	public String getShowsIdString() {
		return showsIdString;
	}
	public void setShowsIdString(String showsIdString) {
		this.showsIdString = showsIdString;
	}
	public Integer getStoreId() {
		return storeId;
	}
	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}
	public String getSelectValue() {
		return selectValue;
	}
	public void setSelectValue(String selectValue) {
		this.selectValue = selectValue;
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
	public Integer getPageCount() {
		return pageCount;
	}
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}
	public List<Product> getLists() {
		return lists;
	}
	public void setLists(List<Product> lists) {
		this.lists = lists;
	}
	public Map<String, Object> getMaps() {
		return maps;
	}
	public void setMaps(Map<String, Object> maps) {
		this.maps = maps;
	}
	*/
	
}
