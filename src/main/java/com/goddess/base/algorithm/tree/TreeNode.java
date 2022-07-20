package com.goddess.base.algorithm.tree;

import lombok.Data;

/**
 * 属性节点
 *
 * @author qinshengke
 * @since 2021/3/15
 **/
@Data
public class TreeNode {
	protected Integer val;
	protected TreeNode left;
	protected TreeNode right;

	public TreeNode(Integer value) {
		this.val = value;
	}

	public TreeNode(Integer val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

	public static TreeNode buildTree() {
		TreeNode root = new TreeNode(4);
		insert(root, -1);
		insert(root, -2);
		insert(root, -3);
		insert(root, 1);
		insert(root, 3);
		insert(root, 6);
		insert(root, 9);
		return root;
	}

	/**
	 * 构建二叉搜索树
	 */
	public static TreeNode insert(TreeNode root, int val) {
		if (root == null) {
			return new TreeNode(val);//新建树节点
		} else {
			TreeNode cur;
			if (val <= root.val) {//小的放在左侧
				cur = insert(root.left, val);//递归一直到root为空时，调用第一个IF实现新建树节点
				root.left = cur;
			} else {//大的放在右侧
				cur = insert(root.right, val);
				root.right = cur;
			}
			return root;
		}
	}
}