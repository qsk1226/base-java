package com.goddess.base.algorithm.link;

/**
 * 获取链表的中间节点
 *
 * @author qinshengke
 * @since 2021/3/26
 **/
public class LinkNodeMiddle {

	public int getMiddle(ListNode head) {
		int middle = 1;

		ListNode pre = head;
		ListNode cur = head;
		while (cur != null && cur.next != null) {
			pre = pre.next;
			cur = cur.next.next;
			middle ++;
		}
		System.out.println(pre.val);
		return middle;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);

		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next = new ListNode(7);
		//head.next.next.next.next.next.next.next = new ListNode(8);
		//head.next.next.next.next.next.next.next.next = new ListNode(9);
		LinkNodeMiddle p = new LinkNodeMiddle();
		System.out.println(p.getMiddle(head));

	}
}
