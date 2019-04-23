package com.per.sundg.spring.day04;

import com.per.sundg.spring.day04.entity.Manager;
import com.per.sundg.spring.day04.entity.Programmer;
import com.per.sundg.spring.day04.entity.Student;
import com.per.sundg.spring.day04.entity.Teacher;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCase {

	ApplicationContext ac=new ClassPathXmlApplicationContext("spring4.xml");

	//@Autowired/@Qualifier方式以构造器方式注入
	@Test
	public void test01(){
		Programmer prog=ac.getBean("programmer",Programmer.class);
		System.out.println(prog);
		System.out.println(prog.getComputer());
		System.out.println(prog.getComputer().getName());
	}
	//@Autowired/@Qualifier方式以Setter方式注入
	@Test
	public void test02(){
		Teacher teacher=ac.getBean("teacher",Teacher.class);
		System.out.println(teacher);
		System.out.println(teacher.getComputer());
		System.out.println(teacher.getComputer().getPrice());
	}

	//@Autowired/@Qualifier方式作用在属性上
	@Test
	public void test03(){
		Student stu=ac.getBean("student",Student.class);
		System.out.println(stu);
		System.out.println(stu.getCompuer());
		System.out.println(stu.getCompuer().getName());
	}


	//@Resource方式以setter方式注入
	@Test
	public void test04(){
		Manager manager=ac.getBean("manager",Manager.class);
		System.out.println(manager);
		System.out.println(manager.getComputer());
		System.out.println(manager.getComputer().getName());
	}























}
