package com.goddess.base.algorithm.array;

import java.util.Hashtable;
import java.util.Map;

/**
 * 给定一个数组，与整数 target，求出数组中两数之和等于target 的数组下标
 *
 * @author qinshengke
 * @since 2022/4/11
 **/
public class 两个数之和等于target {

	public static int[] xx(int[] array, int target) {
		if (array == null) return new int[0];
		Map<Integer, Integer> result = new Hashtable<>();
		for (int i = 0; i < array.length; i++) {
			if (result.containsKey(target - array[i])) {
				return new int[]{i, result.get(target - array[i])};
			} else {
				result.put(array[i], i);
			}
		}
		return new int[0];
	}
}
