package com.goddess.base.algorithm.link;

/**
 * 链表插入排序
 *
 * @author qinshengke
 * @since 2021/5/8
 **/
public class 链表插入排序 {

	public static ListNode insertionSortList(ListNode head) {
		if (head == null) return null;
		// 引入假节点
		ListNode newHead = new ListNode(0);
		newHead.next = head;

		ListNode pre = head;
		ListNode cur = head.next;

		while (cur != null) {
			if (pre.val <= cur.val) {
				pre = pre.next;
			} else {
				ListNode prev = newHead;
				while (prev.next.val <= cur.val) {
					prev = prev.next;
				}
				pre.next = cur.next;
				cur.next = prev.next;
				prev.next = cur;
			}
			cur = pre.next;
		}
		return newHead.next;
	}


	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(4);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(7);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(9);
		head.next.next.next.next.next.next = new ListNode(8);
		head.next.next.next.next.next.next.next = new ListNode(6);

		ListNode listNode = insertionSortList(head);
		System.out.println(listNode);
	}

}
