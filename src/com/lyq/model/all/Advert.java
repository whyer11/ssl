package com.lyq.model.all;

import java.sql.Timestamp;

import javax.persistence.Entity;

/**
 * Advert entity. @author MyEclipse Persistence Tools
 */
@Entity(name="Advert")
public class Advert implements java.io.Serializable {

	// Fields

	private Integer advertId;

	private String address;
	private String subject;
	private String content;
	private Timestamp createTime;	
	private String type;

	public Integer getAdvertId() {
		return advertId;
	}

	public void setAdvertId(Integer advertId) {
		this.advertId = advertId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}