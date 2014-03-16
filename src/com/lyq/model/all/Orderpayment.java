package com.lyq.model.all;

import java.sql.Timestamp;

import javax.persistence.Entity;

/**
 * Orderpayment entity. @author MyEclipse Persistence Tools
 */
@Entity(name="Orderpayment")
public class Orderpayment implements java.io.Serializable {

	// Fields

	private Integer orderPaymentId;
	private Customer customer;
	private Payment payment;
	private Order order;
	private Float amount;
	private Timestamp createTime;

	// Constructors

	/** default constructor */
	public Orderpayment() {
	}

	/** full constructor */
	public Orderpayment(Customer customer, Payment payment, Order order,
			Float amount, Timestamp createTime) {
		this.customer = customer;
		this.payment = payment;
		this.order = order;
		this.amount = amount;
		this.createTime = createTime;
	}

	// Property accessors

	public Integer getOrderPaymentId() {
		return this.orderPaymentId;
	}

	public void setOrderPaymentId(Integer orderPaymentId) {
		this.orderPaymentId = orderPaymentId;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Payment getPayment() {
		return this.payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Float getAmount() {
		return this.amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}