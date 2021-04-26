package com.goddess.base.algorithm.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 判断一颗树是否为平衡二叉树
 *
 * @author qinshengke
 * @since 2021/3/28
 **/
public class BalanceTree {

	public boolean isBalance(TreeNode head) {
		boolean[] res = new boolean[1];
		res[0] = true;
		getHeight(head, 1, res);
		return res[0];
	}

	public int getHeight(TreeNode head, int level, boolean[] res) {
		if (head == null) {
			return level;
		}

		int lh = getHeight(head.getLeft(), level + 1, res);
		if (!res[0]) {
			return level;
		}

		int rh = getHeight(head.getRight(), level + 1, res);
		if (!res[0]) {
			return level;
		}
		if (Math.abs(lh - rh) > 1) {
			res[0] = false;
		}
		return Math.max(lh, rh);
	}
	/**
	 * 判断一个数是否是平衡树
	 */
	boolean result = true;
	public int dfs(TreeNode root, int level) {
		if (root == null) return  level;

		int ld = dfs(root.left, level+1);
		if (!result) return level;
		System.out.println(root);
		int rd = dfs(root.right, level+1);
		if (!result) return level;

		if (Math.abs(rd - ld) > 1) {
			result = false;
		}

		return Math.max(ld,rd);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(3);
		root.right = new TreeNode(5);
		root.left.left=new TreeNode(1);
		root.left.right = new TreeNode(2);
		root.left.left.left = new TreeNode(0);

		BalanceTree balanceTree = new BalanceTree();
		System.out.println(balanceTree.dfs(root,1));
		System.out.println(balanceTree.result);

	}
}
