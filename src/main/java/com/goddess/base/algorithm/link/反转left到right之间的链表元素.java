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
	public static ListNode reverseBetween(ListNode head, int left, int right) {
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
		while(cur!= null && count++ <= right && cur.next != null) {

			ListNode tmp = cur.next;
			cur.next = cur.next.next;

			tmp.next = pre.next;
			pre.next = tmp;
		}
		return newHead.next;

	}

	public static ListNode reverse(ListNode head) {
		ListNode newHead = new ListNode(0);
		newHead.next = head;

		ListNode pre = newHead;
		ListNode cur = head;

		while(cur != null && cur.next != null) {
			ListNode next = cur.next;
			cur.next = cur.next.next;

			next.next = pre.next;
			pre.next = next;
		}
		return newHead.next;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next = new ListNode(7);
		head.next.next.next.next.next.next.next = new ListNode(8);

		ListNode listNode = reverseBetween(head,2,3);
		System.out.println(listNode);
	}
}
