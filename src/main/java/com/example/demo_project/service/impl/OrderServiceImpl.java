package com.example.demo_project.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo_project.entity.Menu;
import com.example.demo_project.service.ifs.OrderService;
@Service
public class OrderServiceImpl implements OrderService {

	
	@Override
	public Menu setMenu(String name,int price) {
		Menu menu = new Menu();
		menu.setName(name);
		menu.setPrice(price);
		System.out.println("�\�I: "+ name +" ���欰: "+price);
		return menu;
	}

	@Override
	public int order(Menu menu,int amount) {

		System.out.println("�\�I"+menu.getName()+ ","+ amount +"��,���B��: "+menu.getPrice()*amount);
		return menu.getPrice()*amount;
	}

	@Override
	public void printInfo(int total) {
		
		if (total >= 500) {
			total *= 0.9;
		}
		System.out.println("�H�W�`�B��: "+ total);
		
	}

}
