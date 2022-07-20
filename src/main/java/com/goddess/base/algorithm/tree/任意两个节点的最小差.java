package com.goddess.base.algorithm.tree;

import java.util.Stack;

/**
 * 求二叉搜索树任意节点的值之差最小值
 * 二叉搜索树：二叉搜索树中序遍历得到的值序列是递增有序的
 *
 * @author qinshengke
 * @since 2021/4/13
 **/
public class 任意两个节点的最小差 extends TreeNodeDemo {

	public static void main(String[] args) {
		System.out.println(mid(root));
	}

	public static int mid(TreeNode root) {
		int min = Integer.MAX_VALUE;
		Stack<TreeNode> stack = new Stack<>();
		TreeNode pre = null;
		while (root != null || !stack.isEmpty()){
			while (root != null){
				stack.push(root);
				root = root.left;
			}
			TreeNode pop = stack.pop();
			if (pre != null) min = Math.min(min,Math.abs(pop.val - pre.val));
			root = pop.right;
			pre = pop;
		}
		return min;
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