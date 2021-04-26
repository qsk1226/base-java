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
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode tmp = new ListNode(0);
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
		return tmp.next;
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

	}

}
