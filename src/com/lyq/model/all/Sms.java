package com.lyq.model.all;

import java.sql.Timestamp;

import javax.persistence.Entity;

/**
 * Sms entity. @author MyEclipse Persistence Tools
 */
@Entity(name="Sms")
public class Sms implements java.io.Serializable {

	// Fields

	private Integer smsId;
	private Store store;
	private String mobile;
	private String content;
	private Timestamp sendTime;
	private Short state;

	// Constructors

	/** default constructor */
	public Sms() {
	}

	/** full constructor */
	public Sms(Store store, String mobile, String content, Timestamp sendTime,
			Short state) {
		this.store = store;
		this.mobile = mobile;
		this.content = content;
		this.sendTime = sendTime;
		this.state = state;
	}

	// Property accessors

	public Integer getSmsId() {
		return this.smsId;
	}

	public void setSmsId(Integer smsId) {
		this.smsId = smsId;
	}

	public Store getStore() {
		return this.store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getSendTime() {
		return this.sendTime;
	}

	public void setSendTime(Timestamp sendTime) {
		this.sendTime = sendTime;
	}

	public Short getState() {
		return this.state;
	}

	public void setState(Short state) {
		this.state = state;
	}

}