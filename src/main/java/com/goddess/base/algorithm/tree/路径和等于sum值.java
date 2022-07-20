package com.goddess.base.algorithm.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 使用两个Queue，存储
 *
 * @author qinshengke
 * @since 2022/5/17
 **/
public class 路径和等于sum值 {
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		Queue<TreeNode> queNode = new LinkedList<TreeNode>();
		Queue<Integer> queVal = new LinkedList<Integer>();
		queNode.offer(root);
		queVal.offer(root.val);
		while (!queNode.isEmpty()) {
			TreeNode now = queNode.poll();
			int temp = queVal.poll();
			if (now.left == null && now.right == null) {
				if (temp == sum) {
					return true;
				}
				continue;
			}
			if (now.left != null) {
				queNode.offer(now.left);
				queVal.offer(now.left.val + temp);
			}
			if (now.right != null) {
				queNode.offer(now.right);
				queVal.offer(now.right.val + temp);
			}
		}
		return false;
	}

}
