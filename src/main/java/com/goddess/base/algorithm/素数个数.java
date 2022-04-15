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
			System.out.println("素数i: "+ i + susu(i));
		}
		System.out.println(susu1(100));
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

	/**
	 * 埃筛法
	 */
	public static int susu1(int n) {
		boolean[] isPrime = new boolean[n]; // false 代表素数
		int count =0;
		for (int i = 2; i < n; i++) {
			if (!isPrime[i]) {
				count++;
				// for (int j = 2 * i; j < n; j+=i) {
				for (int j = i * i; j<n; j+=i) {
					isPrime[j] = true;
				}
			}
		}
		return count;
	}

}
