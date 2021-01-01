package com.goddess.base.concurrent.atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;
/**
 * 原数组不会改变
 *
 * @author qinshengke
 * @since 2021/1/1
 **/
public class AtomicArray {
	static int[] value = new int[]{1, 2};
	static AtomicIntegerArray ai = new AtomicIntegerArray(value);

	public static void main(String[] args) {
		ai.getAndSet(0, 3);
		System.out.println(ai.get(0));
		System.out.println(value[0]);//原数组不会变化
	}
}
