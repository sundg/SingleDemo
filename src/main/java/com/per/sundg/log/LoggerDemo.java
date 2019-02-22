package com.per.sundg.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerDemo {
	private static final Logger logger =LoggerFactory.getLogger(LoggerDemo.class);
	public static void main(String[] args) {
		String str="abc";
		try {
			int i=Integer.parseInt(str);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			logger.debug(e.getMessage());
		}
	}
}
