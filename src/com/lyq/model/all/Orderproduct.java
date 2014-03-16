package com.lyq.model.all;

import javax.persistence.Entity;

/**
 * Orderproduct entity. @author MyEclipse Persistence Tools
 */
@Entity(name="Orderproduct")
public class Orderproduct implements java.io.Serializable {

	// Fields

	private OrderproductId id;
	private Product product;
	private Order order;
	private Integer count;

	// Constructors

	/** default constructor */
	public Orderproduct() {
	}

	/** full constructor */
	public Orderproduct(OrderproductId id, Product product, Order order,
			Integer count) {
		this.id = id;
		this.product = product;
		this.order = order;
		this.count = count;
	}

	// Property accessors

	public OrderproductId getId() {
		return this.id;
	}

	public void setId(OrderproductId id) {
		this.id = id;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Integer getCount() {
		return this.count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

}