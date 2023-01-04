package com.example.demo_project;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.context.WebApplicationContext;

import com.example.demo_project.entity.Register;
import com.example.demo_project.repository.OrdersDao;
import com.example.demo_project.repository.RegisterDao;
import com.example.demo_project.service.ifs.RegisterService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebAppConfiguration
@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RegisterTest {

	private static final String CONTENT_TYPE = "application/json;charset=UTF-8";
	
	@Autowired 
	private OrdersDao ordersDao;
	
	@Autowired
	private WebApplicationContext wac;
	private MockMvc mockMvc;

	@Autowired
	private RegisterService registerService;
	@Autowired
	private RegisterDao registerDao;

	@Test
	public void registerTest() {
		Register reg = registerService.register("A001", "A0987654", "Tom", 19, "Tainan");
//		System.out.println(reg.getAccount());
//		System.out.println(reg.getPwd());
//		System.out.println(reg.getName());
//		System.out.println(reg.getAge());
//		System.out.println(reg.getCity());
//		System.out.println(reg.getRole());
//		System.out.println(reg.getRegTime());
//		System.out.println(reg.isActive());	
	}

	@Test
	public void accountActiveTest() {
		Register reg = registerService.register("A99", "A0987654", "Johnny", 19, "Tainan");
		Assert.isTrue(!reg.isActive(), "Account is active"); // �P�_�e�����ȬO�_��true,���O�h�^�ǫ᭱���F��
		registerService.activeAccount("A99");
		Register reg1 = registerDao.findById("A99").get();
		Assert.isTrue(reg1.isActive(), "Account is inactive");

		registerDao.delete(reg1);
	}

	@Test
	public void addRoleTest() {
		List<String> roleList = new ArrayList<>();
		roleList.add("SA");
		roleList.add("PM");
		roleList.add("SA");
		roleList.add("SD");
		registerService.addRole("A01", roleList);

	}

	@Test
	public void addRoleControllerTest() throws Exception {

		Map<String, Object> map = new LinkedHashMap<>();
		List<String> roleList = new ArrayList<>();
		roleList.add("AA");
//		roleList.add("RDB");
		map.put("account", "B001");
		map.put("roleList", roleList);

		ObjectMapper objectMapper = new ObjectMapper();
		String mapString = objectMapper.writeValueAsString(map);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		ResultActions result = mockMvc.perform(MockMvcRequestBuilders.post("/api/add_role").contentType(CONTENT_TYPE).
//				headers(headers).
				content(mapString));

		// get response && to string
		String resultStr = result.andReturn().getResponse().getContentAsString();

		// response string to Json(map)
		JacksonJsonParser jsonParser = new JacksonJsonParser();
		Map<String, Object> resData = jsonParser.parseMap(resultStr);

		// trans type
		String rtnMessage = (String) resData.get("message");
		// Object rtnInfo = resData.get("register_info");

		System.out.println("");
		Assert.isTrue(rtnMessage.equals("success"), "message fail");
		System.out.println(rtnMessage);

	}

	@BeforeAll
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}
	
	@Test
	public void updateRegisterInfoDaoTest() {
		int result = registerDao.updateRegisterInfo("kevin", 30, "USA",new Date(), "A123");
		System.out.println("-->"+result);
	}
	
	@Test
	public void queryRegTimeTest() throws ParseException {
		
//		字串日期轉換成Date
		String dateStr = "2022-11-10";
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
		
		List<Register> result = registerDao.doQueryByExpiredRegTime(date);
		for(Register item:result) {
			System.out.println(item.getAccount());
//			System.out.println(item.getName());
			
		}
	}
	
	@Test
	public void queryRegTimeWithPageSizeTest() throws ParseException {
		
//		字串日期轉換成Date
		String dateStr = "2022-11-10";
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
//		有限制筆數
		List<Register> result = registerDao.doQueryByExpiredRegTime(date,2);
		for(Register item:result) {
			System.out.println(item.getAccount());
		
		}
	}
	

	@Test
	public void queryRegTimeWithPageSizeAndStartPositionTest() throws ParseException {
		
//		字串日期轉換成Date
		String dateStr = "2022-11-10";
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
//		有限制筆數及起始位置
		List<Register> result = registerDao.doQueryByExpiredRegTime(date,2,1);
		for(Register item:result) {
			System.out.println(item.getAccount());
		
		}
	}
	
	@Test
	public void nativeQueryRegTimeWithPageSizeAndStartPositionTest() throws ParseException {
		
//		字串日期轉換成Date
		String dateStr = "2022-11-10";
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
//		有限制筆數及起始位置
		List<Register> result = registerDao.doNativeQueryByExpiredRegTime(date,2,1);
		for(Register item:result) {
			System.out.println(item.getAccount());	
		}
	}
	
	@Test
	public void updateAgeByNameTest() {
		int result = registerDao.updateAgeByName("Jack", 16);
		System.out.println(result);
	}
	
	@Test
	public void updateAgeByAccountTest() {
		int result = registerDao.updateAgeByAccount("A01", 56);
		System.out.println(result);
	}
	
	@Test
	public void nativeUpdateAgeByNameTest() {
		int result = registerDao.nativeUpdateAgeByName("Jack", 33);
		System.out.println(result);
	}
	
	@Test
	public void nativeUpdateAgeByAccountTest() {
		int result = registerDao.nativeUpdateAgeByAccount("A01", 87);
		System.out.println(result);
	}
	
	@Test
	public void roleContainsTest() {
		List<String> roleList = Arrays.asList("SD","SA");
		
		List<Register> result = registerDao.doQueryRoleContains(roleList);
		for(Register item : result) {
			System.out.println(item.getAccount());
		}
	}
	
	@Test
	public void findAllTest() {
		List<Register> result = registerService.findAll();
		System.out.println(result.size());
	}
	
	
}
