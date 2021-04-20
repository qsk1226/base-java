package com.goddess.base.algorithm.link;

/**
 * 两个链表相交,取第一个相交点
 * 1、设长链表A长度为LA，短链表长度LB；
 * 2、由于速度相同，则在长链表A走完LA长度时，短链表B已经反过头在A上走了LA-LB的长度，剩余要走的长度为LA-(LA-LB) = LB；
 * 3、之后长链表A要反过头在B上走，剩余要走的长度也是LB；
 * 4、也就是说目前两个链表“对齐”了。因此，接下来遇到的第一个相同节点便是两个链表的交点
 *
 * @author qinshengke
 * @since 2021/3/26
 **/
public class LinkNodeShareNode {

	public static ListNode xx(ListNode head1, ListNode head2) {

		ListNode a = head1;
		ListNode b = head2;

		while (a != b) {
			a = a.next == null ? head2 : a.next;
			b = b.next == null ? head1 : b.next;
		}
		return a;
	}

	public static void main(String[] args) {
		ListNode n6 = new ListNode(6);
		n6.next = new ListNode(7);
		n6.next.next = new ListNode(8);

		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = n6;

		ListNode head2 = new ListNode(11);
		head2.next = new ListNode(21);
		head2.next.next = new ListNode(31);
		head2.next.next.next = new ListNode(41);
		head2.next.next.next.next = new ListNode(51);
		head2.next.next.next.next.next = n6;

		System.out.println(xx(head, head2).value);

	}

}
