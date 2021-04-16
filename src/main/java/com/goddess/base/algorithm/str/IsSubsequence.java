package com.goddess.base.algorithm.str;

/**
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 *
 * @author qinshengke
 * @since 2021/4/16
 **/
public class IsSubsequence {
	public boolean isSubsequence(String s, String t) {
		if (s.length() > t.length()) return false;

		char[] sch = s.toCharArray();
		char[] tch = t.toCharArray();

		int index = 0;
		for (int i = 0; i < sch.length; i++) {
			if (index >= tch.length) return false;
			for (int j = index; j < tch.length; j++) {
				if (sch[i] == tch[j]) {
					index = j + 1;
					break;
				}
				if (j == tch.length - 1) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean isSubsequence1(String s, String t) {
		int m = s.length();
		int n = t.length();
		int i = 0, j = 0;
		while (i < m && j < n) {
			if (s.charAt(i) == t.charAt(j)) {
				i++;
			}
			j++;
		}
		return i == m;
	}

	public static void main(String[] args) {
		IsSubsequence subsequence = new IsSubsequence();
		System.out.println(subsequence.isSubsequence("aaaaaa", "bbaaaa"));
	}
}