package com.ssl.user.xuanchuan.mode;

import java.sql.Timestamp;

import com.lyq.model.all.Customer;
import com.lyq.model.all.Store;

public class AdvertMode

{
	private Integer advertId;
	private String name;
	private String address;
	private String subject;
	private String content;
	private Timestamp createTime;

	public Integer getAdvertId() {
		return advertId;
	}

	public void setAdvertId(Integer advertId) {
		this.advertId = advertId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	@Override
	public String toString() {
		return "AdvertMode [advertId=" + advertId + ", name=" + name
				+ ", address=" + address + ", subject=" + subject
				+ ", content=" + content + ", createTime=" + createTime + "]";
	}

}
