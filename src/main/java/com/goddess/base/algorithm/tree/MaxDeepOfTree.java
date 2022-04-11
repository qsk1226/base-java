package com.goddess.base.algorithm.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 一颗树的最大深度，要记录每一层的边缘位置，然后和要层序遍历的最后一
 *
 * @author qinshengke
 * @since 2021/4/16
 **/
public class MaxDeepOfTree {

	/**
	 * 一颗树的最大深度，要记录每一层的边缘位置，然后和要层序遍历的最后一个做比较
	 */
	public int bfs(TreeNode root) {
		if (root == null) return 0;

		Queue<TreeNode> queue = new LinkedList<>();
		TreeNode perLast = root;
		TreeNode curLast = root;
		queue.add(root);
		int level = 1;
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();

			if (node.left != null) {
				perLast = node.left;
				queue.add(node.left);
			}

			if (node.right != null) {
				perLast = node.right;
				queue.add(node.right);
			}
			if (node == curLast && !queue.isEmpty()) {
				level++;
				curLast = perLast;
			}

		}
		return level;
	}

}
