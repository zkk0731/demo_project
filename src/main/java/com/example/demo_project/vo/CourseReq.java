package com.example.demo_project.vo;

public class CourseReq {

	private String id;
	
	
	private String name;
	
	private Integer day;
	
	private Integer start;
	
	private Integer end;
	
	private Integer credit;

	public CourseReq() {
		
	}
//	public CourseReq(String id,String name,int day,int start,int end,int credit) {
//		this.id = id;
//	}

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getDay() {
		return day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getEnd() {
		return end;
	}

	public void setEnd(Integer end) {
		this.end = end;
	}

	public Integer getCredit() {
		return credit;
	}

	public void setCredit(Integer credit) {
		this.credit = credit;
	}
	
	
	
	
	
	
}
