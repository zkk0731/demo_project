package com.example.demo_project.vo;

import java.util.List;

import com.example.demo_project.entity.Course;
import com.example.demo_project.entity.Student;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CourseRes {

	private Course course;
	
	private Student student;
	private String message;
	
	private List<Course> courseList;

	public CourseRes() {
		
	}
	public CourseRes(Course course) {
		this.course = course;
	}
	
	
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public List<Course> getCourseList() {
		return courseList;
	}
	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
