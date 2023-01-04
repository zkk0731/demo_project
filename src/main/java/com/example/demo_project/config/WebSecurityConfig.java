package com.example.demo_project.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo_project.service.impl.UserDetailsServiceImpl;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	
	@Override
	public void configure (HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/resources/**").permitAll() //resources資料夾靜態資料可匿名存取
		//.antMatchers("/Hello.html").hasRole("user") //定義匹配到"/Hello"底下的需要有user的這個腳色才能進去
		.anyRequest().authenticated() //其他尚未配置到的url都需要身分驗證
		.and().formLogin() 
//		配置為基本http認證
		.and().httpBasic();
	}
	
//	與上面2則1
//	@Override
//	public void configure (WebSecurity web) throws Exception {
//		web.ignoring().antMatchers("/Hello.html");
//		
//	}
	
	@Override
	public void configure (AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}
	
//	in memory
//	@Override
//	public void configure (AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("bcd")
//		.roles("admin").password(passwordEncoder().encode("123"));
//	}
//	
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
}
