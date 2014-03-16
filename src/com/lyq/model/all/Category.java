package com.lyq.model.all;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;

/**
 * Category entity. @author MyEclipse Persistence Tools
 */
@Entity(name="Category")
public class Category implements java.io.Serializable {

	// Fields

	private Integer categoryId;
	private Integer parentId;
	private String name;
	private Integer createTime;
	private Boolean deleted;
	private Integer level;
	private Set products = new HashSet(0);

	// Constructors

	/** default constructor */
	public Category() {
	}

	/** minimal constructor */
	public Category(Integer parentId, String name, Integer createTime,
			Boolean deleted, Integer level) {
		this.parentId = parentId;
		this.name = name;
		this.createTime = createTime;
		this.deleted = deleted;
		this.level = level;
	}

	/** full constructor */
	public Category(Integer parentId, String name, Integer createTime,
			Boolean deleted, Integer level, Set products) {
		this.parentId = parentId;
		this.name = name;
		this.createTime = createTime;
		this.deleted = deleted;
		this.level = level;
		this.products = products;
	}

	// Property accessors

	public Integer getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
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

	public Integer getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Integer createTime) {
		this.createTime = createTime;
	}

	public Boolean getDeleted() {
		return this.deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public Integer getLevel() {
		return this.level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Set getProducts() {
		return this.products;
	}

	public void setProducts(Set products) {
		this.products = products;
	}

}