package com.per.sundg.spring.day01.entity;

public class ExampleBean {
	public ExampleBean(){
		System.out.println("实例化ExampleBean："+this);
	}

	//作为初始化的回调方法
	public void init(){
		System.out.println("初始化ExampleBean");
	}
	public void execute(){
		System.out.println("执行execute方法");
	}

	//作为销毁的回调方法
	public void destroy(){
		System.out.println("销毁ExampleBean");
	}
}
