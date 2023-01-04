package com.example.demo_project.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DepositReq {

	@JsonProperty("account")
	private String account;
	@JsonProperty("amount")
	private int amount;
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
}
