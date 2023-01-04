package com.example.demo_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_project.entity.Widget;
import com.example.demo_project.service.ifs.WidgetService;

@RestController
public class WidgetController {

	@Autowired
	private WidgetService widgetservice;
	
	@RequestMapping(value = "/api/saveWidget")
	public Widget saveWidget() {
		
		return widgetservice.save();
	}
	
}
