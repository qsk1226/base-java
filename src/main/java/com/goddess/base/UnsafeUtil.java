package com.goddess.base;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * TODO
 *
 * @author qinshengke
 * @since 2020/8/27 20:30
 **/
public class UnsafeUtil {

	public static Unsafe getUnsafe() throws IllegalAccessException {
		Field declaredField = Unsafe.class.getDeclaredFields()[0];
		declaredField.setAccessible(true);
		return (Unsafe) declaredField.get(null);
	}

	public static Unsafe getUnsafe1() throws IllegalAccessException, NoSuchFieldException {
		Field field = Unsafe.class.getDeclaredField("theUnsafe");
		field.setAccessible(true);
		return (Unsafe) field.get(null);
	}
}
