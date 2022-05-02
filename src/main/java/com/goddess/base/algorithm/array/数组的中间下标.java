package com.goddess.base.algorithm.array;

import java.util.Arrays;

/**
 * 给定数组，求出数组左边和等于右边和的临界数下标
 *
 * @author qinshengke
 * @since 2022/4/14
 **/
public class 数组的中间下标 {
	public static void main(String[] args) {
		int[] x = new int[]{1,7,3,6,5,6};
		System.out.println(mid(x));
	}

	public static int mid(int[] nums) {
		int sum = Arrays.stream(nums).sum();
		int total = 0;
		for (int i = 0; i < nums.length; i++) {
			total += nums[i];
			if (total == sum) {
				return i;
			}
			sum = sum - nums[i];
		}
		return -1;
	}


}
