package com.goddess.base.dynamicProxy.cglib;

import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 代理对象的增强回调接口实现
 * MethodInterceptor可以作为类的回调增强，也能只增强当个方法
 *
 * @author qinshengke
 * @since 2020/4/28 23:15
 **/
public class HelloInterceptor extends AbstractAdviceInterceptor {

	@Override
	void preExecute(MethodProxy proxy, Object object, Method method, Object[] args) {
		System.out.println("----------> class: " + proxy.getSuperName() + "  methodName " + method.getName() + " pre operation:");
	}

	@Override
	void afterExecute(MethodProxy proxy, Object object, Method method, Object[] args) {
		System.out.println("----------> class: " + proxy.getSuperName() + "  methodName " + method.getName() + " after operation:");
		System.out.println("");
	}

}

