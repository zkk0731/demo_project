package com.example.demo_project.service.impl;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo_project.entity.Person;
import com.example.demo_project.repository.PersonDao;
import com.example.demo_project.service.ifs.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonDao personDao;
	
//	Person person1 = new Person("A1", "Tom", 10);
//	Person person2 = new Person("A2", "Adam", 20);
//	Person person3 = new Person("A3", "John", 15);
//	Person person4 = new Person("B1", "Mike", 40);
//	Person person5 = new Person("B2", "Mary", 35);

	@Override
	public List<Person> getPersonInfo() {
//		List<Person> personList = new ArrayList<>();

//		personList.add(person1);
//		personList.add(person2);
//		personList.add(person3);
//		personList.add(person4);
//		personList.add(person5);
		
		return personDao.findAll();
	}

	@Override
	public Person getPersonInfoById(String id) {
		// List<Person> personList = getPersonInfo();

		
//		for (Person person : getPersonInfo()) {
//			if (person.getId().equalsIgnoreCase(id)) {
//				return person;
//			}
//		}
//		if(personDao.findById(id).isPresent()) {
//			return personDao.findById(id).get();
//		}
		return personDao.findById(id).orElse(null);
	}

	@Override
	public List<Person> getPersonInfoByAgeLargerThan(int age) {
		// List<Person> personList = getPersonInfo();
//		List<Person> personListByAge = new ArrayList<>();
//		for (Person person : getPersonInfo()) {
//			if (person.getAge() > age) {
//				personListByAge.add(person);
//			}
//		}
		return personDao.findByAgeGreaterThan(age);
	}

	@Override
	public Person getPersonInfoByNameAndAge(String name, int age) {
		
		return personDao.findByNameAndAge(name, age);
	}

	@Override
	public List<Person> getPersonByNameAndAgeLargerThan(String name, int age) {
		
		return personDao.findByNameAndAgeGreaterThan(name, age);
	}
	
	
}
