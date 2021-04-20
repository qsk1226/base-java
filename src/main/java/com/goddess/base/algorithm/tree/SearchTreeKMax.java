package com.goddess.base.algorithm.tree;

/**
 * 二叉搜索树的第 k 大节点（倒序的中序遍历）
 * 倒序的中序遍历，就是递减的顺序，在遍历的时候就可以计算第k个节点
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
