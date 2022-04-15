package com.goddess.base.algorithm.dynamicRule;

import java.math.BigInteger;

/**
 * 动态规划解析：
 *  状态定义： 设 dp 为一维数组，其中 dp[i] 的值代表 斐波那契数列第 i 个数字 。
 *  转移方程： dp[i+1] = dp[i] + dp[i−1] ，即对应数列定义 f(n+1) = f(n) + f(n−1) ；
 *  初始状态： dp[0] = 0, dp[1] = 1 ，即初始化前两个数字；
 *  返回值：   dp[n] ，即斐波那契数列的第 n 个数字。
 *
 * @author qinshengke
 * @since 2021/4/25
 **/
public class 斐波那契数列 {
	// 动态规划
	public static BigInteger fib(int n) {
		BigInteger sum = BigInteger.ZERO;
		BigInteger a = BigInteger.ZERO;
		BigInteger b = BigInteger.ONE;
		for (int i = 0; i < n; i++) {
			sum = (a.add(b)).mod(BigInteger.valueOf(1000000007));
			a = b;
			b = sum;
		}
		return a;
	}

	// 大概率会抛 OOM
	public static BigInteger f(int n) {
		BigInteger[] tmp = new BigInteger[n + 1];
		tmp[0] = BigInteger.ZERO;
		tmp[1] = BigInteger.ONE;
		for (int i = 2; i <= n; i++) {
			tmp[i] = tmp[i - 1].add(tmp[i - 2]);
		}
		return tmp[n];
	}

	/**
	 * 640540120
	 * 490189494
	 */
	public static void main(String[] args) {
		System.out.println(fib(6));
	}

}
