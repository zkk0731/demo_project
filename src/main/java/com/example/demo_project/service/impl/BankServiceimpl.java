package com.example.demo_project.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo_project.entity.Bank;
import com.example.demo_project.repository.BankDao;
import com.example.demo_project.service.ifs.BankService;

@Service
public class BankServiceimpl implements BankService {

	@Autowired
	private BankDao bankdao;
	
//	@Override
//	public void getAmount(Bank bank) {
//
////		System.out.println("帳號名: " + bank.getAccount());
////		System.out.println("餘額: " + bank.getAmount());
//		
//		
//	}
//
//	@Override
//	public void deposit(Bank bank, int depositAmount) {
//
//		bank.setAmount(bank.getAmount() + depositAmount);
//		System.out.println("帳號名: " + bank.getAccount());
//		System.out.println("存款: " + depositAmount);
//		System.out.println("餘額: " + bank.getAmount());
//
//	}
//
//	@Override
//	public void withdraw(Bank bank, int withdrawAmount) {
//		if (bank.getAmount() - withdrawAmount < 0){
//			System.out.println("餘額不足");
//		}
//		else {
//		bank.setAmount(bank.getAmount() - withdrawAmount);
//		System.out.println("帳號名: " + bank.getAccount());
//		System.out.println("提款: " + withdrawAmount);
//		System.out.println("餘額: " + bank.getAmount());
//		}
//	}

	@Override
	public Bank getAmount(String account) {
//		Bank bank = new Bank();
//		bank.setAccount(account);
//		bank.setAmount(1000);		
		return bankdao.findById(account).orElse(null);
	}

	@Override
	public Bank deposit(String account, int amount) {
//		Bank bank = new Bank();
//		bank.setAccount(account);
//		bank.setAmount(amount+bank.getAmount());
//		return bank;
		
		if(bankdao.findById(account).isPresent()) {			
			Bank bank = bankdao.findById(account).get();
			bank.setAmount(bank.getAmount() + amount);
			return bankdao.saveAndFlush(bank);			
		}
		return null;
		
	}

	@Override
	public Bank withdraw(String account, int amount) {
//		Bank bank = new Bank();
//		bank.setAccount(account);
//		bank.setAmount(bank.getAmount()-amount);
//		return bank;
		
		if(bankdao.findById(account).isPresent()) {
						
			Bank bank = bankdao.findById(account).get();
			bank.setAmount(bank.getAmount() - amount);
			return bankdao.saveAndFlush(bank);			
		}
		return null;
	}

	@Override
	public Bank createAccount(String account) {
		if(bankdao.findById(account).isPresent()) {
			return null;
		}		
		Bank bank = new Bank(account);
		return bankdao.save(bank);
	}

	@Transactional
	@Override
	public void deleteAccount(String account) throws RuntimeException{
		
		bankdao.deleteById(account);
		System.out.println("delete success");
		throw new RuntimeException("error");
	}


	@Override
	public void deleteByName(String name) throws RuntimeException{
		
		bankdao.deleteByName(name);
//		throw new RuntimeException("error");
	}
	
	

}
