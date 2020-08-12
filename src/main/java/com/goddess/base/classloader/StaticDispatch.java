package com.goddess.base.classloader;

/**
 * 方法静态分派演示
 *
 * @author qinshengke
 * @since 2020/4/6 12:22
 **/
public class StaticDispatch {

	static abstract class Human {
	}

	static class Man extends Human {
	}

	static class Woman extends Human {
	}

	public void sayHello(Human human) {
		System.out.println("Hello human");
	}

	public void sayHello(Man man) {
		System.out.println("Hello man");
	}

	public void sayHello(Woman woman) {
		System.out.println("Hello woman");
	}

	public static void main(String[] args) {
		// 这里Human 被称为静态类型，Man被称为实际类型
		Human man = new Man();
		Human woman = new Woman();

		StaticDispatch staticDispatch = new StaticDispatch();
		staticDispatch.sayHello(man);
		staticDispatch.sayHello(woman);
	}
}