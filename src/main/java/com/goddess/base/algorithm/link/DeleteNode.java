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


	public static ListNode deleteNode1(ListNode head, int val) {
		if (head == null) return null;
		if (head.val == val) return head.next;

		ListNode pre = head;
		ListNode next = head.next;
		while (next != null){
			if (next.val == val) {
				// 删除 next 节点
				pre.next = next.next;
				break;
			} else {
				pre = next;
				next = next.next;
			}
		}
		return head;
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

		System.out.println(deleteNode1(head, 4));
	}
}
