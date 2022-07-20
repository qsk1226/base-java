package com.goddess.base.algorithm;

/**
 * 素数
 *
 * @author qinshengke
 * @since 2022/4/14
 **/
public class 素数个数 {
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			System.out.println("素数i: " + i + susu(i));
		}
	}

	/**
	 * 暴力算法
	 */
	public static boolean susu(int n) {
		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}


}
