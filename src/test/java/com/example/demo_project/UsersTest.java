package com.example.demo_project;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo_project.entity.Users;
import com.example.demo_project.repository.UsersDao;

@SpringBootTest
public class UsersTest {

	@Autowired private UsersDao usersDao;
	
	@Test
	public void addUser() {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		Users user1 = new Users("AA", passwordEncoder.encode("a123"), "admin", true);
		Users user2 = new Users("BB", passwordEncoder.encode("b123"), "user", true);
		Users user3 = new Users("CC", passwordEncoder.encode("c123"), "user", true);
		Users user4 = new Users("DD", passwordEncoder.encode("d123"), "user", false);
		
		List<Users> userList = Arrays.asList(user1,user2,user3,user4);
		usersDao.saveAll(userList);
	}
}
