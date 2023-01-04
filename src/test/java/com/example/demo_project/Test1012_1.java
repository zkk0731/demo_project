package com.example.demo_project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo_project.entity.Product;
import com.example.demo_project.service.ifs.ShoppingService;
@SpringBootTest
public class Test1012_1 {

	@Autowired
	private ShoppingService shoppingservice;
	@Test
	public void shoppingTest(){
		List<Product> productList = new ArrayList<Product>();
		Product product1 = new Product("apple",50,10);
		Product product2 = new Product("banana",20,5);
		Product product3 = new Product("orange",10,20);
		productList.add(product1);
		productList.add(product2);
		productList.add(product3);
		
		List<String> serchProduct = new ArrayList<String>();
		serchProduct.add("Apple");
		serchProduct.add("orange");
		serchProduct.add("uuu");
		shoppingservice.queryProducts(serchProduct, productList);
		
		List<Product> buyList = new ArrayList<Product>();
		Product buy1 = new Product("apple",9);
		Product buy2 = new Product("orange",2);
		Product buy3 = new Product("bnana",4);
		buyList.add(buy1);
		buyList.add(buy2);
		buyList.add(buy3);
		shoppingservice.checkout(buyList,productList);
		
		
		
	}
	
	
}
