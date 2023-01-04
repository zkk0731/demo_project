package com.example.demo_project;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo_project.controller.BankController;
import com.example.demo_project.entity.Bank;
import com.example.demo_project.service.ifs.BankService;
import com.example.demo_project.vo.BankReq;
import com.example.demo_project.vo.BankRes;

@SpringBootTest
public class Test1011 {

	@Autowired
	private BankService bankservice;
	@Test
	public void test() {
//		Bank bank = new Bank();
//		bankservice.getAmount(bank);
//		System.out.println("==================");
//		bankservice.deposit(bank, 500);
//		System.out.println("==================");
//		bankservice.withdraw(bank, 3000);
		
	}
	@Autowired
	private BankController bankcontroller;
	
	@Test
	public void test1() {
	
//		BankReq req = new BankReq();
//		req.setAccount("ggg");
//		BankRes res = bankcontroller.getAmount(req);
//		System.out.println(res.getBank().getAccount());
//		System.out.println(res.getBank().getAmount());
//		System.out.println(res.getMessage());
		
		
		
		
	}
}
