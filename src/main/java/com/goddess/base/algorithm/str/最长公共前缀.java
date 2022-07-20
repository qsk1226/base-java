package com.goddess.base.algorithm.str;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * @author qinshengke
 * @since 2022/5/20
 **/
public class 最长公共前缀 {
	public static String maxPrefix(String[] strs) {
		if (strs == null || strs.length == 0) return "";
		int firstLen = strs[0].length();
		int count = strs.length;
		for(int i = 0; i <firstLen;i++) {
			char c = strs[0].charAt(i);
			for (int j = 1; j < count; j++) {
				char perFirst = strs[j].charAt(i);
				if (perFirst != c || i == strs[j].length()) {
					return strs[0].substring(0,i);
				}
			}
		}
		return strs[0];

	}
}
