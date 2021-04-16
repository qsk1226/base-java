package com.goddess.base.algorithm.tree;

/**
 * 属性节点
 *
 * @author qinshengke
 * @since 2021/3/15
 **/
public class TreeNode {
	protected Integer value;
	protected TreeNode left;
	protected TreeNode right;

	public TreeNode(Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
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