package com.goddess.base.algorithm.link;

/**
 * 链表插入排序
 *
 * @author qinshengke
 * @since 2021/5/8
 **/
public class 链表插入排序 {

	public ListNode insertionSortList(ListNode head) {
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
}
