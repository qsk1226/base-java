package com.goddess.base.classloader;

import java.lang.reflect.Method;

/**
 * 自定义类加载器使用
 *
 * @author qinshengke
 * @date Create at 2020/1/1
 */
public class ClassLoaderPath {


	public static void main(String[] args) throws Exception {
		System.out.println(System.getProperty("sun.boot.class.path"));
		System.out.println(System.getProperty("java.ext.dirs"));
		System.out.println(System.getProperty("java.class.path"));


		// 虽然是有两个类加载器去加载类ArrayInit，但是由于是双亲委派机制，他们都会委派給同一个父类进行加载ArrayInit类
		MyClassLoader loader1 = new MyClassLoader("loader1");
		MyClassLoader loader2 = new MyClassLoader("loader2");

		Class<?> aClass = loader1.loadClass("com.goddess.base.memory.MetaSpaceMemory");
		Class<?> aClass1 = loader2.loadClass("com.goddess.base.memory.MetaSpaceMemory");

		System.out.println(aClass == aClass1);

		Object o = aClass.newInstance();

		Object o1 = aClass1.newInstance();

		Method method = aClass.getMethod("setPerson", Object.class);

		method.invoke(o, o1);
	}
}
