package com.goddess.base.algorithm.link;

/**
 * 获取单链表倒数第 K 个元素
 *
 * @author qinshengke
 * @since 2021/4/18
 **/
public class GetLastKNode {

	/**
	 * 双指针方案
	 */
	public ListNode removeLastKthNode1(ListNode head, int lastKth) {
		ListNode p = head;
		ListNode q = head;

		while (lastKth != 0) {
			p = p.next;
			lastKth--;
		}
		while (p != null) {
			p = p.next;
			q = q.next;
		}
		return q;
	}

	public ListNode getKthFromEnd(ListNode head, int k) {
		if (head == null) return null;
		ListNode cur = head;
		ListNode result = head;
		while(k!=0 && cur != null) {
			cur = cur.next;
			k--;
		}
		if (cur ==null) return head;
		while(cur != null) {
			cur = cur.next;
			result = result.next;
		}
		return result;
	}

	public ListNode getKthFromEnd1(ListNode head, int k) {
		ListNode cur = head;
		while (cur!=null) {
			k--;
			cur = cur.next;
		}
		if (k == 0) cur = head;

		if (k < 0) {
			cur = head;
			while(k++ != 0) {
				cur = cur.next;
			}
		}
		return cur;
	}


}
