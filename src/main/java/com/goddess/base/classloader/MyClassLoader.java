package com.goddess.base.classloader;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

/**
 * 自定义类加载器
 *
 * @author qinshengke
 * @date Create at 2019/12/26
 */
public class MyClassLoader extends ClassLoader {
	/**
	 * 自定义加载器的名称
	 **/
	private String classLoaderName;

	private String path;

	public MyClassLoader(String classLoaderName) {
		super();
		this.classLoaderName = classLoaderName;
	}


	public MyClassLoader(ClassLoader parent, String classLoaderName) {
		super(parent);
		this.classLoaderName = classLoaderName;
	}

	/**
	 * 查找到拥有二进制含义的名字className 这个方法需要被类加载器实现overwrite，委托机制 会被loadClass()方法所调用
	 **/
	@Override
	protected Class<?> findClass(String className) throws ClassNotFoundException {
		System.out.println("className:" + className);
		byte[] data = loadClassData(className);

		return super.defineClass(className, data, 0, data.length);
	}

	/**
	 * 获取className的二进制文件流
	 **/
	private byte[] loadClassData(String className) {
		Objects.requireNonNull(className);
		ByteArrayOutputStream bos = null;
		InputStream inputStream = null;
		byte[] data = null;
		try {
			className = className.replace(".", "/");
			className = path + className + ".class";

			bos = new ByteArrayOutputStream();
			inputStream = new FileInputStream(className);
			int ch;
			while (-1 != (ch = inputStream.read())) {
				bos.write(ch);
			}
			data = bos.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bos != null) {
					bos.close();
				}
				if (inputStream != null) {
					inputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// 关闭数据流
		return data;
	}

	/**
	 * 如果 重写这个方法之后可能破坏jvm的委派机制
	 *
	 * @param name
	 * @return
	 * @throws ClassNotFoundException
	 */
	@Override
	public Class<?> loadClass(String name) throws ClassNotFoundException {
		return super.loadClass(name);
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public static void main(String[] args) throws Exception {
		MyClassLoader myClassLoader = new MyClassLoader("MyClassLoader");
		//myClassLoader.setPath("/Users/qinshengke/workspace/self-project/jvm_lesson/out/production/classes");
		myClassLoader.setPath("/Users/qinshengke/Desctop");

		Class<?> aClass = myClassLoader.loadClass("com.goddess.base.memory.HeapOomMock");
		System.out.println("aClass" + aClass.hashCode());
		Object o = aClass.newInstance();
		System.out.println(o);

		// 查看aClass什么时候被卸载掉   -XX:+traceClassUnloading


	}


}
