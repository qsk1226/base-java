package com.goddess.base.algorithm.link;

/**
 * 两个链表相交,取第一个相交点
 *
 * @author qinshengke
 * @since 2021/3/26
 **/
public class LinkNodeShareNode {

	public static MyNode xx(MyNode head1, MyNode head2) {

		MyNode a = head1;
		MyNode b = head2;

		while (a != b) {
			a = a.next == null ? head2 : a.next;
			b = b.next == null ? head1 : b.next;
		}
		return a;
	}

	public static void main(String[] args) {
		MyNode n6 = new MyNode(6);
		n6.next = new MyNode(7);
		n6.next.next = new MyNode(8);

		MyNode head = new MyNode(1);
		head.next = new MyNode(2);
		head.next.next = new MyNode(3);
		head.next.next.next = new MyNode(4);
		head.next.next.next.next = new MyNode(5);
		head.next.next.next.next.next = n6;

		MyNode head2 = new MyNode(11);
		head2.next = new MyNode(21);
		head2.next.next = new MyNode(31);
		head2.next.next.next = new MyNode(41);
		head2.next.next.next.next = new MyNode(51);
		head2.next.next.next.next.next = n6;

		System.out.println(xx(head, head2).value);

	}

}
