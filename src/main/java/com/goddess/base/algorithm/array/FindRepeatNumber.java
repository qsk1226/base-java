package com.goddess.base.algorithm.array;

import java.util.HashSet;
import java.util.Set;

/**
 * 查找数组中任意一个重复的数字
 *
 * @author qinshengke
 * @since 2021/4/19
 **/
public class FindRepeatNumber {

	public int findRepeatNumber(int[] nums) {
		Set<Integer> dic = new HashSet<>();
		for (int num : nums) {
			if (dic.contains(num)) return num;
			dic.add(num);
		}
		return -1;
	}

}
