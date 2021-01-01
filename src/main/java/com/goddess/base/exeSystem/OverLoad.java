package com.goddess.base.exeSystem;

import java.io.Serializable;

/**
 * 重载方法更适合版本判断
 *
 * @author qinshengke
 * @since 2020/4/6 12:53
 **/
public class OverLoad {
	
	public static void sayHello(Object args) {
		System.out.println("hello object");
	}

	public static void sayHello(int args) {
		System.out.println("hello int");
	}

	public static void sayHello(long args) {
		System.out.println("hello long");
	}

	public static void sayHello(Character args) {
		System.out.println("hello Character");
	}

	public static void sayHello(char args) {
		System.out.println("hello char");
	}

	public static void sayHello(char... args) {
		System.out.println("hello char...");
	}

	public static void sayHello(Serializable args) {
		System.out.println("hello Serializable");
	}

	public static void main(String[] args) {
		sayHello('1');
	}

}
 
// hello char--> hello int --> hello long -->  hello Character --> hello Serializable --> hello object
