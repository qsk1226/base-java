package com.goddess.base.algorithm.link;

import java.util.Stack;

/**
 * 翻转链表
 *
 * @author qinshengke
 * @since 2021/3/14
 **/
public class ReverseLink {

	/**
	 * 反转链表
	 */
	public static ListNode reverseLink(ListNode head) {
		ListNode pre = null;
		ListNode next = null;

		while (head != null) {
			next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		return pre;
	}

	public static String reverseLeftWords(String s, int n) {
		String moved = s.substring(0,n);
		String xx = s.substring(n, s.length());
		return xx+moved;
	}


	public static ListNode reverseLink1(ListNode head) {
		Stack<ListNode> stack = new Stack<>();
		while(head != null) {
			stack.add(new ListNode(head.val));
			head= head.next;
		}
		ListNode result = new ListNode(0);
		ListNode tmp = result;
		while(!stack.empty()) {
			tmp.next = stack.pop();
			tmp =tmp.next;
		}
		return result.next;
	}

	public static void main(String[] args) {
		reverseLeftWords("abcdefg",2);

		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next = new ListNode(7);
		head.next.next.next.next.next.next.next = new ListNode(8);

		System.out.println(reverseLink1(head));
	}

}
