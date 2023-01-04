package com.example.demo_project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "product_name")
	private String productName;
	@Column(name = "quantity")
	private int quantity;
	@Column(name = "customers_id")
	private int customersId;
	
//	@OneToMany(mappedBy="department")
//	private 
	
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
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getCustomersId() {
		return customersId;
	}
	public void setCustomersId(int customersId) {
		this.customersId = customersId;
	}
	
	
}
