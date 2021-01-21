package com.goddess.base.dynamicProxy.cglib;

/**
 * 被代理对象
 *
 * @author qinshengke
 * @since 2020/6/3 21:36
 **/
public class HelloService {

	public void sayHello() {
		System.out.println("hello, Lily");
	}

	public void saySb() {
		System.out.println("Sb");
	}

	public void sayNinHao() {
		System.out.println("您好");
	}


}