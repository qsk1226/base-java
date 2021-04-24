package com.goddess.base.algorithm.array;

/**
 * TODO
 *
 * @author qinshengke
 * @since 2021/4/24
 **/
public class 查找数组中数字出现超过半数的数字 {

	public int majorityElement(int[] nums) {
		int x = 0, votes = 0;
		for(int num : nums){
			if(votes == 0) x = num;
			votes += num == x ? 1 : -1;
		}
		return x;
	}
}
