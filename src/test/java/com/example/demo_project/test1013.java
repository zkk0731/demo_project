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
			System.out.println("�п�J�⦡,�Ʀr����2��20�����,�ο�Jend�����{��");
			s = scan.next();
			if (s.equalsIgnoreCase("end")) {
				return;
			}
			x = scan.next();
			y = scan.next();
			if (!s.equalsIgnoreCase("add") && !s.equalsIgnoreCase("minus") && !s.equalsIgnoreCase("multi")
					&& !s.equalsIgnoreCase("division") && !s.equalsIgnoreCase("mod")) {
				System.out.println("�⦡��������J");
				return;
			}
			if (x.matches(pattern) && y.matches(pattern)) {
				i = Integer.parseInt(x);
				j = Integer.parseInt(y);
			} else {
				System.out.println("��J���~,�п�J���");
				m--;
				System.out.println("�Ѿl " + m + " ����J����");
				System.out.println("=========================");
				continue;
			}
			if (i > 20 || i < 2) {
				System.out.println("��J���~,�ݿ�J�d��2~20�����");
				m--;
				System.out.println("�Ѿl " + m + " ����J����");
				System.out.println("=========================");

				continue;
			}
			if (j > 20 || j < 2) {
				System.out.println("��J���~,�ݿ�J�d��2~20�����");
				m--;
				System.out.println("�Ѿl " + m + " ����J����");
				System.out.println("=========================");

				continue;
			}
			System.out.println("�z��J���⦡��: " + s + " " + i + " " + j);
			System.out.println("�O�_���T? Y/N");
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
						System.out.println("�]��Ƥj��Q���,�Э��s��J");
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
						System.out.println("�]���Ƥj��Q����,�Э��s��J");
						continue;
					}
					System.out.println(i + "/" + j + "=" + cal.division(i, j));
					System.out.println("=========================");
				}
				if (s.equalsIgnoreCase("Mod")) {
					if(i<j) {
						System.out.println("�]���Ƥj��Q����,�Э��s��J");
						continue;
					}
					System.out.println(i + "%" + j + "=" + cal.mod(i, j));
					System.out.println("=========================");
				}
			}
		}

		
	}
	
	

}
