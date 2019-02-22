package com.per.sundg.spring.day04.entity;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class Manager {
	private Computer computer;

	public Computer getComputer() {
		return computer;
	}
	
	@Resource(name="computer")
	public void setComputer(Computer computer) {
		this.computer = computer;
	}
	
}
