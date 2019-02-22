package com.per.sundg.spring.day03.entity;

public class Company {
	private Emp emp;
	private Dept dp;
	
	public Company(){}
	public Company(Emp emp,Dept dept){
		this.emp=emp;
		this.dp=dept;
	}
	public Dept getDp() {
		return dp;
	}

	public void setDp(Dept dp) {
		this.dp = dp;
	}

	public Emp getEmp() {
		return emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}
	
}
