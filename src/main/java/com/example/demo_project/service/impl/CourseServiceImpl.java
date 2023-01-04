package com.example.demo_project.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo_project.constants.CourseRtnCode;
import com.example.demo_project.entity.Course;
import com.example.demo_project.repository.CourseDao;
import com.example.demo_project.service.ifs.CourseService;
import com.example.demo_project.vo.CourseRes;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseDao courseDao;

	@Override
	public Course addCourse(String id, String name, int day, int start, int end, int credit) {
		if (courseDao.existsById(id)) {
			return null;
		}
		Course course = new Course(id, name, day, start, end, credit);
		return courseDao.save(course);
	}

	@Override
	public Course alterCourse(String id,String name, int day, int start, int end, int credit) {
		Optional<Course> courseOp = courseDao.findById(id);
		if (courseOp.isPresent()) {
			Course course = courseOp.get();
			course = new Course(id, name, day, start, end, credit);
			return courseDao.save(course);
		}
		return null;
	}

	@Override
	public CourseRes deleteCourse(String id) {
		CourseRes res = new CourseRes();
		Optional<Course> courseOp = courseDao.findById(id);
		if (courseOp.isPresent()) {			
			courseDao.deleteById(id);
			res.setMessage(CourseRtnCode.SUCCESS.getMessage());
			return res;
		}
		res.setMessage(CourseRtnCode.ID_NOT_EXIST.getMessage());
		return res;
	}

	@Override
	public CourseRes findCourseById(String id) {
		CourseRes res = new CourseRes();
		Optional<Course> courseOp = courseDao.findById(id);
		if (courseOp.isPresent()) {	
			Course course = courseOp.get();
			res.setCourse(course);
			res.setMessage(CourseRtnCode.SUCCESS.getMessage());
			return res;
		}
		res.setMessage(CourseRtnCode.ID_NOT_EXIST.getMessage());
		return res;
	}

	@Override
	public CourseRes findCourseByName(String name) {
		CourseRes res = new CourseRes();
		List<Course> courseList = courseDao.findByName(name);
		if (courseList.isEmpty()) {	
			res.setMessage(CourseRtnCode.NAME_NOT_EXIST.getMessage());
			return res;
		}
		res.setCourseList(courseList);
		res.setMessage(CourseRtnCode.SUCCESS.getMessage());
		return res;
		
	}

	@Override
	public CourseRes courseSelection(List<String> courseSelList) {
		int totalCredit = 0;
		
		return null;
	}

}
