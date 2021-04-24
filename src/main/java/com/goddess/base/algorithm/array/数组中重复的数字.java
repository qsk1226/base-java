package com.goddess.base.algorithm.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 输出数组中重复的数字
 *
 * @author qinshengke
 * @since 2021/4/23
 **/
public class 数组中重复的数字 {

	public static int duplicate(int[] a) {
		if(a == null) return -1;
		Map<Integer,Integer> map = new HashMap<>();
		for (int tmp : a) {
			if (map.get(tmp) == null) {
				map.put(tmp,1);
			} else {
				return tmp;
			}
			
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] a = new int[]{1,3,5,6,3,5,7};
		System.out.println(duplicate(a));
	}
}
