package com.example.demo_project;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo_project.entity.Bank;
import com.example.demo_project.service.ifs.BankService;

@SpringBootTest
public class Test1011 {

	@Autowired
	private BankService bankservice;
	@Test
	public void test() {
		Bank bank = new Bank();
		bankservice.getAmount(bank);
		bankservice.deposit(bank, 500);
		bankservice.withdraw(bank, 3000);
		
	}
	
}
