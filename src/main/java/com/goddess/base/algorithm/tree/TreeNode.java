package com.goddess.base.algorithm.tree;

/**
 * 属性节点
 *
 * @author qinshengke
 * @since 2021/3/15
 **/
public class TreeNode {
	protected Integer val;
	protected TreeNode left;
	protected TreeNode right;

	public TreeNode(Integer value) {
		this.val = value;
	}

	public Integer getVal() {
		return val;
	}

	public void setVal(Integer val) {
		this.val = val;
	}

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}
}