package com.goddess.base.algorithm.tree;

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



}
