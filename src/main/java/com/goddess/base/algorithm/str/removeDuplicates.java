package com.goddess.base.algorithm.str;

import java.util.Stack;
/**
 * 移除相邻重复的字符串
 *
 * @author qinshengke
 * @since 2021/4/15
 **/
public class removeDuplicates {
    public String removeDuplicates(String s) {
        if (s == null || s.length() == 0) return null;
        Stack<Character> stack = new Stack();
        
        for(int i = 0; i < s.length(); i++) {
            if (stack.isEmpty() || stack.peek() != s.charAt(i)) {
                stack.push(s.charAt(i));
            } else {
                stack.pop();
            }
        }

        StringBuilder sb = new StringBuilder();
        for(Character c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }
}