package com.goddess.base.thread.ThreadLocalDemo;

/**
 * ThreadLocal工具
 *
 * @author qinshengke
 * @since 2020/4/10 22:15
 **/
public class ThreadLocalContext {

	private static final ThreadLocal<Object> UNKNOWN_THREAD_LOCAL = new ThreadLocal<>();

	public static Object get() {
		return UNKNOWN_THREAD_LOCAL.get();
	}

	public static void set(Object value) {
		UNKNOWN_THREAD_LOCAL.set(value);
	}

	public static void remove() {
		UNKNOWN_THREAD_LOCAL.remove();
	}
}
