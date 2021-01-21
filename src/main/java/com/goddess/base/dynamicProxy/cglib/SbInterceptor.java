package com.goddess.base.dynamicProxy.cglib;

import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * sb 拦截器
 *
 * @author qinshengke
 * @since 2020/6/3 21:49
 **/
public class SbInterceptor extends AbstractAdviceInterceptor {

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
