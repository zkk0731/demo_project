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
			System.out.println("�d�߫~�����o����");
			System.out.println("=================================");
			return;
		}
		for (String name : nameList) {
			System.out.println("�d�߫~��: " + name);
			for (Product product : productList) {
				if (name.equalsIgnoreCase(product.getName())) {
					System.out.println("�~��: " + product.getName());
					System.out.println("����: " + product.getPrice());
					System.out.println("�w�s: " + product.getStorage());
					System.out.println("=================================");
					break;
				} else if (productList.indexOf(product) == productList.size() - 1) {
					System.out.println("�d�L" + name);
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
					System.out.println("�ʶR�~��: " + product.getName());
					System.out.println("�涵����: " + product.getPrice());
					System.out.println("�ʶR�ƶq: " + buy.getQuantity());
					if (product.getStorage() - buy.getQuantity() < 0) {
						System.out.println("�w�s�������R,�����ʶR���~��");
						break;
					}
					System.out.println("���~���`����: " + product.getPrice() * buy.getQuantity());
					total += product.getPrice() * buy.getQuantity();
					product.setStorage(product.getStorage() - buy.getQuantity());
					System.out.println("�ʶR��Ѿl�w�s: " + product.getStorage());
					System.out.println("=================================");
					break;
				} else if (productList.indexOf(product) == productList.size() - 1) {
					System.out.println("�d�L�~��: " + buy.getName());
					System.out.println("=================================");
				}

			}
		}
		System.out.println("�`���B: " + total);

	}

}
