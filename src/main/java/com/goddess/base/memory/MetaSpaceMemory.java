package com.goddess.base.memory;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * -XX:MaxMetaspaceSize=20m
 *
 * @author qinshengke
 * @date Create at 2020/1/1
 */
public class MetaSpaceMemory {
	public static void main(String[] args) {
		for (; ; ) {
			Enhancer enhancer = new Enhancer();
			enhancer.setSuperclass(MetaSpaceMemory.class);
			enhancer.setUseCache(false);
			enhancer.setCallback((MethodInterceptor) (obj, method, args1, proxy) -> proxy.invokeSuper(obj, args1));
			System.out.println("metaspace oom");
			enhancer.create();
		}
	}

	private Object person;

	public Object getPerson() {
		return person;
	}

	public void setPerson(Object person) {
		this.person = person;
	}

}
