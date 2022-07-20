package com.goddess.base.algorithm.str;

/**
 * 反转字符串，双指针
 *
 * @author qinshengke
 * @since 2022/5/20
 **/
public class 反转字符串 {
	public void reverseString(char[] s) {
		int n = s.length;
		for (int left = 0, right = n - 1; left < right; ++left, --right) {
			char tmp = s[left];
			s[left] = s[right];
			s[right] = tmp;
		}
	}
}
