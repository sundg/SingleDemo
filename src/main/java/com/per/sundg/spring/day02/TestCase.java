package com.per.sundg.spring.day02;


import com.per.sundg.spring.day02.entity.ExampleBean;
import com.per.sundg.spring.day02.entity.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestCase {
	//Spring容器实例化
	@Test
	public void test01(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("spring1.xml");

		/*User user=ac.getBean("user",User.class);
		System.out.println(user);
		ExampleBean ex=ac.getBean("exampleBean",ExampleBean.class);
		System.out.println(ex);*/
	}

	//Bean的作用域
	@Test
	public void test02(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("spring1.xml");
		User userOne=ac.getBean("user",User.class);
		User userTwo=ac.getBean("user",User.class);
		System.out.println(userOne==userTwo);
		ExampleBean exOne=ac.getBean("example",ExampleBean.class);
		ExampleBean exTwo=ac.getBean("example",ExampleBean.class);
		System.out.println(exOne==exTwo);
	}
	//Bean的初始化和销毁的回调方法
	@Test
	public void test03(){
		AbstractApplicationContext aac=
				new ClassPathXmlApplicationContext("spring1.xml");
		ExampleBean exOne=aac.getBean("exampleBean",ExampleBean.class);
		exOne.execute();

		//关闭容器
		aac.close();

	}
	@Test
	public void test04(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("spring1.xml");
		ExampleBean exOne=ac.getBean("example",ExampleBean.class);
	}

	@Test
	public void test05(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("spring1.xml");
		//ExampleBean exOne=ac.getBean("example",ExampleBean.class);
	}










}
