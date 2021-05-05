package com.goddess.base.algorithm.link;

/**
 * 反转 left 到 right 之间的链表元素
 *
 * @author qinshengke
 * @since 2021/4/26
 **/
public class 反转left到right之间的链表元素 {

	/**
	 * 反转 left 到 right 之间的链表元素
	 */
	public ListNode reverseBetween(ListNode head, int left, int right) {
		ListNode newHead = new ListNode(0);
		newHead.next = head;

		ListNode pre = newHead;
		ListNode cur = newHead.next;

		int count = 1;
		while(cur != null && count++ < left) {
			pre = pre.next;
			cur = cur.next;
		}

		// 头插法，头就是 cur
		while(cur!= null && count++ <= right) {

			ListNode tmp = cur.next;
			cur.next = cur.next.next;

			tmp.next = pre.next;
			pre.next = tmp;
		}
		return newHead.next;

	}
}
