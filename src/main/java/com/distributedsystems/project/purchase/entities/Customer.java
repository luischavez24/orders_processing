package com.distributedsystems.project.purchase.entities;

import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Table(name="[Customer]")
public class Customer {

	@Id
	@Column(name="[Id]")
	private int id;
	
	@Column(name="[FirstName]", columnDefinition="NVARCHAR")
	private String firstName;
	
	@Column(name="[LastName]", columnDefinition="NVARCHAR")
	private String lastName;
	
	@Column(name="[City]", columnDefinition="NVARCHAR")
	private String city;
	
	@Column(name="[Country]", columnDefinition="NVARCHAR")
	private String country;

	@Column(name="[Phone]", columnDefinition="NVARCHAR")
	private String phone;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	
	
	
}
