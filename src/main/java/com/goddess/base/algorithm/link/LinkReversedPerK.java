package com.goddess.base.algorithm.link;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

/**
 * 链表每 K 个元素反转
 *
 * @author qinshengke
 * @since 2021/3/26
 **/
public class LinkReversedPerK {

	public static ListNode reversePerK(ListNode head, int k) {
		ListNode newHead = new ListNode(0);
		newHead.next = head;

		ListNode pre = newHead;
		ListNode end = newHead;

		while(end.next != null) {
			for(int i = 1; i <= k && end != null; i++) end = end.next;
			if (end == null) break;

			ListNode start = pre.next;
			ListNode next = end.next;
			end.next = null;

			pre.next = reverse(start);
			start.next = next;

			pre = start;
			end = start;
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

		ListNode listNode1 = reversePerK(head, 3);
		while (listNode1 != null) {
			System.out.print(listNode1.val + "--->");
			listNode1 = listNode1.next;
		}
	}

	//递归方式实现单链表的反转
	public static ListNode reverseByDG(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode newHead = reverse(head.next);
		head.next.next = head;
		head.next = null;
		return newHead;
	}


	public static ListNode reverse(ListNode head) {
		ListNode pre = null;
		ListNode curr = head;
		while (curr != null) {
			ListNode next = curr.next;
			curr.next = pre;

			pre = curr;
			curr = next;
		}
		return pre;
	}

}
