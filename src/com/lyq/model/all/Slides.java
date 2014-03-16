package com.lyq.model.all;

import java.sql.Timestamp;

import javax.persistence.Entity;

/**
 * Slides entity. @author MyEclipse Persistence Tools
 */

@Entity(name="Slides")
public class Slides implements java.io.Serializable {

	// Fields

	private Integer slideId;
	private String picname;
	private String picUrl;
	private String url;
	private Boolean state;
	private Boolean deleted;
	private Timestamp createTime;

	// Constructors

	/** default constructor */
	public Slides() {
	}

	/** minimal constructor */
	public Slides(Boolean state) {
		this.state = state;
	}

	/** full constructor */
	public Slides(String picname, String picUrl, String url, Boolean state,
			Boolean deleted,Timestamp createTime) {
		this.picname = picname;
		this.picUrl = picUrl;
		this.url = url;
		this.state = state;
		this.deleted = deleted;
		this.createTime=createTime;
	}

	// Property accessors

	public Integer getSlideId() {
		return this.slideId;
	}

	public void setSlideId(Integer slideId) {
		this.slideId = slideId;
	}

	public String getPicname() {
		return this.picname;
	}

	public void setPicname(String picname) {
		this.picname = picname;
	}

	public String getPicUrl() {
		return this.picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Boolean getState() {
		return this.state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

	public Boolean getDeleted() {
		return this.deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}

}