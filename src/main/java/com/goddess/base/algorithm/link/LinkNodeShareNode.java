package com.goddess.base.algorithm.link;

/**
 * 两个链表相交,取第一个相交点
 *
 * @author qinshengke
 * @since 2021/3/26
 **/
public class LinkNodeShareNode {

	public MyNode xx(MyNode head1, MyNode head2) {

		MyNode a = head1;
		MyNode b = head2;

		while (a != b) {
			a = a.next ==null ? head2: a.next;
			b = b.next ==null ?head1: b.next;
		}
		return a;
	}



}
