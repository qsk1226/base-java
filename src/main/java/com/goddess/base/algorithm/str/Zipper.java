package com.goddess.base.algorithm.str;

/**
 * 压缩字符串
 *
 * @author qinshengke
 * @since 2021/3/10
 **/
public class Zipper {
	public String zipString(String iniString) {
		StringBuilder result = new StringBuilder();
		int tmp = 0;
		for (int i = 0; i < iniString.length(); i++) {
			if (i >= iniString.length() - 1 || iniString.charAt(i) != iniString.charAt(i + 1)) {
				result.append(iniString.charAt(i));
				result.append(i + 1 - tmp);
				tmp = i + 1;
			}
		}
		return result.length() < iniString.length() ? result.toString() : iniString;
	}

	public static void main(String[] args) {
		Zipper zipper = new Zipper();
		System.out.println(zipper.zipString("aaaabbbbccccdddd"));
	}
}