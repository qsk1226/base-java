package com.goddess.base.algorithm;

/**
 * 链表是环？快慢指针
 *
 * @author qinshengke
 * @since 2021/3/9
 **/
public class LinkCycleOrNot {
	public boolean hasCycle(ListNode head) {
		if (head == null || head.next == null) {
			return true;
		}
		ListNode fast = head, slow = head;
		while (fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) {
				return true;
			}
		}
		return false;
	}

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
}