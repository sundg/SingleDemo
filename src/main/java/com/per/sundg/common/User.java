package com.per.sundg.common;

public class User {
	private Integer id;
	private String name;
	public User(){
		System.out.println("实例化User："+this);
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
