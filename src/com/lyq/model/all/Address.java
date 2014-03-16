package com.lyq.model.all;

import javax.persistence.Entity;

/**
 * Address entity. @author MyEclipse Persistence Tools
 */
@Entity(name="Address")
public class Address implements java.io.Serializable {

	// Fields

	private Integer addressId;
	private Area area;
	private Customer customer;
	private String detailAddress;

	// Constructors

	/** default constructor */
	public Address() {
	}

	/** minimal constructor */
	public Address(Area area, Customer customer) {
		this.area = area;
		this.customer = customer;
	}

	/** full constructor */
	public Address(Area area, Customer customer, String detailAddress) {
		this.area = area;
		this.customer = customer;
		this.detailAddress = detailAddress;
	}

	// Property accessors

	public Integer getAddressId() {
		return this.addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public Area getArea() {
		return this.area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getDetailAddress() {
		return this.detailAddress;
	}

	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}

}