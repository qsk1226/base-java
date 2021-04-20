package com.goddess.base.algorithm.link;

/**
 * 翻转链表
 *
 * @author qinshengke
 * @since 2021/3/14
 **/
public class ReverseLink {

	public ListNode reverseLink(ListNode head) {
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


}
