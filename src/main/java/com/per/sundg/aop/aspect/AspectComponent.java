package com.per.sundg.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

//切面组件
public class AspectComponent {

	public void one(){
		System.out.println("前置通知");
	}
	public void two(){
		System.out.println("后置通知");
	}
	public void three(){
		System.out.println("最终通知");
	}
	public void four(Exception ex){
		System.out.println("异常通知");

		StackTraceElement[] element=ex.getStackTrace();
		//记录异常信息
		System.out.println("--->"+element[0].toString());
	}
	public void five(ProceedingJoinPoint point) throws Throwable{
		System.out.println("环绕通知的前置部分");
		//执行目标组件的方法
		point.proceed();
		System.out.println("环绕通知的后置部分");
	}
}