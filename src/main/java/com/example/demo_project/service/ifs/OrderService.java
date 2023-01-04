package com.example.demo_project.service.ifs;

import java.util.List;

import com.example.demo_project.entity.Menu;
import com.example.demo_project.vo.MenuReq;
import com.example.demo_project.vo.MenuRes;

public interface OrderService {

	public Menu setMenu(String name,int price);
	
	//public int order(Menu menu,int amount);
	
	//public void printInfo(int total);
	
	public List<Menu> getAllMenu();
	
	public Menu getMenuByName(String name);
	
	public MenuRes orderMenu(List<MenuReq> order);
	
	
}
