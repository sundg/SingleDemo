package com.per.sundg.spring.day03;

import com.per.sundg.spring.day03.entity.Company;
import com.per.sundg.spring.day03.entity.Dept;
import com.per.sundg.spring.day03.entity.Emp;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCase {
	ApplicationContext ac=new ClassPathXmlApplicationContext("spring3.xml");
	//Setter注入
	@Test
	public void test01(){
		Emp emp=ac.getBean("emp",Emp.class);
		System.out.println(emp.getName());
	}
	
	//构造器注入
	@Test
	public void test02(){
		
		Dept dept=ac.getBean("dept",Dept.class);
		System.out.println(dept.getName());
		System.out.println(dept.getId());
		System.out.println(dept);
	}
	
	//自动装配
	@Test
	public void test03(){
		Company company=ac.getBean("company",Company.class);
		System.out.println(company.getEmp().getName());
		System.out.println("=====================");
		System.out.println(company.getDp().getName());
		System.out.println(company.getDp());
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
