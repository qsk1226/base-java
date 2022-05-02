package com.goddess.base.algorithm.tree;

import com.goddess.base.algorithm.link.ListNode;

import java.util.Stack;

/**
 * 求二叉搜索树任意节点的值之差 最小值
 * 二叉搜索树：二叉搜索树中序遍历得到的值序列是递增有序的
 *
 * @author qinshengke
 * @since 2021/4/13
 **/
public class MinDiffInBST extends TreeNodeDemo {

	public static void main(String[] args) {
		System.out.println(mid(root));
	}

	public static int mid(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur =root;
		int res = Integer.MAX_VALUE; int pre = 0;
		while(cur != null || !stack.isEmpty()){
			while(cur != null){
				stack.push(cur);
				cur = cur.left;
			}

			cur = stack.pop();
			if (pre == 0) {
				pre = cur.val;
			} else {
				res = Math.min(cur.val - pre, res);
				pre = cur.val;
			}
			cur = cur.right;
		}
		return res;
	}

	int pre;
	int ans;

	public int minDiffInBST(TreeNode root) {
		ans = Integer.MAX_VALUE;
		pre = -1;
		midSearch(root);
		return ans;
	}

	/**
	 * 中序遍历
	 */
	public void midSearch(TreeNode root) {
		if (root == null) {
			return;
		}
		midSearch(root.getLeft());
		if (pre == -1) {
			pre = root.getVal();
		} else {
			ans = Math.min(ans, root.getVal() - pre);
			pre = root.getVal();
		}
		midSearch(root.getRight());
	}
}