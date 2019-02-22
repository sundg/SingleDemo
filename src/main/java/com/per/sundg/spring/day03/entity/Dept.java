package com.per.sundg.spring.day03.entity;

public class Dept {
	private Integer id;
	private String name;
	
	
	public Dept(){}
	public Dept(Integer id,String name){
		this.id=id;
		this.name=name;
	}
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	
}
