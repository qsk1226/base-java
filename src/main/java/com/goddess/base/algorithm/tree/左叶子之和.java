package com.goddess.base.algorithm.tree;

/**
 * dfs
 *
 * @author qinshengke
 * @since 2022/5/17
 **/
public class 左叶子之和 {
	public int sumOfLeftLeaves(TreeNode root) {
		if (root == null) return 0;
		return dfs(root);
	}

	public int dfs(TreeNode node) {
		int ans = 0;
		if (node.left != null) {
			ans += isLeafNode(node.left) ? node.left.val : dfs(node.left);
		}
		if (node.right != null && !isLeafNode(node.right)) {
			ans += dfs(node.right);
		}
		return ans;
	}

	/**
	 * 判断是否是叶子节点
	 */
	public boolean isLeafNode(TreeNode node) {
		return node.left == null && node.right == null;
	}

}
