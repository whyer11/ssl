package com.lyq.model.all;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

public class storeFrontPage {
	private Integer storeId;
	private Customer customer;
	private String logo;
	private String name;
	private String tel;
	private String mobile;
	private String address;
	private Boolean state;
	private Integer startTime;
	private Integer endTime;
	private Timestamp crateTime;
	private Float shipPrice;
	private Float shipFee;
	private Float serviceScore;
	private Float speedScore;
	private Float environmentScore;
	public Integer getStoreId() {
		return storeId;
	}
	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
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
	public Boolean getState() {
		return state;
	}
	public void setState(Boolean state) {
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
	public Boolean getAudit() {
		return audit;
	}
	public void setAudit(Boolean audit) {
		this.audit = audit;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Set getProducts() {
		return products;
	}
	public void setProducts(Set products) {
		this.products = products;
	}
	public Set getComments() {
		return comments;
	}
	public void setComments(Set comments) {
		this.comments = comments;
	}
	public Set getTuans() {
		return tuans;
	}
	public void setTuans(Set tuans) {
		this.tuans = tuans;
	}
	public Set getAreaStores() {
		return areaStores;
	}
	public void setAreaStores(Set areaStores) {
		this.areaStores = areaStores;
	}
	public Set getOrders() {
		return orders;
	}
	public void setOrders(Set orders) {
		this.orders = orders;
	}
	public Set getSmses() {
		return smses;
	}
	public void setSmses(Set smses) {
		this.smses = smses;
	}
	public Set getAdverts() {
		return adverts;
	}
	public void setAdverts(Set adverts) {
		this.adverts = adverts;
	}
	public AreaStoreId getId() {
		return id;
	}
	public void setId(AreaStoreId id) {
		this.id = id;
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
	public Integer getReachTime() {
		return reachTime;
	}
	public void setReachTime(Integer reachTime) {
		this.reachTime = reachTime;
	}
	public String getCoverArea() {
		return coverArea;
	}
	public void setCoverArea(String coverArea) {
		this.coverArea = coverArea;
	}
	private Integer maxpeople;
	private Boolean audit;
	private String email;
	private Set products = new HashSet(0);
	private Set comments = new HashSet(0);
	private Set tuans = new HashSet(0);
	private Set areaStores = new HashSet(0);
	private Set orders = new HashSet(0);
	private Set smses = new HashSet(0);
	private Set adverts = new HashSet(0);
	private AreaStoreId id;
	private Area area;
	private Store store;
	private Integer reachTime;
    private String coverArea;
	
	
	

}
