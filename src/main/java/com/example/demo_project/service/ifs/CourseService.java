package com.example.demo_project.service.ifs;

import java.util.List;

import com.example.demo_project.entity.Course;
import com.example.demo_project.vo.CourseRes;

public interface CourseService {

	public Course addCourse(String id,String name,int day,int start,int end,int credit);
	
	public Course alterCourse(String id,String name,int day,int start,int end,int credit);
	
	public CourseRes deleteCourse(String id);
	
	public CourseRes findCourseById(String id);
	
	public CourseRes findCourseByName(String name);
	
	public CourseRes courseSelection(List<String> courseSelList);
}
