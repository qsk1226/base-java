package com.goddess.base.algorithm.link;

import java.util.Stack;

/**
 * 判断链表是否是字符串
 *
 * @author qinshengke
 * @since 2021/3/15
 **/
public class 链表回文判断 {

	public boolean judge(MyNode head) {
		Stack<MyNode> stack = new Stack<>();

		MyNode current = head;
		while (current != null) {
			stack.push(current);
			head = current.next;
		}

		while (head != null) {
			if (head.value != stack.pop().value) return false;
			head = head.next;
		}
		return true;
	}
}
