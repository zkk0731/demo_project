package com.example.demo_project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo_project.entity.Person;
import com.example.demo_project.service.ifs.PersonService;
@Service
public class PersonServiceImpl implements PersonService {

	
	@Override
	public Person getPersonInfo(String id) {
		Person person = new Person();
		person.setId(id);
		person.setAddress("xxxroad");
		person.setCity("Tainan");
		person.setName("apple");
		person.setAge(19);

		return person;
	}

	public void printPersonInfo(Person person) {
		System.out.println(person.getId());
		System.out.println(person.getAddress());
		System.out.println(person.getCity());
		System.out.println(person.getName());
		System.out.println(person.getAge());
		
		
	}
	
}
