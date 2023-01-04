package com.example.demo_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_project.entity.Bank;
import com.example.demo_project.service.ifs.BankService;
import com.example.demo_project.vo.BankReq;
import com.example.demo_project.vo.BankRes;
import com.example.demo_project.vo.DepositReq;
import com.example.demo_project.vo.WithdrawReq;

import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@RestController
public class BankController {

	@Autowired
	private BankService bankservice;

	@PostMapping(value = "/api/getAmount")
	public BankRes getAmount(@RequestBody BankReq request) {
		BankRes res = new BankRes();
		if (!StringUtils.hasText(request.getAccount())) {
			res.setMessage("no account");
			return res;
		}
		Bank bank = bankservice.getAmount(request.getAccount());
		if(bank == null) {
			res.setMessage("account is wrong");
			return res;
		}
		res.setAccount(bank.getAccount());
		res.setAmount(bank.getAmount());
		res.setMessage("success");
		return res;
	}

	@PostMapping(value = "/api/deposit")
	public BankRes deposit(@RequestBody DepositReq req) {
		BankRes res = new BankRes();
		if (!StringUtils.hasText(req.getAccount())) {
			res.setMessage("no account");
			return res;
		}
		if (req.getAmount() < 0) {
			res.setMessage("deposit is negative");
			return res;
		}
		
		Bank bank = bankservice.deposit(req.getAccount(), req.getAmount());
		if(bank == null) {
			res.setMessage("account is wrong");
			return res;
		}
		res.setAccount(bank.getAccount());
		res.setAmount(bank.getAmount());
		res.setMessage("deposit success");
		return res;
	}

	@PostMapping(value = "/api/withdraw")
	public BankRes withdraw(@RequestBody WithdrawReq req) {
		BankRes res = new BankRes();
		if (!StringUtils.hasText(req.getAccount())) {
			res.setMessage("no account");
			return res;
		}
		
		if (req.getAmount() < 0) {
			res.setMessage("withdraw amount is negative");
			return res;
		}
		Bank bank = bankservice.getAmount(req.getAccount());
		if(bank == null) {
			res.setMessage("account is wrong");
			return res;
		}
		if (bank.getAmount() - req.getAmount() < 0) {
			res.setMessage("¾lÃB¤£¨¬");
			return res;
		}
		bank = bankservice.withdraw(req.getAccount(), req.getAmount());
		res.setAccount(bank.getAccount());
		res.setAmount(bank.getAmount());
		res.setMessage("withdraw success");
		return res;
	}

	@PostMapping(value = "/api/createAccount")
	public BankRes create(@RequestBody BankReq request) {
		BankRes res = new BankRes();
		if (!StringUtils.hasText(request.getAccount())) {
			res.setMessage("no account");
			return res;
		}
		
			Bank bank = bankservice.createAccount(request.getAccount());
			if(bank == null) {
				res.setMessage("account can't be created");
				return res;
			}
			res.setAccount(bank.getAccount());
			res.setAmount(bank.getAmount());
			res.setMessage("create success");
		return res;
	}
	
	@PostMapping(value = "/api/deleteAccount")
	public BankRes delete(@RequestBody BankReq request) {
		BankRes res = new BankRes();
		bankservice.deleteAccount(request.getAccount());
		
		res.setMessage("success");
		return res;
		
	}
	
	@PostMapping(value = "/api/deleteByName")
	public BankRes deleteByName(@RequestBody BankReq request) {
		bankservice.deleteByName(request.getName());
		BankRes res = new BankRes();
		res.setMessage("delete success");
		return res;
	}
	
}
