package com.example.demo_project;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo_project.entity.Menu;
import com.example.demo_project.service.ifs.OrderService;

@SpringBootTest
public class Test1007 {

	@Autowired
	private OrderService orderservice;
	
	@Test
	public void test1() {
		
		Menu menu1 = orderservice.setMenu("beef", 100);
		Menu menu2 = orderservice.setMenu("pork", 90);
		Menu menu3 = orderservice.setMenu("chicken", 80);
		System.out.println("=========================");
		int order1Price = orderservice.order(menu1, 5);
		int order2Price = orderservice.order(menu2, 3);
		int order3Price = orderservice.order(menu3, 6);
		System.out.println("=========================");
		orderservice.printInfo(order1Price+order2Price+order3Price);
		
		
	}
	
	
}
