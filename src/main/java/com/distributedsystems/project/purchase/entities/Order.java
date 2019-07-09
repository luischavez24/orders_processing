package com.distributedsystems.project.purchase.entities;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="[Order]")
public class Order {

	@Id
	@Column(name="[Id]")
	private int id;
	
	@Column(name="[OrderNumber]", columnDefinition="NVARCHAR")
	private String orderNumber;
	
	@Column(name="[OrderDate]")
	private LocalDateTime orderDate;
	
	@Column(name="[TotalAmount]", columnDefinition="DECIMAL")
	private double totalAmount;

	@ManyToOne
	@JoinColumn(name="[CustomerId]", insertable = false, updatable = false)
	private Customer customer;
	
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name = "[OrderId]", insertable=false, updatable=false)
	private List<OrderItem> items;
	
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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void setItems(List<OrderItem> items) {
		this.items = items;
	}
}
