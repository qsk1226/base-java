package com.goddess.base.algorithm.str;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 1、左括号必须用相同类型的右括号闭合。
 * 2、左括号必须以正确的顺序闭合。
 *
 * @author qinshengke
 * @since 2022/5/20
 **/
public class 括号串是否有效 {
	private static final Map<Character, Character> map = new HashMap<Character, Character>() {{
		put('{', '}');
		put('[', ']');
		put('(', ')');
		put('?', '?');
	}};

	public boolean isValid(String s) {
		if (s.length() > 0 && !map.containsKey(s.charAt(0))) return false;

		LinkedList<Character> stack = new LinkedList<Character>() {{
			add('?');
		}};

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (map.containsKey(ch)) {
				if (stack.isEmpty() || stack.peek() != map.get(ch)) {
					return false;
				}
				stack.pop();
			} else {
				stack.push(ch);
			}
		}
		return stack.isEmpty();

	}
}
