package com.goddess.base.algorithm.str;

/**
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 *
 * @author qinshengke
 * @since 2022/5/20
 **/
public class 二进制和 {
	public String addBinary(String a, String b) {
		StringBuilder ans = new StringBuilder();
		int ca = 0;

		int aLen = a.length() - 1;
		int bLen = b.length() - 1;

		for (int i = aLen, j = bLen - 1; i >= 0 || j >= 0; i--, j--) {
			int sum = ca;
			sum += i >= 0 ? a.charAt(i) - '0' : 0;
			sum += j >= 0 ? b.charAt(j) - '0' : 0;
			ans.append(sum % 2);
			ca = sum / 2;
		}
		ans.append(ca == 1 ? ca : "");
		return ans.reverse().toString();
	}

	public static void main(String[] args) {
		System.out.println('1' - '0');
	}
}
