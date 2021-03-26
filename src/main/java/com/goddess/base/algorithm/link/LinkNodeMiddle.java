package com.goddess.base.algorithm.link;

/**
 * 获取链表的中间节点
 *
 * @author qinshengke
 * @since 2021/3/26
 **/
public class LinkNodeMiddle {

	public int getMiddle(MyNode head) {
		int middle = 1;

		MyNode pre = head;
		MyNode cur = head;
		while (cur.next != null && cur.next.next != null) {
			pre = pre.next;
			cur = cur.next.next;
			middle ++;
		}
		System.out.println(pre.value);
		return middle;
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
		LinkNodeMiddle p = new LinkNodeMiddle();
		System.out.println(p.getMiddle(head));

	}
}
