package com.lyq.model.all;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;

/**
 * Payment entity. @author MyEclipse Persistence Tools
 */
@Entity(name="Payment")
public class Payment implements java.io.Serializable {

	// Fields

	private Integer paymentId;
	private String name;
	private Set scorerecords = new HashSet(0);
	private Set orderpayments = new HashSet(0);
	private Set orders = new HashSet(0);

	// Constructors

	/** default constructor */
	public Payment() {
	}

	/** minimal constructor */
	public Payment(String name) {
		this.name = name;
	}

	/** full constructor */
	public Payment(String name, Set scorerecords, Set orderpayments, Set orders) {
		this.name = name;
		this.scorerecords = scorerecords;
		this.orderpayments = orderpayments;
		this.orders = orders;
	}

	// Property accessors

	public Integer getPaymentId() {
		return this.paymentId;
	}

	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set getScorerecords() {
		return this.scorerecords;
	}

	public void setScorerecords(Set scorerecords) {
		this.scorerecords = scorerecords;
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

}