package com.example.demo_project;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EmailTest {

	@Test
	public void mapToStringTest() throws JsonProcessingException {
		Map<String,Integer> map = new HashMap<>();
//		ObjectMapper objectMapper = new ObjectMapper();
		map.put("aaa", 1);
		map.put("bbb", 2);
		System.out.println(map.toString());
		String mapStr = map.toString().substring(1, map.toString().length() - 1);
		System.out.println(mapStr);
		
//		String to Map
		String[] mapStrArray = mapStr.split(",");
		Map<String,Integer> newMap = new HashMap<>();
		for(String item:mapStrArray) {
			String[] itemAry = item.trim().split("=");
			System.out.println("Key: "+ itemAry[0]);
			System.out.println("Value: "+ Integer.valueOf(itemAry[1]));
			newMap.put(itemAry[0], Integer.valueOf(itemAry[1]));
		}
		System.out.println(newMap);
//		String mapString = objectMapper.writeValueAsString(map);
//		System.out.println(mapString);
	}
	
	@Test
	public void order() {
		Map<String,Integer> map = new HashMap<>();

		map.put("aaa", 1);
		map.put("bbb", 2);
		
		for(Entry<String, Integer> item:map.entrySet()) {
			System.out.println(item.getKey());
			
		}
	}
	@Test
	public void timeTest() {
//		a 上午或下午
		SimpleDateFormat sdff = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss a");
		System.out.println(sdff.format(new Date()));
		LocalDateTime ldt = LocalDateTime.now();
		
	}
	
	
}
