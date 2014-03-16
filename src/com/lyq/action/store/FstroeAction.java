package com.lyq.action.store;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hibernate.Transaction;

import com.framework.Dao.DAOQuery;
import com.framework.Dao.ProductDao;
import com.framework.Dao.StoreDao;
import com.lyq.model.all.Product;
import com.lyq.model.all.Store;
import com.lyq.util1.DateUtil;
import com.lyq.util1.UploadUtil;
import com.opensymphony.xwork2.ActionSupport;

public class FstroeAction extends ActionSupport {

	private Integer storeId;
	private Integer areaId;
	private Integer customerId;
	private String logo;
	private String name;
	private String tel;
	private String mobile;
	private String address;
	private Short state;
	private Integer startTime;
	private Integer endTime;
	private Timestamp crateTime;
	private Float shipPrice;
	private Float shipFee;
	private Float serviceScore;
	private Float speedScore;
	private Float environmentScore;
	private Integer maxpeople;
	Store store;
	Transaction transaction;

	public void setStore(Store store) {
		this.store = store;
	}

	public Store getStore() {
		return store;
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

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Short getState() {
		return state;
	}

	public void setState(Short state) {
		this.state = state;
	}

	public Integer getStartTime() {
		return startTime;
	}

	public void setStartTime(Integer startTime) {
		this.startTime = startTime;
	}

	public Integer getEndTime() {
		return endTime;
	}

	public void setEndTime(Integer endTime) {
		this.endTime = endTime;
	}

	public Timestamp getCrateTime() {
		return crateTime;
	}

	public void setCrateTime(Timestamp crateTime) {
		this.crateTime = crateTime;
	}

	public Float getShipPrice() {
		return shipPrice;
	}

	public void setShipPrice(Float shipPrice) {
		this.shipPrice = shipPrice;
	}

	public Float getShipFee() {
		return shipFee;
	}

	public void setShipFee(Float shipFee) {
		this.shipFee = shipFee;
	}

	public Float getServiceScore() {
		return serviceScore;
	}

	public void setServiceScore(Float serviceScore) {
		this.serviceScore = serviceScore;
	}

	public Float getSpeedScore() {
		return speedScore;
	}

	public void setSpeedScore(Float speedScore) {
		this.speedScore = speedScore;
	}

	public Float getEnvironmentScore() {
		return environmentScore;
	}

	public void setEnvironmentScore(Float environmentScore) {
		this.environmentScore = environmentScore;
	}

	public Integer getMaxpeople() {
		return maxpeople;
	}

	public void setMaxpeople(Integer maxpeople) {
		this.maxpeople = maxpeople;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		Date date = new Date();
		StoreDao storeDao = new StoreDao();
		// addStores(date,storeDao);

		// deleteStores(storeDao);
		// updateStores(storeDao);
		String whereClause = null;
		String orderbyClause = null;
		int pageIndex = 0;
		int pageSize = 5;

//		queryStores(storeDao, whereClause, orderbyClause, pageIndex, pageSize);
		addStores(date,storeDao);
		return SUCCESS;

	}

	/**
	 * @param storeDao
	 * @param whereClause
	 * @param orderbyClause
	 * @param pageIndex
	 * @param pageSize
	 */
	public void queryStores(StoreDao storeDao, String whereClause,
			String orderbyClause, int pageIndex, int pageSize) {
		DAOQuery daoQuery = new DAOQuery();
		if (whereClause != null && whereClause != "") {

			System.out.println("enter the method");
			daoQuery.set_whereClause(whereClause);
		}
		if (orderbyClause != null && orderbyClause != "") {
			daoQuery.set_orderByString(orderbyClause);
		}
		daoQuery.set_pageIndex(pageIndex);
		daoQuery.set_pageSize(pageSize);
		List<Store> list = storeDao.select(daoQuery);
		for (Store st : list) {
			System.out.println(st.getCrateTime());
		}
	}

	/**
	 * @param storeDao
	 */
	public void updateStores(StoreDao storeDao) {
		if (this.endTime != null) {
			store.setEndTime(endTime);
		}
		store = storeDao.selectById(storeId);
		if (this.address != null && this.address != "") {
			store.setAddress(address);
		}
		System.out.println("storeendTime" + store.getEndTime());
		System.out.println("endtime:" + endTime);

		if (this.logo != null && this.logo != "") {
			store.setLogo(logo);
		}
		if (this.maxpeople != null) {
			System.out.println(maxpeople);
			store.setMaxpeople(maxpeople);
		}
		/*
		 * 手机号需要特殊判断
		 */
		if (this.mobile != null) {
			store.setMobile(mobile);
		}
		if (this.name != null && this.name != "") {
			store.setName(name);
		}
		if (this.shipFee != null) {
			store.setShipFee(shipFee);
		}
		if (this.shipPrice != null) {
			store.setShipPrice(shipPrice);
		}
		if (this.speedScore != null) {
			store.setSpeedScore(speedScore);
		}
		if (this.startTime != null) {
			store.setStartTime(startTime);
		}
		if (this.state != null) {
			store.setState(state);
		}
		if (this.tel != null && this.tel != "") {
			store.setTel(tel);
		}

		storeDao.update(store);
	}

	/**
	 * @param storeDao
	 */
	public void deleteStores(StoreDao storeDao) {
		store = storeDao.selectById(storeId);
		store.setDeleted(true);
		storeDao.update(store);
	}

	public void addStores(Date date, StoreDao storeDao) throws Exception {
		crateTime = Timestamp.valueOf(DateUtil.formatDate(date));

		// System.out.println(createTime);
		store = new Store();
		store.setAreaId(areaId);
		store.setCrateTime(crateTime);
		store.setCustomerId(customerId);
		store.setEndTime(endTime);
		store.setLogo(logo);
		store.setMaxpeople(maxpeople);
		store.setMobile(mobile);
		store.setName(name);
		store.setShipFee(shipFee);
		store.setShipPrice(shipPrice);
		store.setStartTime(startTime);
		store.setState(state);
		store.setTel(tel);
		store.setAddress(address);
		storeDao.save(store);

	}

}
