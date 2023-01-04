package com.example.demo_project.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.demo_project.entity.Menu;
import com.example.demo_project.repository.MenuDao;
import com.example.demo_project.service.ifs.OrderService;
import com.example.demo_project.vo.MenuReq;
import com.example.demo_project.vo.MenuRes;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private MenuDao menudao;
//	Map<String, Integer> menuList = new HashMap<>();
//	Menu beef = new Menu();
//	Menu apple = new Menu();
//	Menu pork = new Menu();

	// int total = 0;
	@Override
	public Menu setMenu(String name, int price) {
		Menu menu = new Menu();
		if (menudao.findById(name).isPresent()) {
			menu = menudao.findById(name).get();
			menu.setName(name);
			menu.setPrice(price);
			return menudao.save(menu);
		}
		
		menu.setName(name);
		menu.setPrice(price);
		return menudao.save(menu);
	}

	@Override
	public List<Menu> getAllMenu() {

		return menudao.findAll();
	}

	@Override
	public Menu getMenuByName(String name) {
		return menudao.findById(name).orElse(null);
	}

//	@Override
//	public int order(Menu menu, int amount) {
//
//		System.out.println("�\�I" + menu.getName() + "," + amount + "��,���B��: " + menu.getPrice() * amount);
//
//		return menu.getPrice() * amount;
//	}

//	@Override
//	public void printInfo(int total) {
//
//		if (total >= 500) {
//			total *= 0.9;
//			System.out.println("���O�W�L500��9��");
//		}
//		System.out.println("�H�W�`�B��: " + total);
//
//	}

	@Override
	public MenuRes orderMenu(List<MenuReq> orderList) {

		int total = 0;		
		MenuRes res = new MenuRes();		
		List<String> messagelist = new ArrayList<String>();
		
		for (MenuReq order : orderList) {
			if (!StringUtils.hasText(order.getName())) {
				continue;
			}
			Optional<Menu> orderOp = menudao.findById(order.getName());
			if (orderOp.isPresent()) {
				if (order.getAmount() < 0) {
					order.setAmount(0);
				}
				Menu menu = orderOp.get();
				total += menu.getPrice() * order.getAmount();
				messagelist.add(order.getName() + " " + order.getAmount() + "  "
						+ menu.getPrice() * order.getAmount());
			} else {
				order.setAmount(0);
				messagelist.add(order.getName() + " " + order.getAmount() + " ");
			}
		}

		if (total > 500) {
			messagelist.add("more than 500");
			total *= 0.9;
		}
		// res.setOrderList(orderList);
		res.setMessageList(messagelist);
		res.setTotal(total);
		res.setMessage("order success");
		
		return res;
	}

}
