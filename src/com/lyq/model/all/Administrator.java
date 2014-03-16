package com.lyq.model.all;

import javax.persistence.Entity;

/**
 * Administrator entity. @author MyEclipse Persistence Tools
 */
@Entity(name="Administrator")
public class Administrator implements java.io.Serializable {

	// Fields

	private Integer administratorId;
	private String realName;
	private String password;
	private String phone;

	// Constructors

	/** default constructor */
	public Administrator() {
	}

	/** minimal constructor */
	public Administrator(String realName, String password) {
		this.realName = realName;
		this.password = password;
	}

	/** full constructor */
	public Administrator(String realName, String password, String phone) {
		this.realName = realName;
		this.password = password;
		this.phone = phone;
	}

	// Property accessors

	public Integer getAdministratorId() {
		return this.administratorId;
	}

	public void setAdministratorId(Integer administratorId) {
		this.administratorId = administratorId;
	}

	public String getRealName() {
		return this.realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}