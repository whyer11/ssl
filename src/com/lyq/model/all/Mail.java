package com.lyq.model.all;

/**
 * Mail entity. @author MyEclipse Persistence Tools
 */

public class Mail implements java.io.Serializable {

	// Fields

	private Integer mailId;
	private String email;
	private String username;
	private String password;
	private Integer salt;
	private Integer areaId;
	private String address;
	

	// Constructors

	public Integer getSalt() {
		return salt;
	}

	public void setSalt(Integer salt) {
		this.salt = salt;
	}

	/** default constructor */
	public Mail() {
	}

	/** full constructor */
	public Mail(String email, String username, String password) {
		this.email = email;
		this.username = username;
		this.password = password;
	}

	// Property accessors

	public Integer getMailId() {
		return this.mailId;
	}

	public void setMailId(Integer mailId) {
		this.mailId = mailId;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Mail [mailId=" + mailId + ", email=" + email + ", username="
				+ username + ", password=" + password + ", salt=" + salt + "]";
	}


	

}