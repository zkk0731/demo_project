package com.example.demo_project.vo;

import java.util.List;

import com.example.demo_project.entity.Menu;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MenuRes {

	
	private List<Menu> menuList;
	
	//private Map<String, Integer> orderList;
	
	private String message;
		
	@JsonProperty(value = "ÁÊ¶R©ú²Ó")
	private List<String> messageList;
	
	private Integer total;

	
	
	public List<String> getMessageList() {
		return messageList;
	}
	public void setMessageList(List<String> messageList) {
		this.messageList = messageList;
	}

//	public Map<String, Integer> getOrderList() {
//		return orderList;
//	}
//
//	public void setOrderList(Map<String, Integer> orderList) {
//		this.orderList = orderList;
//	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	

	public List<Menu> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<Menu> menuList) {
		this.menuList = menuList;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
