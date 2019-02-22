package com.per.sundg.aop.controller;
//目标组件
public class TestController {
	//查询
	public String findAll(){
		System.out.println("查询");
		//Integer.parseInt("a");
		return "hello";
	}
}

