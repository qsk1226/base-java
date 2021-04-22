package com.goddess.base.algorithm.tree;

import com.goddess.base.algorithm.link.ListNode;

/**
 * 有序链表转换为二叉搜索树
 *
 * @author qinshengke
 * @since 2021/4/19
 **/
public class SortedLinkedNodeToBST {

	public TreeNode sortedListToBST(ListNode head) {
		if (head == null) return null;
		if (head.next == null)  return new TreeNode(head.value);
		//这里通过快慢指针找到链表的中间结点slow，pre就是中间, 结点slow的前一个结点
		ListNode slow = head, fast = head, pre = null;
		while (fast != null && fast.next != null) {
			pre = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		//链表断开为两部分，一部分是node的左子节点，一部分是node的右子节点
		pre.next = null;
		TreeNode node = new TreeNode(slow.value);
		node.left = sortedListToBST(head);
		node.right = sortedListToBST(slow.next);
		return node;
	}
}
