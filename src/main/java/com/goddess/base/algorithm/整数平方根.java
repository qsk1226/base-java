package com.goddess.base.algorithm;

/**
 * 给定一个非负整数 x ，计算并返回 x 的平方根，即实现int sqrt(int x)函数。
 * 正数的平方根有两个，只输出其中的正数平方根。
 * 如果平方根不是整数，输出只保留整数的部分，小数部分将被舍去。
 *
 * @author qinshengke
 * @since 2022/4/21
 **/
public class 整数平方根 {
	public static int mySqrt(int x) {
		int left = 0;
		int right = x;
		int res = 0;
		while (left <= right) {
			int mid = (left + right) / 2;
			if ((long) mid * mid <= x) {
				left = mid + 1;
				res = mid;
			} else {
				right = mid - 1;
			}
		}
		return res;
	}

	public static void main(String[] args) {

	}
}
