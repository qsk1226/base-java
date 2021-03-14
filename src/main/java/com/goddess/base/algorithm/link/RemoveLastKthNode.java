package com.goddess.base.algorithm.link;

/**
 * 溢出单链表倒数第 K 个节点
 *
 * @author qinshengke
 * @since 2021/3/14
 **/
public class RemoveLastKthNode {

	public MyNode removeLastKthNode(MyNode head, int lastKth) {
		MyNode cur = head;
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
}
