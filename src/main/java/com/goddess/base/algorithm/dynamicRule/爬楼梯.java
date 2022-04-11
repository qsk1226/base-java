package com.goddess.base.algorithm.dynamicRule;

/**
 * 动态规划： 爬楼梯。需要 n 阶你才能到达楼顶。 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 注意：给定 n 是一个正整数。
 *
 * @author qinshengke
 * @since 2021/4/16
 **/
public class 爬楼梯 {
	public int climbStairs(int n) {
		return f(n);
	}

	// 自底向上动态规划,有多少种方法爬到楼顶，  1，2,3,5，8
	public int f(int n) {
		if (n == 1) return 1;

		int[] dp = new int[n];
		dp[0] = 1;
		dp[1] = 2;
		for (int i = 2; i < n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n - 1];
	}

	/**
	 * 花费
	 */
	public int minCostClimbingStairs(int[] cost) {
		int length = cost.length;
		int[] dp = new int[cost.length];
		// 题目中指定 length >= 2，直接赋值也不会产生越界问题
		dp[0] = cost[0];
		dp[1] = cost[1];
		for (int i = 2; i < length; i++) {
			dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
		}
		return Math.min(dp[length - 1], dp[length - 2]);
	}
}