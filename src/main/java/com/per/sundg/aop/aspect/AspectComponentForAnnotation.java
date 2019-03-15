package com.per.sundg.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

//切面组件
@Component
@Aspect
public class AspectComponentForAnnotation {

	@Before("within(com.per.sundg.aop.controller.*)")
	public void one(){
		System.out.println("前置通知");
	}

	@AfterReturning("execution(public String findAll())")
	public void two(){
		System.out.println("后置通知");
	}

	@After("bean(testControllerForAnnotation)")
	public void three(){
		System.out.println("最终通知");
	}

	@AfterThrowing(throwing="ex",pointcut="within(com.per.sundg.aop.controller.*)")
	public void four(Exception ex){
		System.out.println("异常通知");

		StackTraceElement[] element=ex.getStackTrace();
		//记录异常信息
		System.out.println("--->"+element[0].toString());
	}

	@Around("within(com.per.sundg.aop.controller.*)")
	public void five(ProceedingJoinPoint point) throws Throwable{
		System.out.println("环绕通知的前置部分");
		//执行目标组件的方法
		point.proceed();
		System.out.println("环绕通知的后置部分");
	}
}

