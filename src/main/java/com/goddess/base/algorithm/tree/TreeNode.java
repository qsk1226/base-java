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
}