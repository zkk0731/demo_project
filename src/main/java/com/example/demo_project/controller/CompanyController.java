package com.example.demo_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_project.entity.Company;
import com.example.demo_project.service.ifs.CompanyService;
import com.example.demo_project.vo.CompanyReq;

@RestController
public class CompanyController {

	@Autowired
	private CompanyService companyService;
	
	@PostMapping(value = "/api/findAllCom")
	public List<Company> findAllCom(){
		
		return companyService.findAll();
	}
	
	@PostMapping(value = "/api/findComById")
	public Company findById(@RequestBody CompanyReq orgComId) {
		return companyService.findById(orgComId.getOrgId(),orgComId.getCompanyId());
	}
	
	@PostMapping(value = "/api/updateComById")
	public Company updateById(@RequestBody CompanyReq orgComId) {
		return companyService.updateById(orgComId.getOrgId(),orgComId.getCompanyId());
	}
}
