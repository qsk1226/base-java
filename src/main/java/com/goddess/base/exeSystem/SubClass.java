package com.goddess.base.exeSystem;

/**
 * 子类
 *
 * @author qinshengke
 * @since 2020/4/5 11:25
 **/
public class SubClass extends SuperClass {

	static {
		System.out.println("SubClass init");
	}

	public static void printSubClass() {
		System.out.println("SubClass静态方法被调用");
	}
}