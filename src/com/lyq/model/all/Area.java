package com.lyq.model.all;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;

import org.apache.struts2.json.annotations.JSON;

/**
 * Area entity. @author MyEclipse Persistence Tools
 */
@Entity(name="Area")
public class Area implements java.io.Serializable {

	// Fields

	private Integer areaId;
	private Integer parentId;
	private String name;
	private Set addresses = new HashSet(0);
	private Set customers = new HashSet(0);
	private Set areaStores = new HashSet(0);

	// Constructors

	/** default constructor */
	public Area() {
	}

	/** minimal constructor */
	public Area(Integer parentId, String name) {
		this.parentId = parentId;
		this.name = name;
	}

	/** full constructor */
	public Area(Integer parentId, String name, Set addresses, Set customers,
			Set areaStores) {
		this.parentId = parentId;
		this.name = name;
		this.addresses = addresses;
		this.customers = customers;
		this.areaStores = areaStores;
	}

	// Property accessors

	public Integer getAreaId() {
		return this.areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	 @JSON(serialize=false)
	public Set getAddresses() {
		return this.addresses;
	}

	public void setAddresses(Set addresses) {
		this.addresses = addresses;
	}
	 @JSON(serialize=false)
	public Set getCustomers() {
		return this.customers;
	}

	public void setCustomers(Set customers) {
		this.customers = customers;
	}
	 @JSON(serialize=false)
	public Set getAreaStores() {
		return this.areaStores;
	}

	public void setAreaStores(Set areaStores) {
		this.areaStores = areaStores;
	}

}