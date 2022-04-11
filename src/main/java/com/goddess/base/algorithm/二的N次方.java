package com.goddess.base.algorithm;

/**
 * 判断一个数是 2 的N次方
 *
 * @author qinshengke
 * @since 2022/4/9
 **/
public class 二的N次方 {
	public static void main(String[] args) {
		System.out.println(low(16));
	}

	public static boolean low(int n) {
		while (n > 1) {
			if (n % 2 != 0) return false;
			n = n/2;
		}
		return true;
	}

	/**
	 * n&(n-1)==0 即可说明他是2的N次方
	 */
	public static boolean high(int n) {
		return (n & (n - 1)) == 0;
	}
}
