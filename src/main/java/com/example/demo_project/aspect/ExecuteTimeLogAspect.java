package com.example.demo_project.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ExecuteTimeLogAspect {

//	切入點 service或impl內所有程式都會被包含
//	@Pointcut("execution (* com.example.demo_project.controller.*.*(..))")
	@Pointcut("execution (* com.example.demo_project.service.impl.*.findAll(..))")
	public void pointcut() {
		
	}
	
	@Before("pointcut()")
	public void before() {
		System.out.println("===== before advice =====");
	}
	
	@After("pointcut()")
	public void after() {
		System.out.println("===== after advice =====");
	}
	
	@Around("pointcut()")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("===== around advice start =====");
		
		MethodSignature signature = (MethodSignature) pjp.getSignature();
		System.out.println("執行方法名稱: " + signature.getName());
		
		long startTime = System.currentTimeMillis();
//		呼叫 proceed() 才會開始執行原方法
		Object result = pjp.proceed();
		long timeSpent = System.currentTimeMillis() - startTime;
		System.out.println("time spent: " + timeSpent);
		System.out.println("===== around advice end =====");
		return result;	
	}
	
	@AfterReturning("pointcut()")
	public void afterReturning() {
		System.out.println("===== afterReturning advice =====");
	}
	
	@AfterThrowing(pointcut = "pointcut()", throwing = "throwable")
	public void afterThrowing(JoinPoint joinPoint, Throwable throwable) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		
		System.out.println("執行方法名稱: " + signature.getName());
		System.out.println("錯誤訊息: " + throwable.getMessage());
		System.out.println("===== afterThrowing advice =====");
	}
}
