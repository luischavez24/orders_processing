package com.distributedsystems.project.purchase.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="[Order]")
public class Order {

	@Id
	@Column(name="Id")
	private int id;
	
	@Column(name="OrderNumber", columnDefinition="NVARCHAR")
	private String orderNumber;
	
	@Column(name="OrderDate")
	private LocalDateTime orderDate;
	
	@Column(name="TotalAmount", columnDefinition="DECIMAL")
	private double totalAmount;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
}
