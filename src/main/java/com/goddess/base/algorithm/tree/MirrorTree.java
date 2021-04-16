package com.goddess.base.algorithm.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 输出树的镜像
 *
 * @author qinshengke
 * @since 2021/4/16
 **/
public class MirrorTree {

	public TreeNode mirrorTree(TreeNode root) {
		return bfs(root);
	}

	public TreeNode bfs(TreeNode root) {
		if (root == null) return null;
		TreeNode newRoot = root;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if (node.right != null) {
				queue.add(node.right);
			}
			if (node.left != null) {
				queue.add(node.left);
			}

			TreeNode tmp = node.left;
			node.left = node.right;
			node.right = tmp;
		}
		return newRoot;
	}
}
