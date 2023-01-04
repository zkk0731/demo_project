package com.example.demo_project.service.ifs;



import java.util.List;
import java.util.Optional;

import com.example.demo_project.entity.Person;

public interface PersonService {

	public List<Person> getPersonInfo(); 
	
	public Person getPersonInfoById(String id);
	
	public List<Person> getPersonInfoByAgeLargerThan(int age);
	
	public Person getPersonInfoByNameAndAge(String name,int age);
	
	public List<Person> getPersonByNameAndAgeLargerThan(String name,int age);
}
