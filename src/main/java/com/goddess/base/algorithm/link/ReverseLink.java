package com.goddess.base.algorithm.link;

/**
 * 翻转大安乡链表
 *
 * @author qinshengke
 * @since 2021/3/14
 **/
public class ReverseLink {

	public MyNode reverseLink(MyNode head) {
		MyNode pre = null;
		MyNode next = null;

		while (head != null) {
			next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		return pre;
	}


}
