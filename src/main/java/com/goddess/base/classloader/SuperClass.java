package com.goddess.base.classloader;

/**
 * 超类
 *
 * @author qinshengke
 * @since 2020/4/5 11:25
 **/
public class SuperClass {
	static {
		System.out.println("SuperClass init");
	}

	public static int value = 123;
	public static final int v1 = 231;
}