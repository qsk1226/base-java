package com.goddess.base.algorithm.array;

import cn.hutool.core.util.RandomUtil;

import java.util.Random;

/**
 * TODO
 *
 * @author qinshengke
 * @since 2022/5/14
 **/
public class SortTestHelper {

	public static int[] generateRandomArray(int n, int max) {
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = RandomUtil.randomInt(max);
		}
		return arr;
	}
}
