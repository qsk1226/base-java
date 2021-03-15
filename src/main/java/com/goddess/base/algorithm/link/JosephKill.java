package com.goddess.base.algorithm.link;

/**
 * 约瑟夫问题，环形链表m，每次报数 N 则将 报数 N的 位置删除
 *
 * @author qinshengke
 * @since 2021/3/14
 **/
public class JosephKill {

	public MyNode josephKill(MyNode head, int n) {
		// 寻找出last 节点
		MyNode last = head;
		while (last.next != head) {
			last = last.next;
		}
		int count = 0;
		while (head != last) {
			if (++count == n) {
				last.next = head.next;
				count = 0;
			} else {
				last = last.next;
			}
			head = last.next;
		}
		return head;
	}

}
