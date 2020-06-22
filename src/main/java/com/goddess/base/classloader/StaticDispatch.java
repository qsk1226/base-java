package com.goddess.base.classloader;

/**
 * 方法静态分派演示
 *
 * @author qinshengke
 * @since 2020/4/6 12:22
 **/
public class StaticDispatch {

	abstract static class Human {
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

	public void sayHello(Woman man) {
		System.out.println("Hello woman");
	}

	public static void main(String[] args) {
		Human man = new Man();
		Human woman = new Woman();

		StaticDispatch staticDispatch = new StaticDispatch();
		staticDispatch.sayHello(man);
		staticDispatch.sayHello(woman);
	}
}