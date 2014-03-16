package com.lyq.model.all;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;

import org.apache.struts2.json.annotations.JSON;

/**
 * Store entity. @author MyEclipse Persistence Tools
 */
@Entity(name = "Store")
public class Store implements java.io.Serializable {

	// Fields

	// Fields
	private String[] ImageLinkArray;

	public String[] getImageLinkArray() {
		return ImageLinkArray;
	}

	public void setImageLinkArray(String[] imageLinkArray) {
		ImageLinkArray = imageLinkArray;
	}

	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

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
	private Integer maxpeople;
	private Boolean audit;
	private String email;
	private Integer categoryId;
	private Integer sendorno;
	private Set areaStores = new HashSet(0);
	private Set products = new HashSet(0);
	private Set comments = new HashSet(0);
	private Set tuans = new HashSet(0);
	private Set orders = new HashSet(0);
	private Set smses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Store() {
	}

	/** minimal constructor */
	public Store(Customer customer, Integer categoryId, Integer sendorno) {
		this.customer = customer;
		this.categoryId = categoryId;
		this.sendorno = sendorno;
	}

	/** full constructor */
	public Store(Customer customer, String logo, String name, String tel,
			String mobile, String address, Boolean state, Integer startTime,
			Integer endTime, Timestamp crateTime, Float shipPrice,
			Float shipFee, Float serviceScore, Float speedScore,
			Float environmentScore, Integer maxpeople, Boolean audit,
			String email, Integer categoryId, Integer sendorno, Set areaStores,
			Set products, Set comments, Set tuans, Set orders, Set smses) {
		this.customer = customer;
		this.logo = logo;
		this.name = name;
		this.tel = tel;
		this.mobile = mobile;
		this.address = address;
		this.state = state;
		this.startTime = startTime;
		this.endTime = endTime;
		this.crateTime = crateTime;
		this.shipPrice = shipPrice;
		this.shipFee = shipFee;
		this.serviceScore = serviceScore;
		this.speedScore = speedScore;
		this.environmentScore = environmentScore;
		this.maxpeople = maxpeople;
		this.audit = audit;
		this.email = email;
		this.categoryId = categoryId;
		this.sendorno = sendorno;
		this.areaStores = areaStores;
		this.products = products;
		this.comments = comments;
		this.tuans = tuans;
		this.orders = orders;
		this.smses = smses;
	}

	// Property accessors

	public Integer getStoreId() {
		return this.storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	@JSON(serialize = false)
	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getLogo() {
		return this.logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Boolean getState() {
		return this.state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

	public Integer getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Integer startTime) {
		this.startTime = startTime;
	}

	public Integer getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Integer endTime) {
		this.endTime = endTime;
	}

	public Timestamp getCrateTime() {
		return this.crateTime;
	}

	public void setCrateTime(Timestamp crateTime) {
		this.crateTime = crateTime;
	}

	public Float getShipPrice() {
		return this.shipPrice;
	}

	public void setShipPrice(Float shipPrice) {
		this.shipPrice = shipPrice;
	}

	public Float getShipFee() {
		return this.shipFee;
	}

	public void setShipFee(Float shipFee) {
		this.shipFee = shipFee;
	}

	public Float getServiceScore() {
		return this.serviceScore;
	}

	public void setServiceScore(Float serviceScore) {
		this.serviceScore = serviceScore;
	}

	public Float getSpeedScore() {
		return this.speedScore;
	}

	public void setSpeedScore(Float speedScore) {
		this.speedScore = speedScore;
	}

	public Float getEnvironmentScore() {
		return this.environmentScore;
	}

	public void setEnvironmentScore(Float environmentScore) {
		this.environmentScore = environmentScore;
	}

	public Integer getMaxpeople() {
		return this.maxpeople;
	}

	public void setMaxpeople(Integer maxpeople) {
		this.maxpeople = maxpeople;
	}

	public Boolean getAudit() {
		return this.audit;
	}

	public void setAudit(Boolean audit) {
		this.audit = audit;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getSendorno() {
		return this.sendorno;
	}

	public void setSendorno(Integer sendorno) {
		this.sendorno = sendorno;
	}

	@JSON(serialize = false)
	public Set getAreaStores() {
		return this.areaStores;
	}

	public void setAreaStores(Set areaStores) {
		this.areaStores = areaStores;
	}

	@JSON(serialize = false)
	public Set getProducts() {
		return this.products;
	}

	public void setProducts(Set products) {
		this.products = products;
	}

	@JSON(serialize = false)
	public Set getComments() {
		return this.comments;
	}

	public void setComments(Set comments) {
		this.comments = comments;
	}

	@JSON(serialize = false)
	public Set getTuans() {
		return this.tuans;
	}

	public void setTuans(Set tuans) {
		this.tuans = tuans;
	}

	@JSON(serialize = false)
	public Set getOrders() {
		return this.orders;
	}

	public void setOrders(Set orders) {
		this.orders = orders;
	}

	public Set getSmses() {
		return this.smses;
	}

	public void setSmses(Set smses) {
		this.smses = smses;
	}

}