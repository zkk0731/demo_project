package com.example.demo_project.controller;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_project.entity.Menu;
import com.example.demo_project.service.ifs.OrderService;
import com.example.demo_project.vo.MenuReq;
import com.example.demo_project.vo.MenuRes;
@RestController
public class MenuController {

	@Autowired
	private OrderService orderservice;
	
	@PostMapping(value = "/api/setMenu")
	public MenuRes setMenu(@RequestBody MenuReq req) {
		MenuRes res = new MenuRes();
		
		if (!StringUtils.hasText(req.getName())) {
			res.setMessage("no name");
			return res;
		}
//		orderservice.setMenu(req.getName(), req.getPrice());
//		if(menu == null) {
//			res.setMessage("Add menu fail");
//			return res;
//		}
		res.setMessage("add success");
		return res;
	}
	
	
	@PostMapping(value = "/api/getAllMenu")
	public MenuRes getAllMenu() {			
		MenuRes res = new MenuRes();
		res.setMenuList(orderservice.getAllMenu());
		res.setMessage("get menu success");
		return res;
	}
	
	@PostMapping(value = "/api/getMenuByName")
	public MenuRes getMenuByName(@RequestBody MenuReq req) {			
		MenuRes res = new MenuRes();
		if (!StringUtils.hasText(req.getName())) {
			res.setMessage("no name");
			return res;
		}
		if(orderservice.getMenuByName(req.getName()) == null){
			res.setMessage("no matched menu");
			return res;
		}
		
		List <Menu> menulist= new ArrayList<>();
		menulist.add(orderservice.getMenuByName(req.getName()));
		res.setMenuList(menulist);
		res.setMessage("get menu success");
		
		return res;
	}
	
	@PostMapping(value = "/api/order")
	public MenuRes orderMenu(@RequestBody MenuReq req) {
		//MenuRes menures = orderservice.orderMenu(req.getOrderList());
		
		return orderservice.orderMenu(req.getOrder());
	}
	
	
}
