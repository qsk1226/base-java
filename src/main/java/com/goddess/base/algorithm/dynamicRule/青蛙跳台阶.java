package com.goddess.base.algorithm.dynamicRule;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）
 *
 * @author qinshengke
 * @since 2021/3/10
 **/
public class 青蛙跳台阶 {
	public int jumpFloor(int number) {
		if (number <= 0) {
			return 0;
		}
		if (number == 1) {
			return 1;
		}

		if (number == 2) {
			return 2;
		}
		int first = 1, second = 2, third = 0;
		for (int i = 3; i <= number; i++) {
			third = first + second;
			first = second;
			second = third;
		}
		return third;
	}
}