package com.example.demo_project;

import java.util.Scanner;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo_project.service.impl.Calculate;

@SpringBootTest
public class test1013 {

	@Test
	public void test() {

		Calculate cal = new Calculate();
		Scanner scan = new Scanner(System.in);
		int i = 0;
		int j = 0;

		String x = null;
		String y = null;
		String s = null;
		String check = null;
		String pattern = "\\d+";
		for (int m = 4; m > 0;) {
			System.out.println("請輸入算式,數字介於2到20的整數,或輸入end結束程式");
			s = scan.next();
			if (s.equalsIgnoreCase("end")) {
				return;
			}
			x = scan.next();
			y = scan.next();
			if (!s.equalsIgnoreCase("add") && !s.equalsIgnoreCase("minus") && !s.equalsIgnoreCase("multi")
					&& !s.equalsIgnoreCase("division") && !s.equalsIgnoreCase("mod")) {
				System.out.println("算式未完成輸入");
				return;
			}
			if (x.matches(pattern) && y.matches(pattern)) {
				i = Integer.parseInt(x);
				j = Integer.parseInt(y);
			} else {
				System.out.println("輸入錯誤,請輸入整數");
				m--;
				System.out.println("剩餘 " + m + " 次輸入次數");
				System.out.println("=========================");
				continue;
			}
			if (i > 20 || i < 2) {
				System.out.println("輸入錯誤,需輸入範圍2~20的整數");
				m--;
				System.out.println("剩餘 " + m + " 次輸入次數");
				System.out.println("=========================");

				continue;
			}
			if (j > 20 || j < 2) {
				System.out.println("輸入錯誤,需輸入範圍2~20的整數");
				m--;
				System.out.println("剩餘 " + m + " 次輸入次數");
				System.out.println("=========================");

				continue;
			}
			System.out.println("您輸入的算式為: " + s + " " + i + " " + j);
			System.out.println("是否正確? Y/N");
			check = scan.next();
			if (check.equalsIgnoreCase("N")) {
				return;
			}
			if (check.equalsIgnoreCase("Y")) {
				if (s.equalsIgnoreCase("Add")) {
					System.out.println(i + "+" + j + "=" + cal.add(i, j));
					System.out.println("=========================");
				}
				if (s.equalsIgnoreCase("Minus")) {
					if(i<j) {
						System.out.println("因減數大於被減數,請重新輸入");
						continue;
					}
					System.out.println(i + "-" + j + "=" + cal.minus(i, j));
					System.out.println("=========================");
				}
				if (s.equalsIgnoreCase("Multi")) {
					System.out.println(i + "*" + j + "=" + cal.multi(i, j));
					System.out.println("=========================");
				}
				if (s.equalsIgnoreCase("Division")) {
					if(i<j) {
						System.out.println("因除數大於被除數,請重新輸入");
						continue;
					}
					System.out.println(i + "/" + j + "=" + cal.division(i, j));
					System.out.println("=========================");
				}
				if (s.equalsIgnoreCase("Mod")) {
					if(i<j) {
						System.out.println("因除數大於被除數,請重新輸入");
						continue;
					}
					System.out.println(i + "%" + j + "=" + cal.mod(i, j));
					System.out.println("=========================");
				}
			}
		}

		
	}
	
	

}
