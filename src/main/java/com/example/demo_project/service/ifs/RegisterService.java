package com.example.demo_project.service.ifs;

import java.util.List;

import com.example.demo_project.entity.Register;
import com.example.demo_project.vo.RegisterResp;

public interface RegisterService {

	public Register register(String account,String pwd,String name,int age,String city);
	
	public RegisterResp activeAccount(String account);
	
	public RegisterResp addRole(String account,List<String> roleList);
	
	public Register findById(String id); 
	
	public List<Register> findAll();
}
