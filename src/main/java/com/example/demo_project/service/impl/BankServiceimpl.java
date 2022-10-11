package com.example.demo_project.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo_project.entity.Bank;
import com.example.demo_project.service.ifs.BankService;
@Service
public class BankServiceimpl implements BankService{

	@Override
	public Bank getAmount(Bank bank) {
		
		System.out.println("帳號名: "+ bank.getAccount());
		System.out.println("餘額: "+ bank.getAmount());
		
		return bank;
	}

	@Override
	public Bank deposit(Bank bank,int depositAmount) {
		
		bank.setAmount(bank.getAmount()+depositAmount);
		System.out.println("帳號名: "+ bank.getAccount());
		System.out.println("存款: "+ depositAmount);
		System.out.println("餘額: "+ bank.getAmount());
		
		return bank;
	}

	@Override
	public Bank withdraw(Bank bank,int withdrawAmount) {
		
		bank.setAmount(bank.getAmount()-withdrawAmount);
		if(bank.getAmount()<0) {
			System.out.println("餘額不足");
		}
		else {
			System.out.println("帳號名: "+ bank.getAccount());
			System.out.println("提款: "+ withdrawAmount);
			System.out.println("餘額: "+ bank.getAmount());
		}
		
		return bank;
	}

}
