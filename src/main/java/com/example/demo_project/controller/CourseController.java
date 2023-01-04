package com.example.demo_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_project.constants.CourseRtnCode;
import com.example.demo_project.entity.Course;
import com.example.demo_project.service.ifs.CourseService;
import com.example.demo_project.vo.CourseReq;
import com.example.demo_project.vo.CourseRes;

@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	private CourseRes courseParamCheck(CourseReq req) {
		CourseRes res = new CourseRes();
		if(!StringUtils.hasText(req.getId())) {
			res.setMessage(CourseRtnCode.ID_REQUIRED.getMessage());
			return res;
		}
		if(!StringUtils.hasText(req.getName())) {
			res.setMessage(CourseRtnCode.NAME_REQUIRED.getMessage());
			return res;
		}
		if(req.getDay() == null) {
			res.setMessage(CourseRtnCode.DAY_REQUIRED.getMessage());
			return res;
		}
		if(req.getStart() == null) {
			res.setMessage(CourseRtnCode.START_REQUIRED.getMessage());
			return res;
		}
		if(req.getEnd() == null) {
			res.setMessage(CourseRtnCode.END_REQUIRED.getMessage());
			return res;
		}
		if(req.getDay()<1 || req.getDay()>7) {
			res.setMessage(CourseRtnCode.DAY_FAIL.getMessage());
			return res;
		}
		
		if(req.getStart()<8||req.getStart()>16 ||req.getStart()>req.getEnd() 
				||req.getEnd()<9||req.getEnd()>17) {
			res.setMessage(CourseRtnCode.TIME_PARAM_ERROR.getMessage());
			return res;
		}
		if(req.getCredit() == null) {
			res.setMessage(CourseRtnCode.CREDIT_REQUIRED.getMessage());
			return res;
		}
		if(req.getCredit()<1 || req.getCredit()>3) {
			res.setMessage(CourseRtnCode.CREDIT_PARAM_ERROR.getMessage());
			return res;
		}
		return null;
	}
	
	@PostMapping(value = "/api/add_course")
	public CourseRes addCourse(@RequestBody CourseReq req) {
		CourseRes check = courseParamCheck(req);
		if(check != null) {
			return check;
		}
		CourseRes res = new CourseRes();
		Course course = courseService.addCourse(req.getId(), req.getName(), req.getDay(), req.getStart(), req.getEnd(), req.getCredit());
		if(course == null) {
			res.setMessage(CourseRtnCode.ID_EXIST.getMessage());
			return res;
		}
		res = new CourseRes(course);
		res.setMessage(CourseRtnCode.SUCCESS.getMessage());
		return res;
	}
	
	@PostMapping(value = "/api/alter_course")
	public CourseRes alterCourse(@RequestBody CourseReq req) {
		CourseRes check = courseParamCheck(req);
		if(check != null) {
			return check;
		}
		
		CourseRes res = new CourseRes();
		
		Course course = courseService.alterCourse(req.getId(),req.getName(), req.getDay()
				, req.getStart(), req.getEnd(), req.getCredit());
		if(course == null) {
			res.setMessage(CourseRtnCode.ID_NOT_EXIST.getMessage());
			return res;
		}
		res = new CourseRes(course);
		res.setMessage(CourseRtnCode.SUCCESS.getMessage());
		return res;
	}
	
	@PostMapping(value = "/api/delete_course")
	public CourseRes deleteCourse(@RequestBody CourseReq req) {
		CourseRes res = new CourseRes();
		if(!StringUtils.hasText(req.getId())) {
			res.setMessage(CourseRtnCode.ID_REQUIRED.getMessage());
			return res;
		}
		return courseService.deleteCourse(req.getId());
	}
	
	@PostMapping(value = "/api/find_course_by_id")
	public CourseRes findCourseById(@RequestBody CourseReq req) {
		CourseRes res = new CourseRes();
		if(!StringUtils.hasText(req.getId())) {
			res.setMessage(CourseRtnCode.ID_REQUIRED.getMessage());
			return res;
		}
		return courseService.findCourseById(req.getId());
	}
	
	@PostMapping(value = "/api/find_course_by_name")
	public CourseRes findCourseByName(@RequestBody CourseReq req) {
		CourseRes res = new CourseRes();
		if(!StringUtils.hasText(req.getName())) {
			res.setMessage(CourseRtnCode.NAME_REQUIRED.getMessage());
			return res;
		}
		return courseService.findCourseByName(req.getName());
	}
	
}
