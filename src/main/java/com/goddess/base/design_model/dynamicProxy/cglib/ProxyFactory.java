package com.goddess.base.design_model.dynamicProxy.cglib;

import net.sf.cglib.proxy.CallbackFilter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * 产生代理对象
 *
 * @author qinshengke
 * @since 2020/6/3 21:24
 **/
public class ProxyFactory {
	/**
	 * 产生代理对象
	 *
	 * @param targetClass       目标类
	 * @param callbackFilter    回调增强方法的过滤器
	 * @param methodInterceptor 回调增强方法
	 * @return 代理对象
	 */
	public static Object createProxy(Class<?> targetClass, CallbackFilter callbackFilter, MethodInterceptor... methodInterceptor) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(targetClass);
		enhancer.setUseCache(false);
		// 拦截器
		//enhancer.setCallbackFilter(callbackFilter);
		enhancer.setCallbacks(methodInterceptor);
		return enhancer.create();

	}

	public static void main(String[] args) {
		/* 代理方法一个类中的方法*/

		/*HelloService proxy1 = (HelloService) ProxyFactory.createProxy(HelloService.class, new CglibFilter(), new HelloInterceptor(), new SbInterceptor());
		proxy1.sayHello();
		proxy1.saySb();
		proxy1.sayNinHao();*/


		/*代理整个类*/
		HelloService proxy2 = (HelloService) ProxyFactory.createProxy(HelloService.class, null, new HelloInterceptor());
		proxy2.sayHello();
		proxy2.saySb();
		proxy2.sayNinHao();

	}
}
