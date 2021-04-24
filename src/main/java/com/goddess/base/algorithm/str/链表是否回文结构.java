package com.goddess.base.algorithm.str;

import com.goddess.base.algorithm.link.ListNode;

import java.util.Stack;

/**
 * 链表是否是回文结构
 *
 * @author qinshengke
 * @since 2021/3/15
 **/
public class 链表是否回文结构 {

	public boolean judge(ListNode head) {
		Stack<ListNode> stack = new Stack<>();

		ListNode current = head;
		while (current != null) {
			stack.push(current);
			current = current.next;
		}

		while (head != null) {
			if (head.val != stack.pop().val) return false;
			head = head.next;
		}
		return true;
	}
}
