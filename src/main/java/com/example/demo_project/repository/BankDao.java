package com.example.demo_project.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo_project.entity.Bank;

@Transactional
@Repository
public interface BankDao extends JpaRepository<Bank, String>{

	
	public void deleteByName(String name);
	
}
