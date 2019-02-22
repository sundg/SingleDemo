package com.per.sundg.spring.day04.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Teacher {
	private Computer computer;

	public Computer getComputer() {
		return computer;
	}
	@Autowired
	public void setComputer(@Qualifier("computer")Computer computer) {
		this.computer = computer;
	}
	
}
