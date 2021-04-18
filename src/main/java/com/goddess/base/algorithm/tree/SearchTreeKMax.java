package com.goddess.base.algorithm.tree;

/**
 * TODO
 *
 * @author qinshengke
 * @since 2021/4/18
 **/
public class SearchTreeKMax {

	int res, k;

	public int kthLargest(TreeNode root, int k) {
		this.k = k;
		dfs(root);
		return res;
	}

	void dfs(TreeNode root) {
		if (root == null) return;
		dfs(root.right);

		if (k == 0) return;

		if (--k == 0) {
			res = root.value;
		}
		dfs(root.left);
	}
}
