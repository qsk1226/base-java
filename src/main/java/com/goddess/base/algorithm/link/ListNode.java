package com.goddess.base.algorithm.link;

/**
 * 链表节点
 *
 * @author qinshengke
 * @since 2021/3/15
 **/
public class ListNode {
	public int val;
	public ListNode next;

	public ListNode(int val) {
		this.val = val;
	}

    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		ListNode tmp = this;
		while (tmp != null) {
			sb.append(tmp.val);
			tmp = tmp.next;
		}

		return sb.toString();
	}

}