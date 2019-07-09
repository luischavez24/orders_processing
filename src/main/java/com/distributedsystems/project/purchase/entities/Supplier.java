package com.distributedsystems.project.purchase.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="[Supplier]")
public class Supplier {
	@Id
	@Column(name="[Id]")
	private int id;
	
	@Column(name="[CompanyName]", columnDefinition="NVARCHAR")
	private String companyName;
	
	@Column(name="[ContactName]", columnDefinition="NVARCHAR")
	private String contactName;
	
	@Column(name="[City]", columnDefinition="NVARCHAR")
	private String city;
	
	@Column(name="[Country]", columnDefinition="NVARCHAR")
	private String country;

	@Column(name="[Phone]", columnDefinition="NVARCHAR")
	private String phone;
	
	@Column(name="[Fax]", columnDefinition="NVARCHAR")
	private String fax;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}
	
	
}
