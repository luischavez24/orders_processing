package com.distributedsystems.project.purchase.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="[Product]")
public class Product {
	@Id
	@Column(name="[Id]")
	private int id;
	
	@Column(name="[ProductName]", columnDefinition="NVARCHAR")
	private String productName;
	
	@ManyToOne
	@JoinColumn(name="[SupplierId]", insertable = false, updatable = false)
	private Supplier supplier;
	
	@Column(name="[UnitPrice]", columnDefinition="DECIMAL")
	private double unitPrice;
	
	@Column(name="[Package]", columnDefinition="NVARCHAR")
	private String packages;
	
	@Column(name="[IsDiscontinued]")
	private boolean isDiscontinued;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getPackages() {
		return packages;
	}

	public void setPackages(String packages) {
		this.packages = packages;
	}

	public boolean isDiscontinued() {
		return isDiscontinued;
	}

	public void setDiscontinued(boolean isDiscontinued) {
		this.isDiscontinued = isDiscontinued;
	}
	
	
}
