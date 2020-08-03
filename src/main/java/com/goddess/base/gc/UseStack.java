package com.goddess.base.gc;


/**
 * 内存泄漏示例
 *
 * @author qinshengke
 * @since 2020/8/2 01:12
 **/
public class UseStack {
	static Stack stack = new Stack();  //new一个栈

	public static void main(String[] args) throws Exception {

		//10万的数据入栈
		for (int i = 0; i < 100000; i++) {
			stack.push(new String[1 * 1000]); //入栈
		}
		for (int i = 0; i < 100000; i++) {//10万的数据出栈
			Object o1 = stack.pop(); //出栈
		}
		Thread.sleep(Integer.MAX_VALUE);

	}


}
