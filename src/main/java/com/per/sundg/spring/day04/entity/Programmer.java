package com.per.sundg.spring.day04.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Programmer {
	private Computer computer;
	
//	@Autowired
//	public Programmer(@Qualifier("computer")Computer computer) {
//		this.computer = computer;
//	}
	
	@Autowired
	public Programmer(Computer computer) {
		this.computer = computer;
	}

	public Programmer() {
	}

	public Computer getComputer() {
		return computer;
	}
	
	
}
