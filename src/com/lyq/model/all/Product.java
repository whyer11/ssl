package com.lyq.model.all;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;

/**
 * Product entity. @author MyEclipse Persistence Tools
 */
@Entity(name="Product")
public class Product implements java.io.Serializable {

	// Fields
    private String[] ImageLinkArray;
	public String[] getImageLinkArray() {
		return ImageLinkArray;
	}

	public void setImageLinkArray(String[] imageLinkArray) {
		ImageLinkArray = imageLinkArray;
	}

	private Integer productId;
	private Category category;
	private Area area;
	private Store store;
	private String name;
	private String pictures;
	private Float price;
	private String description;
	private Timestamp createTime;
	private Boolean deleted;
	private Integer sellCount;
	private Set orderproducts = new HashSet(0);
	private Set comments = new HashSet(0);
	private Set tuans = new HashSet(0);

	// Constructors

	/** default constructor */
	public Product() {
	}

	/** minimal constructor */
	public Product(Category category, Area area, Store store, String name,
			Boolean deleted) {
		this.category = category;
		this.area = area;
		this.store = store;
		this.name = name;
		this.deleted = deleted;
	}

	/** full constructor */
	public Product(Category category, Area area, Store store, String name,
			String pictures, Float price, String description,
			Timestamp createTime, Boolean deleted, Integer sellCount,
			Set orderproducts, Set comments, Set tuans) {
		this.category = category;
		this.area = area;
		this.store = store;
		this.name = name;
		this.pictures = pictures;
		this.price = price;
		this.description = description;
		this.createTime = createTime;
		this.deleted = deleted;
		this.sellCount = sellCount;
		this.orderproducts = orderproducts;
		this.comments = comments;
		this.tuans = tuans;
	}

	// Property accessors

	public Integer getProductId() {
		return this.productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPictures() {
		return this.pictures;
	}

	public void setPictures(String pictures) {
		this.pictures = pictures;
	}

	public Float getPrice() {
		return this.price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Boolean getDeleted() {
		return this.deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public Integer getSellCount() {
		return this.sellCount;
	}

	public void setSellCount(Integer sellCount) {
		this.sellCount = sellCount;
	}

	public Set getOrderproducts() {
		return this.orderproducts;
	}

	public void setOrderproducts(Set orderproducts) {
		this.orderproducts = orderproducts;
	}

	public Set getComments() {
		return this.comments;
	}

	public void setComments(Set comments) {
		this.comments = comments;
	}

	public Set getTuans() {
		return this.tuans;
	}

	public void setTuans(Set tuans) {
		this.tuans = tuans;
	}

	

}