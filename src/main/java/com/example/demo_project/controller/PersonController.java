package com.example.demo_project.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_project.entity.Person;
import com.example.demo_project.service.ifs.PersonService;
import com.example.demo_project.vo.PersonGeInfoReq;

@RestController
public class PersonController {

	@Autowired
	private PersonService personvice;
	
	@PostMapping(value = "/api/getPersonInfo")
	public List<Person> getPerson(){
		return personvice.getPersonInfo();
	}
	
	@PostMapping(value = "/api/getPersonInfoById")
	public Person getPersonById(@RequestBody PersonGeInfoReq req) {
		return personvice.getPersonInfoById(req.getId());
	}
	
	@PostMapping(value = "/api/getPersonInfoByAge")
	public List<Person> getPersonByAge(@RequestBody PersonGeInfoReq req){
		
		return personvice.getPersonInfoByAgeLargerThan(req.getAge());
		
	}
	
	@PostMapping(value = "/api/getPersonByNameAndAge")
	public Person getPersonByNameAndAge(@RequestBody PersonGeInfoReq req){
		
		return personvice.getPersonInfoByNameAndAge(req.getName(), req.getAge());
		
	}
	
	@PostMapping(value = "/api/getPersonByNameAndAgeGreaterThan")
	public List<Person> getPersonByNameAndAgeGreaterThan(@RequestBody PersonGeInfoReq req){
		
		return personvice.getPersonByNameAndAgeLargerThan(req.getName(), req.getAge());
		
	}
	
	
}
