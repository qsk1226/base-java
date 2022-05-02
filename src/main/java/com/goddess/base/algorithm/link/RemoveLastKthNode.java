package com.goddess.base.algorithm.link;

/**
 * 删除单链表倒数第 K 个节点
 *
 * @author qinshengke
 * @since 2021/3/14
 **/
public class RemoveLastKthNode {

	public ListNode removeLastKthNode(ListNode head, int lastKth) {
		ListNode cur = head;
		while (cur != null) {
			lastKth--;
			cur = cur.next;
		}
		if (lastKth == 0) {
			head = head.next;
		}
		if (lastKth < 0) {
			cur = head;
			while (++lastKth != 0) {
				cur = cur.next;
			}
			cur.next = cur.next.next;
		}
		return head;
	}

	public ListNode removeLastKthNode1(ListNode head, int k) {
		if (k <= 0) return null;
		ListNode slow = head;
		ListNode fast = head;
		while (k != 0 && fast != null) {
			fast = fast.next;
			k--;
		}

		ListNode pre = head;
		while(fast != null) {
			pre = slow;
			fast = fast.next;
			slow = slow.next;
		}

		pre.next = slow.next;
		return head;
	}

	public static void main(String[] args) {
		ListNode listNode = new ListNode(1);
		listNode.next = new ListNode(2);
		listNode.next.next = new ListNode(3);
		listNode.next.next.next = new ListNode(4);
		listNode.next.next.next.next = new ListNode(5);
		RemoveLastKthNode removeLastKthNode = new RemoveLastKthNode();
		ListNode listNode1 = removeLastKthNode.removeLastKthNode1(listNode, 4);
		System.out.println(listNode1);
	}
}
