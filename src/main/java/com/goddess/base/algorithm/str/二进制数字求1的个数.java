package com.goddess.base.algorithm.str;

/**
 * TODO
 *
 * @author qinshengke
 * @since 2021/4/24
 **/
public class 二进制数字求1的个数 {

	public int hammingWeight(int n) {
		int count = 0;
		while(n != 0) {
			count += n & 1;
			n = n>>>1;
		}
		return count;
	}
}
