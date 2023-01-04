package com.example.demo_project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo_project.entity.Course;

@Repository
public interface CourseDao extends JpaRepository<Course, String>{

	public List<Course>findByName(String name);
}
