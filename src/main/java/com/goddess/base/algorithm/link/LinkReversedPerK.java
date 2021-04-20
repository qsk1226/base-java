package com.goddess.base.algorithm.link;

import java.util.Stack;

/**
 * 链表每 K 个元素反转
 *
 * @author qinshengke
 * @since 2021/3/26
 **/
public class LinkReversedPerK {

	public ListNode reverseByStack(ListNode head, int k) {
		if (k < 2) return head;
		Stack<ListNode> stack = new Stack<>();
		ListNode newHead = head;
		ListNode cur = head;
		ListNode pre = null;
		ListNode next = null;
		while (cur != null) {
			next = cur.next;
			stack.push(cur);
			if (stack.size() == k) {
				pre = reverse(stack, pre, next);
				newHead = newHead == head ? cur : newHead;
			}
			cur = next;
		}
		return newHead;
	}

	private ListNode reverse(Stack<ListNode> stack, ListNode left, ListNode right) {
		ListNode cur = stack.pop();
		if (left != null) {
			left.next = cur;
		}
		ListNode next = null;
		while (!stack.isEmpty()) {
			next = stack.pop();
			cur.next = next;
			cur = next;
		}
		cur.next = right;
		return cur;
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

		LinkReversedPerK p = new LinkReversedPerK();
		ListNode listNode = p.reverseByStack(head, 3);

		while (listNode != null) {
			System.out.print(listNode.value + "--->");
			listNode = listNode.next;
		}

	}

}
