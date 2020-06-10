package com.goddess.base.design_model.dynamicProxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 增强的回调方法
 *
 * @author qinshengke
 * @since 2020/6/3 22:03
 **/
public abstract class AbstractAdviceInterceptor implements MethodInterceptor {
	abstract void preExecute(MethodProxy proxy, Object object, Method method, Object[] args);

	abstract void afterExecute(MethodProxy proxy, Object object, Method method, Object[] args);

	public Object execute(MethodProxy proxy, Object object, Method method, Object[] args) {

		preExecute(proxy, object, method, args);
		Object result = null;
		try {
			result = proxy.invokeSuper(object, args);
		} catch (Throwable throwable) {
			throwable.printStackTrace();
		}
		afterExecute(proxy, object, method, args);
		return result;
	}

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		return execute(proxy, obj, method, args);
	}
}
