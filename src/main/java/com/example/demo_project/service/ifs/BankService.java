package com.example.demo_project.service.ifs;

import com.example.demo_project.entity.Bank;

public interface BankService {

//	public void getAmount(Bank bank);
//	public void deposit(Bank bank,int depositAmount);
//	public void withdraw(Bank bank,int withdrawAmount);
	
	public Bank createAccount(String account);
	public Bank getAmount(String account);
	public Bank deposit(String account,int amount);
	public Bank withdraw(String account,int amount);
	public void deleteAccount(String account);
	public void deleteByName(String name);
}
