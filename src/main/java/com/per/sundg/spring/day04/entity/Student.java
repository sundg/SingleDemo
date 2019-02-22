package com.per.sundg.spring.day04.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Student {
	@Autowired
	@Qualifier("computer")
	private Computer compuer;

	public Computer getCompuer() {
		return compuer;
	}

	public void setCompuer(Computer compuer) {
		this.compuer = compuer;
	}
	
}
