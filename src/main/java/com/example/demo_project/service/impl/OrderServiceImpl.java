package com.example.demo_project.service.impl;

import com.example.demo_project.entity.Menu;
import com.example.demo_project.service.ifs.OrderService;

public class OrderServiceImpl implements OrderService {

	Menu menu = new Menu();
	@Override
	public void getPrice(String name) {
		//Menu menu = new Menu();
		if (name.equals("beef")) {
			System.out.println("�\�I��:" + name + "���欰 100");
			menu.setPrice(100);
		}
		if (name.equals("pork")) {
			System.out.println("�\�I��:" + name + "���欰 90");
			menu.setPrice(90);
		}
		if (name.equals("chicken")) {
			System.out.println("�\�I��:" + name + "���欰 80");
			menu.setPrice(80);
		}
	}

	@Override
	public void totalPrice(String name,int amount) {

		getPrice(name);
		System.out.println(menu.getPrice()*amount);
	}

	@Override
	public void printInfo() {
		// TODO Auto-generated method stub

	}

}
