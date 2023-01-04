package com.example.demo_project.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo_project.entity.Product;
import com.example.demo_project.service.ifs.ShoppingService;

@Service
public class ShoppingServiceImpl implements ShoppingService {

	@Override
	public void queryProducts(List<String> nameList, List<Product> productList) {

		if (nameList.isEmpty()) {
			System.out.println("查詢品項不得為空");
			System.out.println("=================================");
			return;
		}
		for (String name : nameList) {
			System.out.println("查詢品項: " + name);
			for (Product product : productList) {
				if (name.equalsIgnoreCase(product.getName())) {
					System.out.println("品項: " + product.getName());
					System.out.println("價格: " + product.getPrice());
					System.out.println("庫存: " + product.getStorage());
					System.out.println("=================================");
					break;
				} else if (productList.indexOf(product) == productList.size() - 1) {
					System.out.println("查無" + name);
					System.out.println("=================================");
				}
			}
		}

	}

	@Override
	public void checkout(List<Product> buyList, List<Product> productList) {

		int total = 0;
		for (Product buy : buyList) {
			for (Product product : productList) {
				if (buy.getName().equalsIgnoreCase(product.getName())) {
					System.out.println("購買品項: " + product.getName());
					System.out.println("單項價格: " + product.getPrice());
					System.out.println("購買數量: " + buy.getQuantity());
					if (product.getStorage() - buy.getQuantity() < 0) {
						System.out.println("庫存不足夠買,取消購買此品項");
						break;
					}
					System.out.println("此品項總價格: " + product.getPrice() * buy.getQuantity());
					total += product.getPrice() * buy.getQuantity();
					product.setStorage(product.getStorage() - buy.getQuantity());
					System.out.println("購買後剩餘庫存: " + product.getStorage());
					System.out.println("=================================");
					break;
				} else if (productList.indexOf(product) == productList.size() - 1) {
					System.out.println("查無品項: " + buy.getName());
					System.out.println("=================================");
				}

			}
		}
		System.out.println("總金額: " + total);

	}

}
