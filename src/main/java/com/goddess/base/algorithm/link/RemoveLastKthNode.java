package com.goddess.base.algorithm.link;

/**
 * 删除单链表倒数第 K 个节点
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


	public static void main(String[] args) {
		MyNode myNode = new MyNode(1);
		myNode.next = new MyNode(2);
		myNode.next.next = new MyNode(3);
		myNode.next.next.next = new MyNode(4);
		myNode.next.next.next.next = new MyNode(5);
		RemoveLastKthNode removeLastKthNode = new RemoveLastKthNode();
		MyNode myNode1 = removeLastKthNode.removeLastKthNode(myNode, 4);
		System.out.println(myNode1.value);
	}
}
