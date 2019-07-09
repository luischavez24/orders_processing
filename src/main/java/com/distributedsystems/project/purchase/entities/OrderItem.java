package com.distributedsystems.project.purchase.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="[OrderItem]")
public class OrderItem {
	
	@Id
	@Column(name="[Id]")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="[ProductId]", insertable = false, updatable = false)
	private Product product;
	
	@Column(name="[UnitPrice]", columnDefinition="DECIMAL")
	private double unitPrice;
	
	@Column(name="[Quantity]")
	private int quantity;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
