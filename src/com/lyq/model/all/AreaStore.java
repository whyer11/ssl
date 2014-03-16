package com.lyq.model.all;

import javax.persistence.Entity;

import org.apache.struts2.json.annotations.JSON;

/**
 * AreaStore entity. @author MyEclipse Persistence Tools
 */

@Entity(name="AreaStore")
public class AreaStore implements java.io.Serializable {

	// Fields

	private AreaStoreId id;
	private Area area;
	private Store store;
	private Integer reachTime;

	// Constructors

	/** default constructor */
	public AreaStore() {
	}

	/** full constructor */
	public AreaStore(AreaStoreId id, Area area, Store store, Integer reachTime) {
		this.id = id;
		this.area = area;
		this.store = store;
		this.reachTime = reachTime;
	}

	// Property accessors

	public AreaStoreId getId() {
		return this.id;
	}

	public void setId(AreaStoreId id) {
		this.id = id;
	}
   
	public Area getArea() {
		return this.area;
	}

	public void setArea(Area area) {
		this.area = area;
	}
	
	public Store getStore() {
		return this.store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public Integer getReachTime() {
		return this.reachTime;
	}

	public void setReachTime(Integer reachTime) {
		this.reachTime = reachTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AreaStore other = (AreaStore) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	

}