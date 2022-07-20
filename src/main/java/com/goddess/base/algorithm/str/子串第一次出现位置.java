package com.goddess.base.algorithm.str;

/**
 * TODO
 *
 * @author qinshengke
 * @since 2022/5/20
 **/
public class 子串第一次出现位置 {

	int strStr(String haystack, String needle) {
		if (needle.length() > haystack.length()) return -1;

		int n = haystack.length();
		int m = needle.length();

		for (int i = 0; i <= n-m; i++) {
			boolean flag = true;
			for (int j = 0; j < m; j++) {
				if (haystack.charAt(i + j) != needle.charAt(j)) {
					flag = false;
					break;
				}
			}
			if (flag) {
				return i;
			}
		}
		return -1;
	}
}
