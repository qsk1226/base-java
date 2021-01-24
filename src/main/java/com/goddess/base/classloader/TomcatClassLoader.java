package com.goddess.base.classloader;

import sun.tools.java.ClassNotFound;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Tomcat 打破双亲委派机制的类加载器
 *
 * @author qinshengke
 * @since 2021/1/22
 **/
public class TomcatClassLoader extends ClassLoader {

	@Override
	public Class<?> loadClass(String name) throws ClassNotFoundException {
		try {
			String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
			InputStream is = getClass().getResourceAsStream(fileName);
			if (is == null) {
				return super.loadClass(name);
			}

			byte[] b = new byte[is.available()];
			is.read(b);
			return defineClass(name, b, 0, b.length);
		} catch (IOException e) {
			throw new ClassNotFoundException(name);
		}

	}

	public static void classpath() {
		System.out.println("BootstrapClassLoader 的加载路径: ");

		URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
		for (URL url : urls)
			System.out.println(url);
		System.out.println("----------------------------");

		//取得扩展类加载器
		URLClassLoader extClassLoader = (URLClassLoader) ClassLoader.getSystemClassLoader().getParent();

		System.out.println(extClassLoader);
		System.out.println("扩展类加载器 的加载路径: ");

		urls = extClassLoader.getURLs();
		for (URL url : urls)
			System.out.println(url);

		System.out.println("----------------------------");


		//取得应用(系统)类加载器
		URLClassLoader appClassLoader = (URLClassLoader) ClassLoader.getSystemClassLoader();

		System.out.println(appClassLoader);
		System.out.println("应用(系统)类加载器 的加载路径: ");

		urls = appClassLoader.getURLs();
		for (URL url : urls)
			System.out.println(url);

		System.out.println("----------------------------");


	}


	public static void main(String[] args) throws Exception {


		//HashMap hashMap = new HashMap();
		//上下文类加载器
		System.out.println("上下文类加载器" + Thread.currentThread().getContextClassLoader());


		// System.out.println("1.启动类加载器:"+HashMap.class.getClassLoader());

		// System.out.println("2.拓展类加载器:"+ZipPath.class.getClassLoader());

//        System.out.println("3.应用程序类加载器:"+TomcatClassLoad.class.getClassLoader());
//
		TomcatClassLoader tomcatClassLoad = new TomcatClassLoader(); //自定的类加载器

		Thread.currentThread().setContextClassLoader(tomcatClassLoad);
		
//        //这个obj对象就是通过我自己的写的类加载器,去加载的
		Object obj = tomcatClassLoad.loadClass("com.goddess.base.classloader.TomcatClassLoader").newInstance();
//        System.out.println("obj:"+obj.getClass().getClassLoader());
//        System.out.println("这两个类是否相等:" +(obj instanceof   TomcatClassLoad) ); //是不是相等

		classpath();

	}
}
