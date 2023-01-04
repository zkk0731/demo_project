package com.example.demo_project;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.jupiter.api.Test;

public class IOTest {

	@Test
	public void fileOutputStremTest() throws IOException {
//		FileOutputStream fos = new FileOutputStream("C:\\Users\\USER\\Desktop\\javaclass\\test001.txt");
//		try {	
//			fos.write(75);
//			System.out.println("success");
//		} catch (IOException e) {
//			
//			e.printStackTrace();
//		}finally {
//			fos.close();
//		}
//		
		
//		try with resource
		try(FileOutputStream fos = new FileOutputStream("C:\\Users\\USER\\Desktop\\javaclass\\test001.txt",true)) {	
			String str = "987";
			fos.write(str.getBytes());
			System.out.println("success");
		} catch (IOException e) {	
			e.printStackTrace();
		}
	}
	
	@Test
	public void fileInputStremTest() throws FileNotFoundException {
		
		try (FileInputStream fis = new FileInputStream("C:\\Users\\USER\\Desktop\\javaclass\\test001.txt")){
			int a = fis.read();
			System.out.println(a);
		} catch (Exception e) {
			
		}
	}

	@Test
	public void fileInputStremTest1() {
		try (FileInputStream fis = new FileInputStream("C:\\Users\\USER\\Desktop\\javaclass\\test.jpg");
				FileOutputStream fos = new FileOutputStream("C:\\Users\\USER\\Desktop\\javaclass\\test2.jpg")){
			 System.out.println("size: " + fis.available());
			 byte[] a = fis.readAllBytes();
			 fos.write(a);
			System.out.println(a);
		} catch (Exception e) {
			
		}
	}
	
	@Test
	public void bufferFileOutputStremTest() {
		try(FileOutputStream fos = new FileOutputStream("C:\\Users\\USER\\Desktop\\javaclass\\test002.txt");
				BufferedOutputStream buf = new BufferedOutputStream(fos)) {	
			String str = "喔喔喔喔";
			buf.write(str.getBytes());
			buf.flush();
			System.out.println("success");
		} catch (IOException e) {	
			e.printStackTrace();
		}
	}
	
}
