package com.goddess.base.algorithm.stackOrQueue;

import com.sun.corba.se.impl.oa.toa.TOA;

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
		if (!stackPop.empty()) return stackPop.pop();
		if (stackPush.empty()) {
			return -1;
		} if (stackPop.empty()) {
			while (!stackPush.empty())
				stackPop.push(stackPush.pop());
		}
		return stackPop.pop();
	}

	public static void main(String[] args) {
		TwoStackQueue twoStackQueue = new TwoStackQueue();
		twoStackQueue.add(1);
		twoStackQueue.poll();
	}

}
