package com.goddess.base;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;

import java.io.ObjectInputStream;

/**
 * 查看jdk中对象的信息
 *
 * @author qinshengke
 * @since 2020/4/15 22:10
 **/
public class JOL_Case {
	public static void main(String[] args) throws InterruptedException {
		Object a = new Object();
		System.out.println(ClassLayout.parseInstance(a).toPrintable());

		//查看对象内部信息
		System.out.println(ClassLayout.parseInstance(a).toPrintable());

		//查看对象外部信息
		System.out.println(GraphLayout.parseInstance(a).toPrintable());

		//获取对象总大小
		System.out.println("size : " + GraphLayout.parseInstance(a).totalSize());

		Thread.sleep(1000000);
	}
}
