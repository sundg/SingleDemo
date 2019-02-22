package com.per.sundg.aop.test;

import com.per.sundg.aop.controller.TestController;
import com.per.sundg.aop.controller.TestControllerForAnnotation;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCase {
	/**
	 * @Description: 以配置文件方式测试spring aop
	 * @Author sundg
	 * @Date 2019/2/12 9:48
	 * @Param []
	 * @return void
	 * @VERSION 1.0
	 **/
	@Test
	public void testOne(){
		//ClassPathXmlApplicationContext独立的XML应用程序上下文，从类路径中获取上下文定义文件，将普通路径解释为包含包路径的类路径资源名(例如，“mypackage / myresource.txt”)。
		ApplicationContext ac=new ClassPathXmlApplicationContext("com/per/sundg/aop/spring.xml");
		TestController tc=ac.getBean("testController",TestController.class);
		tc.findAll();
	}

	/**
	 * @Description: 以注解方式测试aop
	 * @Author sundg
	 * @Date 2019/2/12 9:49
	 * @Param []
	 * @return void
	 * @VERSION 1.0
	 **/
	@Test
	public void testTwo(){
		//ClassPathXmlApplicationContext独立的XML应用程序上下文，从类路径中获取上下文定义文件，将普通路径解释为包含包路径的类路径资源名(例如，“mypackage / myresource.txt”)。
		ApplicationContext acn=new ClassPathXmlApplicationContext("com/per/sundg/aop/springForAnnotation.xml");
		TestControllerForAnnotation tcn=acn.getBean("testControllerForAnnotation",TestControllerForAnnotation.class);
		tcn.findAll();
	}
}
