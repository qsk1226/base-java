package com.goddess.base.algorithm.link;

import java.util.List;
import java.util.Stack;

/**
 * 链表每 K 个元素反转
 *
 * @author qinshengke
 * @since 2021/3/26
 **/
public class LinkReversedPerK {
	/**
	 * 链表每 K 个元素进行反转
	 */
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
		ListNode listNode = p.reverseKNodes(head, 3);

		while (listNode != null) {
			System.out.print(listNode.val + "--->");
			listNode = listNode.next;
		}

	}


	//每k个节点为一组的逆转
	public ListNode reverseKNodes(ListNode head, int k) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode cur = head;
		for (int i = 1; cur != null && i < k; i++) {
			cur = cur.next;
		}
		//判断是否能组成一组。
		if (cur == null) {
			return head;
		}
		//temp指向剩余的链表
		ListNode temp = cur.next;
		cur.next = null;
		//把k个节点进行反转
		ListNode newHead = reverse(head);
		//把之后的部分链表进行每K个节点逆转转
		ListNode newTemp = reverseKNodes(temp, k);
		//把两部分节点连接起来
		return newHead;
	}

	//单链表逆序
	public ListNode reverse(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode newHead = reverse(head.next);
		head.next.next =  head;
		head.next = null;
		return newHead;
	}


}
