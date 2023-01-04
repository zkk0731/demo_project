package com.example.demo_project;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo_project.repository.OrdersDao;
import com.example.demo_project.vo.OrdersInfo;



@SpringBootTest
class DemoProjectApplicationTests {

	@Autowired 
	private OrdersDao ordersDao;
	
	
	
	@Test
	public void contextLoads() {
		
		List<OrdersInfo> ordersInfoList = ordersDao.findAllOrdersInfo();
		for(OrdersInfo item:ordersInfoList) {
			System.out.println(item.getCustomersId());
			System.out.println(item.getName());
			System.out.println(item.getProductName());
			System.out.println(item.getQuantity());
		}
		
	}
	
	@Test
	public void contextLoads2() {
		List<Integer> idList = new ArrayList<>();
		idList.add(2);
		idList.add(3);
		idList.add(4);
		
		List<OrdersInfo> ordersInfoList = ordersDao.findOrdersInfoByCustomersId(2);
		for(OrdersInfo item:ordersInfoList) {
			System.out.println(item.getCustomersId());
			System.out.println(item.getName());
			System.out.println(item.getProductName());
			System.out.println(item.getQuantity());
		}
		
	}

}
