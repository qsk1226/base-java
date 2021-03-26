package com.goddess.base.algorithm.link;

import java.util.Stack;

/**
 * 链表每 K 个元素反转
 *
 * @author qinshengke
 * @since 2021/3/26
 **/
public class LinkReversedPerK {

	public MyNode reverseByStack(MyNode head, int k) {
		if (k < 2) return head;
		Stack<MyNode> stack = new Stack<>();
		MyNode newHead = head;
		MyNode cur = head;
		MyNode pre = null;
		MyNode next = null;
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

	private MyNode reverse(Stack<MyNode> stack, MyNode left, MyNode right) {
		MyNode cur = stack.pop();
		if (left != null) {
			left.next = cur;
		}
		MyNode next = null;
		while (!stack.isEmpty()) {
			next = stack.pop();
			cur.next = next;
			cur = next;
		}
		cur.next = right;
		return cur;
	}

	public static void main(String[] args) {
		MyNode head = new MyNode(1);
		head.next = new MyNode(2);
		head.next.next = new MyNode(3);
		head.next.next.next = new MyNode(4);
		head.next.next.next.next = new MyNode(5);
		head.next.next.next.next.next = new MyNode(6);
		head.next.next.next.next.next.next = new MyNode(7);
		head.next.next.next.next.next.next.next = new MyNode(8);

		LinkReversedPerK p = new LinkReversedPerK();
		MyNode myNode = p.reverseByStack(head, 3);

		while (myNode != null) {
			System.out.print(myNode.value + "--->");
			myNode = myNode.next;
		}

	}

}
