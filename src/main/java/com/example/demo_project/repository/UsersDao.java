package com.example.demo_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo_project.entity.Users;

@Repository
public interface UsersDao extends JpaRepository<Users, Integer> {

	public Users findByUserName(String userName);
}
