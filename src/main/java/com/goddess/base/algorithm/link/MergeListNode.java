package com.goddess.base.algorithm.link;

/**
 * 合并两个有序链表
 *
 * @author qinshengke
 * @since 2021/4/23
 **/
public class MergeListNode {
	/**
	 * 合并两个有序链表
	 */
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode newHead = new ListNode(0);

		ListNode tmp =newHead;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				tmp.next = l1;
				l1 = l1.next;
			} else {
				tmp.next = l2;
				l2 = l2.next;
			}
			tmp = tmp.next;
		}
		tmp.next = l1 == null ? l2: l1;
		return newHead.next;
	}

	public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
		if(l1 == null || l2 == null){
			return l1 != null ? l1 : l2;
		}
		if(l1.val <= l2.val){
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		}else{
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
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


		ListNode head1 = new ListNode(11);
		head1.next = new ListNode(21);
		head1.next.next = new ListNode(31);
		head1.next.next.next = new ListNode(41);
		head1.next.next.next.next = new ListNode(51);
		head1.next.next.next.next.next = new ListNode(61);
		head1.next.next.next.next.next.next = new ListNode(71);
		head1.next.next.next.next.next.next.next = new ListNode(81);

		ListNode listNode = mergeTwoLists(head, head1);
		System.out.println(listNode);
	}

}
