package com.goddess.base.algorithm.stackOrQueue;


import java.time.chrono.MinguoChronology;
import java.util.Stack;

/**
 * 设计一个有getMin功能的栈
 *
 * @author qinshengke
 * @since 2021/3/14
 **/
public class GetMinByStack {
	private Stack<Integer> stackData;
	private Stack<Integer> stackMin;

	public GetMinByStack() {
		this.stackData = new Stack();
		this.stackMin = new Stack();
	}

	public void push(int newNum) {
		if (stackMin.isEmpty()) {
			stackMin.push(newNum);
		} else if (newNum <= getMin()) {
			stackMin.push(newNum);
		}
		this.stackData.push(newNum);
	}

	public int pop(){
		Integer pop = stackData.pop();
		if (pop == getMin()) {
			stackMin.pop();
		}
		return pop;
	}

	public Integer getMin() {
		if (!stackMin.isEmpty())
			return stackMin.peek();
		throw new RuntimeException("栈空");
	}

}
