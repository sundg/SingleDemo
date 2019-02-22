package com.per.sundg.operator;
/**
 * 结论：先进行'&&'运算，在进行'||'运算
 * @author sundg
 *
 */
public class AndOrDemo {
	public static void main(String[] args) {

		String  test = "123";

		int a=1;
		int b=3;
		int c=5;
		boolean d=true;
		System.out.println(a>b||c>b&&d);//==>F||T&&T==>T
		System.err.println(b>a||a>c&&d);//==>T||F&&T==>T
		System.out.println(a>b||c>b&&false);//==>F||T&&F==>F
		System.out.println(b>a||c>b&&false);//==>T||T&&F==>T
		
	}
}
