package com.goddess.base.algorithm.stackOrQueue;

import java.util.Stack;

/**
 * 两个栈实现的队列
 *
 * @author qinshengke
 * @since 2021/3/14
 **/
public class TwoStackQueue {

	private Stack<Integer> stackPush;
	private Stack<Integer> stackPop;

	public TwoStackQueue() {
		this.stackPush = new Stack<>();
		this.stackPop = new Stack<>();
	}

	public void add(int value) {
		stackPush.push(value);
	}

	public int poll() {
		if (stackPush.empty() || stackPop.empty()) {
			throw new RuntimeException("空队列");
		} else if (stackPop.empty()) {
			while (!stackPush.empty())
				stackPop.push(stackPush.pop());
		}
		return stackPop.pop();
	}

}
