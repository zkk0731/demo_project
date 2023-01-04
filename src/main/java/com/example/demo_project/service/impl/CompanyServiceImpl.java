package com.example.demo_project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo_project.entity.Company;
import com.example.demo_project.entity.OrgCompanyId;
import com.example.demo_project.repository.CompanyDao;
import com.example.demo_project.service.ifs.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService{

	@Autowired
	private CompanyDao companydao;
	
	@Override
	public List<Company> findAll() {
		return companydao.findAll();
		
	}

	@Override
	public Company findById(String orgId,String companyId) {
		OrgCompanyId orgcompanyid = new OrgCompanyId(orgId,companyId);
		
		return companydao.findById(orgcompanyid).orElse(null);
		
	}

	@Override
	public Company updateById(String orgId, String companyId) {
		OrgCompanyId orgcompanyid = new OrgCompanyId(orgId,companyId);
		
		if(companydao.findById(orgcompanyid).isPresent()) {
			Company com = companydao.findById(orgcompanyid).get();
			com.setCompanyName("AA");
			Company newCom = companydao.save(com);
			return newCom;
		}
		
		return null;
	}

}
