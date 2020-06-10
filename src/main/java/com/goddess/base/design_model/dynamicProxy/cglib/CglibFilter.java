package com.goddess.base.design_model.dynamicProxy.cglib;

import net.sf.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;

/**
 * 方法拦截器
 *
 * @author qinshengke
 * @since 2020/6/3 21:27
 **/
public class CglibFilter implements CallbackFilter {

	@Override
	public int accept(Method method) {
		if (method.getName().equalsIgnoreCase("sayHello")) {
			return 0;
		} else if (method.getName().equalsIgnoreCase("saySb")) {
			return 1;
		}
		// 其它的方法都是用sayHello的代理对象
		return 0;
	}
}
