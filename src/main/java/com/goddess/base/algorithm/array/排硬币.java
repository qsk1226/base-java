package com.goddess.base.algorithm.array;

/**
 * 总共n枚硬币，将他们摆成一个阶梯形状，第 K 行就必须正好有 K 枚硬币，给定一个数字，计算可以形成完整阶梯的总行数
 *
 * @author qinshengke
 * @since 2022/4/15
 **/
public class 排硬币 {

	public static void main(String[] args) {
		System.out.println(xx(5));
	}
	public static int xx(int n) {
		for (int i = 1; i <= n; i++) {
			n = n - i;
			if (n <= i) {
				return i;
			}
		}
		return 0;
	}
}
