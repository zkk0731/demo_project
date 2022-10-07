package com.example.demo_project.service.ifs;

import com.example.demo_project.entity.Menu;

public interface OrderService {

	public void getPrice(String name);
	
	public void totalPrice(String name,int amount);
	
	public  void printInfo();
}
