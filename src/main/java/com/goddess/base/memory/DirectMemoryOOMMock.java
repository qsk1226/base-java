package com.goddess.base.memory;


import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.security.PrivilegedAction;

/**
 * 直接内存OOM示例
 * -XX:MaxDirectMemorySize=5M -Xmx20M
 *
 * @author qinshengke
 * @since 2020/7/31 00:17
 **/
public class DirectMemoryOOMMock {

	private static final int _1MB = 1024 * 1024 * 60;

	public static void main(String[] args) {
		unsafe();
	}

	public static void unsafe() {
		try {
			Field declaredField = Unsafe.class.getDeclaredFields()[0];
			declaredField.setAccessible(true);
			Unsafe unsafe = (Unsafe) declaredField.get(null);
			for (int i = 0; i < 100000; i++) {
				unsafe.allocateMemory(_1MB);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void nioByteBuffer() {
		//直接分配128M的直接内存
		ByteBuffer.allocateDirect(128 * 1024 * 1024);
	}
}
