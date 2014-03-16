package com.lyq.model.all;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;

/**
 * Order entity. @author MyEclipse Persistence Tools
 */
@Entity(name="Order")
public class Order implements java.io.Serializable {

	// Fields

	private Integer orderId;
	private Customer customer;
	private Store store;
	private Payment payment;
	private Float totalPrice;
	private Timestamp sendTime;
	private Integer adrdessId;
	private Timestamp createTime;
	private Short state;
	private Set orderproducts = new HashSet(0);
	private Set orderpayments = new HashSet(0);

	// Constructors

	/** default constructor */
	public Order() {
	}

	/** minimal constructor */
	public Order(Customer customer, Store store, Payment payment,
			Float totalPrice, Timestamp sendTime, Integer adrdessId,
			Timestamp createTime, Short state) {
		this.customer = customer;
		this.store = store;
		this.payment = payment;
		this.totalPrice = totalPrice;
		this.sendTime = sendTime;
		this.adrdessId = adrdessId;
		this.createTime = createTime;
		this.state = state;
	}

	/** full constructor */
	public Order(Customer customer, Store store, Payment payment,
			Float totalPrice, Timestamp sendTime, Integer adrdessId,
			Timestamp createTime, Short state, Set orderproducts,
			Set orderpayments) {
		this.customer = customer;
		this.store = store;
		this.payment = payment;
		this.totalPrice = totalPrice;
		this.sendTime = sendTime;
		this.adrdessId = adrdessId;
		this.createTime = createTime;
		this.state = state;
		this.orderproducts = orderproducts;
		this.orderpayments = orderpayments;
	}

	// Property accessors

	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Store getStore() {
		return this.store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public Payment getPayment() {
		return this.payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Float getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(Float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Timestamp getSendTime() {
		return this.sendTime;
	}

	public void setSendTime(Timestamp sendTime) {
		this.sendTime = sendTime;
	}

	public Integer getAdrdessId() {
		return this.adrdessId;
	}

	public void setAdrdessId(Integer adrdessId) {
		this.adrdessId = adrdessId;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Short getState() {
		return this.state;
	}

	public void setState(Short state) {
		this.state = state;
	}

	public Set getOrderproducts() {
		return this.orderproducts;
	}

	public void setOrderproducts(Set orderproducts) {
		this.orderproducts = orderproducts;
	}

	public Set getOrderpayments() {
		return this.orderpayments;
	}

	public void setOrderpayments(Set orderpayments) {
		this.orderpayments = orderpayments;
	}

}