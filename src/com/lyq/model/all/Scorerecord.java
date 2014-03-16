package com.lyq.model.all;

import java.sql.Timestamp;

import javax.persistence.Entity;

/**
 * Scorerecord entity. @author MyEclipse Persistence Tools
 */
@Entity(name="Scorerecord")
public class Scorerecord implements java.io.Serializable {

	// Fields

	private Integer scoreRecordId;
	private Customer customer;
	private Payment payment;
	private Integer score;
	private Timestamp creatTime;

	// Constructors

	/** default constructor */
	public Scorerecord() {
	}

	/** full constructor */
	public Scorerecord(Customer customer, Payment payment, Integer score,
			Timestamp creatTime) {
		this.customer = customer;
		this.payment = payment;
		this.score = score;
		this.creatTime = creatTime;
	}

	// Property accessors

	public Integer getScoreRecordId() {
		return this.scoreRecordId;
	}

	public void setScoreRecordId(Integer scoreRecordId) {
		this.scoreRecordId = scoreRecordId;
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

	public Integer getScore() {
		return this.score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Timestamp getCreatTime() {
		return this.creatTime;
	}

	public void setCreatTime(Timestamp creatTime) {
		this.creatTime = creatTime;
	}

}