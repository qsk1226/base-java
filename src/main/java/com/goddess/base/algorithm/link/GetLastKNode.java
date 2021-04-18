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
	public MyNode removeLastKthNode1(MyNode head, int lastKth) {
		MyNode p = head;
		MyNode q = head;

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

}
