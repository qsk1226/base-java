package com.goddess.base.gc;

/**
 * 栈的实现
 *
 * @author qinshengke
 * @since 2020/8/2 00:40
 **/
public class MyStack {

	public Object[] elements;//数组来保存
	private int size = 0;
	private static final int Cap = 200000;

	public MyStack() {
		elements = new Object[Cap];
	}

	public void push(Object e) { //入栈
		elements[size] = e;
		size++;
	}

	public Object pop() {  //出栈
		size = size - 1;
		Object o = elements[size];
		// 内存可能溢出
		elements[size] = null; //不用---引用干掉，GC可以正常回收次对象
		return o;
	}
}
