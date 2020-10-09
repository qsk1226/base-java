package com.goddess.base.concurrent;

/**
 * final内存语义解读
 *
 * @author qinshengke
 * @since 2020/10/7 01:20
 **/
public class FinalMemory {
	int i;                      // 普通变量
	final int j;                // final变量
	static FinalMemory obj;

	public FinalMemory() {    // 构造函数
		i = 1;                 // 写普通域
		j = 2;                 // 写final域
	}

	public static void writer() {// 写线程A执行
		obj = new FinalMemory();
	}

	public static void reader() {   // 读线程B执行
		FinalMemory object = obj;  // 读对象引用
		int a = object.i;           // 读普通域
		int b = object.j;           // 读final域
	}


	public static void main(String[] args) {

	}
}
