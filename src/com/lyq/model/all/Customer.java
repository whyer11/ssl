package com.lyq.model.all;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;

/**
 * Customer entity. @author MyEclipse Persistence Tools
 */
@Entity(name="Customer")
public class Customer implements java.io.Serializable {

	// Fields

	private Integer customerId;
	private Area area;
	private Integer storeId;
	private String userName;
	private String password;
	private String realName;
	private Short state;
	private String mobile;
	private Integer score;
	private String avatar;
	private String sex;
	private Date birthday;
	private Timestamp lastVisit;
	private Timestamp registerTime;
	private Timestamp lastTime;
	private String email;
	private Integer encry;
	private Boolean type;
	private String address;
	private Set orderpayments = new HashSet(0);
	private Set orders = new HashSet(0);
	private Set comments = new HashSet(0);
	private Set stores = new HashSet(0);
	private Set addresses = new HashSet(0);
	private Set scorerecords = new HashSet(0);

	// Constructors

	/** default constructor */
	public Customer() {
	}

	/** minimal constructor */
	public Customer(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	/** full constructor */
	public Customer(Area area, Integer storeId, String userName,
			String password, String realName, Short state, String mobile,
			Integer score, String avatar, String sex, Date birthday,
			Timestamp lastVisit, Timestamp registerTime, Timestamp lastTime,
			String email, Integer encry, Boolean type, Set adverts,
			Set orderpayments, Set orders, Set comments, Set stores,
			Set addresses, Set scorerecords) {
		this.area = area;
		this.storeId = storeId;
		this.userName = userName;
		this.password = password;
		this.realName = realName;
		this.state = state;
		this.mobile = mobile;
		this.score = score;
		this.avatar = avatar;
		this.sex = sex;
		this.birthday = birthday;
		this.lastVisit = lastVisit;
		this.registerTime = registerTime;
		this.lastTime = lastTime;
		this.email = email;
		this.encry = encry;
		this.type = type;
		this.orderpayments = orderpayments;
		this.orders = orders;
		this.comments = comments;
		this.stores = stores;
		this.addresses = addresses;
		this.scorerecords = scorerecords;
	}

	// Property accessors

	public Integer getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Area getArea() {
		return this.area;
	}

	public void setArea(Area area) {
		this.area = area;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getStoreId() {
		return this.storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealName() {
		return this.realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public Short getState() {
		return this.state;
	}

	public void setState(Short state) {
		this.state = state;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Integer getScore() {
		return this.score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getAvatar() {
		return this.avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Timestamp getLastVisit() {
		return this.lastVisit;
	}

	public void setLastVisit(Timestamp lastVisit) {
		this.lastVisit = lastVisit;
	}

	public Timestamp getRegisterTime() {
		return this.registerTime;
	}

	public void setRegisterTime(Timestamp registerTime) {
		this.registerTime = registerTime;
	}

	public Timestamp getLastTime() {
		return this.lastTime;
	}

	public void setLastTime(Timestamp lastTime) {
		this.lastTime = lastTime;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getEncry() {
		return this.encry;
	}

	public void setEncry(Integer encry) {
		this.encry = encry;
	}

	public Boolean getType() {
		return this.type;
	}

	public void setType(Boolean type) {
		this.type = type;
	}

	public Set getOrderpayments() {
		return this.orderpayments;
	}

	public void setOrderpayments(Set orderpayments) {
		this.orderpayments = orderpayments;
	}

	public Set getOrders() {
		return this.orders;
	}

	public void setOrders(Set orders) {
		this.orders = orders;
	}

	public Set getComments() {
		return this.comments;
	}

	public void setComments(Set comments) {
		this.comments = comments;
	}

	public Set getStores() {
		return this.stores;
	}

	public void setStores(Set stores) {
		this.stores = stores;
	}

	public Set getAddresses() {
		return this.addresses;
	}

	public void setAddresses(Set addresses) {
		this.addresses = addresses;
	}

	public Set getScorerecords() {
		return this.scorerecords;
	}

	public void setScorerecords(Set scorerecords) {
		this.scorerecords = scorerecords;
	}

}