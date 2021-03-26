package com.goddess.base.algorithm.link;

import java.util.Stack;

/**
 * 两个链表相加 后的链表
 *
 * @author qinshengke
 * @since 2021/3/15
 **/
public class XX {

	public void ls(MyNode head1, MyNode head2) {
		Stack<Integer> stack1 = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();

		while (head1 != null) {
			stack1.push(head1.value);
			head1 = head1.next;
		}
		while (head2 != null) {
			stack2.push(head2.value);
			head2 = head2.next;
		}

		MyNode result = null;
		int ca = 0;

		while (!stack1.empty() || !stack2.empty()) {
			int n1 = stack1.empty() ? 0 : stack1.pop();
			int n2 = stack2.empty() ? 0 : stack2.pop();

			int sum = n1 + n2 + ca;
			int cu = sum % 10;
			ca = sum/10;

		}


	}
}
