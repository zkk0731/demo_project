package com.example.demo_project.vo;

import java.util.List;

public class MenuReq {

	private String name;
	
	private int price;
	
	private int amount;
	
	private List<MenuReq> order;
	
//	@JsonProperty("orderlist")
//	private Map<String,Integer> orderList;

	
	
	

	public String getName() {
		return name;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public List<MenuReq> getOrder() {
		return order;
	}

	public void setOrder(List<MenuReq> order) {
		this.order = order;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

//	public Map<String, Integer> getOrderList() {
//		return orderList;
//	}
//
//	public void setOrderList(Map<String, Integer> orderList) {
//		this.orderList = orderList;
//	}
	
	
}
