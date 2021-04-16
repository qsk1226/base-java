package com.goddess.base.algorithm.str;

/**
 * 去除最外层的括号
 * (()())(()) ---> ()()()
 *
 * @author qinshengke
 * @since 2021/4/15
 **/
public class RemoveOuterParentheses {
	public String removeOuterParentheses(String S) {
		StringBuilder sb = new StringBuilder();
		int level = 0;
		for (char c : S.toCharArray()) {
			if (c == ')') --level;
			if (level >= 1) sb.append(c);
			if (c == '(') ++level;
		}
		return sb.toString();
	}
}