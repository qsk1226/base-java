package com.goddess.base.algorithm.tree;

/**
 * 二叉树两个节点最近的公共祖先
 *
 * @author qinshengke
 * @since 2021/4/24
 **/
public class 二叉树两个节点最近的公共祖先 {

	/**
	 * 后续遍历是 左右根，自底向上的遍历方式
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) return null;
		if (root == p || root == q) return root;

		TreeNode findLeft = lowestCommonAncestor(root.left, p, q);
		TreeNode findRight = lowestCommonAncestor(root.right, p, q);

		if (findLeft != null && findRight != null)
			return root;
		else if (findLeft == null)
			return findRight;
		else
			return findLeft;
	}



}
