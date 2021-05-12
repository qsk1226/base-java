package com.goddess.base.algorithm.link;

/**
 * 链表是环？快慢指针
 * 如果存在环，如何判断环的长度呢？方法是，快慢指针相遇后继续移动，直到第二次相遇。两次相遇间的移动次数即为环的长度。
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
			slow = slow.next;
			fast = fast.next.next;
			if (fast == slow) {
				return true;
			}
		}
		return false;
	}
}