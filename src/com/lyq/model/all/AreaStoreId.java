package com.lyq.model.all;

import javax.persistence.Entity;

/**
 * AreaStoreId entity. @author MyEclipse Persistence Tools
 */

@Entity(name="AreaStoreId")
public class AreaStoreId implements java.io.Serializable {

	// Fields

	private Integer storeId;
	private Integer areaId;

	// Constructors

	/** default constructor */
	public AreaStoreId() {
	}

	/** full constructor */
	public AreaStoreId(Integer storeId, Integer areaId) {
		this.storeId = storeId;
		this.areaId = areaId;
	}

	// Property accessors

	public Integer getStoreId() {
		return this.storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	public Integer getAreaId() {
		return this.areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AreaStoreId))
			return false;
		AreaStoreId castOther = (AreaStoreId) other;

		return ((this.getStoreId() == castOther.getStoreId()) || (this
				.getStoreId() != null
				&& castOther.getStoreId() != null && this.getStoreId().equals(
				castOther.getStoreId())))
				&& ((this.getAreaId() == castOther.getAreaId()) || (this
						.getAreaId() != null
						&& castOther.getAreaId() != null && this.getAreaId()
						.equals(castOther.getAreaId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getStoreId() == null ? 0 : this.getStoreId().hashCode());
		result = 37 * result
				+ (getAreaId() == null ? 0 : this.getAreaId().hashCode());
		return result;
	}

}