package com.lyq.model.all;

import java.sql.Timestamp;

import javax.persistence.Entity;

/**
 * Tuan entity. @author MyEclipse Persistence Tools
 */
@Entity(name = "Tuan")
public class Tuan implements java.io.Serializable {

	// Fields

	private Integer tuanId;
	private Store store;
	private Product product;
	private Float currentPrice;
	private Integer limitCount;
	private Timestamp deadTime;
	private Timestamp startTime;
	private Timestamp createTime;
	private Boolean state;

	// Constructors

	/** default constructor */
	public Tuan() {
	}

	/** full constructor */
	public Tuan(Store store, Product product, Float currentPrice,
			Integer limitCount, Timestamp deadTime, Timestamp startTime,
			Timestamp createTime, Boolean state) {
		this.store = store;
		this.product = product;
		this.currentPrice = currentPrice;
		this.limitCount = limitCount;
		this.deadTime = deadTime;
		this.startTime = startTime;
		this.createTime = createTime;
		this.state = state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

	public Boolean getState() {
		return state;
	}

	// Property accessors

	public Integer getTuanId() {
		return this.tuanId;
	}

	public void setTuanId(Integer tuanId) {
		this.tuanId = tuanId;
	}

	public Store getStore() {
		return this.store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Float getCurrentPrice() {
		return this.currentPrice;
	}

	public void setCurrentPrice(Float currentPrice) {
		this.currentPrice = currentPrice;
	}

	public Integer getLimitCount() {
		return this.limitCount;
	}

	public void setLimitCount(Integer limitCount) {
		this.limitCount = limitCount;
	}

	public Timestamp getDeadTime() {
		return this.deadTime;
	}

	public void setDeadTime(Timestamp deadTime) {
		this.deadTime = deadTime;
	}

	public Timestamp getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}