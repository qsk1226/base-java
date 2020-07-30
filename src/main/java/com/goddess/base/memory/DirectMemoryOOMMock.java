package com.goddess.base.memory;


import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * 直接内存OOM示例
 * -XX:MaxDirectMemorySize=5M -Xmx20M
 *
 * @author qinshengke
 * @since 2020/7/31 00:17
 **/
public class DirectMemoryOOMMock {

	private static final int _1MB = 1024*1024*60;
	public static void main(String[] args)  {
		try {
			Field declaredField = Unsafe.class.getDeclaredFields()[0];
			declaredField.setAccessible(true);
			Unsafe unsafe = (Unsafe)declaredField.get(null);
			while (true) {
				unsafe.allocateMemory(_1MB);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
