package com.goddess.base.algorithm.link;

/**
 * 删除指定节点
 *
 * @author qinshengke
 * @since 2021/4/23
 **/
public class DeleteNode {
	public ListNode deleteNode(ListNode head, int val) {
		if (head == null) return null;
		if (head.val == val) {
			return head.next;
		}
		ListNode next = head.next;
		ListNode pre = head;

		while (next != null && next.val != val) {
			pre = next;
			next = next.next;
		}
		if (next != null) {
			pre.next = next.next;
		}
		return head;
	}
}
