package com.goddess.base.design_model.dynamicProxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态
 *
 * @author qinshengke
 * @since 2020/4/6 15:46
 **/
public class DynamicProxyTest {

	interface IHello {
		void sayHello();
	}

	static class Hello implements IHello {
		@Override
		public void sayHello() {
			System.out.println("Hello world");
		}
	}

	static class DynamicProxy implements InvocationHandler {
		Object originalObj;

		Object bind(Object originalObj) {
			this.originalObj = originalObj;
			return Proxy.newProxyInstance(originalObj.getClass().getClassLoader(), originalObj.getClass().getInterfaces(), this);
		}

		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			System.out.println("welcom ");
			return method.invoke(originalObj, args);
		}

	}


	public static void main(String[] args) {
		IHello iHello = (IHello) new DynamicProxy().bind(new Hello());
		iHello.sayHello();
	}
}
