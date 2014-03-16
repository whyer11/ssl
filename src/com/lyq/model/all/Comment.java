package com.lyq.model.all;

import java.sql.Timestamp;

import javax.persistence.Entity;

/**
 * Comment entity. @author MyEclipse Persistence Tools
 */
@Entity(name="Comment")
public class Comment implements java.io.Serializable {

	// Fields

	private Integer commentId;
	private Customer customer;
	private Store store;
	private Product product;
	private String content;
	private Timestamp commentTime;
	private Integer environmentScore;
	private Integer reachTime;
	private Integer speedScore;
	private Integer serviceScore;
	private Boolean state;

	// Constructors

	/** default constructor */
	public Comment() {
	}

	/** minimal constructor */
	public Comment(Customer customer, Store store, Product product,
			Timestamp commentTime, Integer environmentScore, Integer reachTime,
			Integer speedScore, Integer serviceScore) {
		this.customer = customer;
		this.store = store;
		this.product = product;
		this.commentTime = commentTime;
		this.environmentScore = environmentScore;
		this.reachTime = reachTime;
		this.speedScore = speedScore;
		this.serviceScore = serviceScore;
	}

	/** full constructor */
	public Comment(Customer customer, Store store, Product product,
			String content, Timestamp commentTime, Integer environmentScore,
			Integer reachTime, Integer speedScore, Integer serviceScore,Boolean state) {
		this.customer = customer;
		this.store = store;
		this.product = product;
		this.content = content;
		this.commentTime = commentTime;
		this.environmentScore = environmentScore;
		this.reachTime = reachTime;
		this.speedScore = speedScore;
		this.serviceScore = serviceScore;
		this.state=state;
	}

	// Property accessors

	public void setState(Boolean state) {
		this.state = state;
	}
	public Boolean getState() {
		return state;
	}
	
	public Integer getCommentId() {
		return this.commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
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

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getCommentTime() {
		return this.commentTime;
	}

	public void setCommentTime(Timestamp commentTime) {
		this.commentTime = commentTime;
	}

	public Integer getEnvironmentScore() {
		return this.environmentScore;
	}

	public void setEnvironmentScore(Integer environmentScore) {
		this.environmentScore = environmentScore;
	}

	public Integer getReachTime() {
		return this.reachTime;
	}

	public void setReachTime(Integer reachTime) {
		this.reachTime = reachTime;
	}

	public Integer getSpeedScore() {
		return this.speedScore;
	}

	public void setSpeedScore(Integer speedScore) {
		this.speedScore = speedScore;
	}

	public Integer getServiceScore() {
		return this.serviceScore;
	}

	public void setServiceScore(Integer serviceScore) {
		this.serviceScore = serviceScore;
	}

}