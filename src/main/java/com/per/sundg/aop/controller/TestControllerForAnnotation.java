package com.per.sundg.aop.controller;

import org.springframework.stereotype.Controller;

//目标组件
@Controller
public class TestControllerForAnnotation {
	//查询
	public String findAll(){
		System.out.println("查询");
//		Integer.parseInt("a");
		return "hello";
	}
}

