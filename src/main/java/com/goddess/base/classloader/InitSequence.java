package com.goddess.base.classloader;

/**
 * -XX:+TraceClassLoading, 用于追踪类的加载信息并打印出来
 *
 * @author qinshengke
 * @since 2020/8/5 17:28
 **/
public class InitSequence {
	static class Parent {
		public static int A = 1;

		static {
			A = 2;
		}
	}

	static class Sub extends Parent {
		public static int B = A;
	}

	public static void main(String[] args) {
		System.out.println(Sub.B);
		System.out.println();
	}
}
