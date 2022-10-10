package com.example.demo_project.service.ifs;

import com.example.demo_project.entity.Menu;

public interface OrderService {

	public Menu setMenu(String name,int price);
	
	public int order(Menu menu,int amount);
	
	public void printInfo(int total);
}
