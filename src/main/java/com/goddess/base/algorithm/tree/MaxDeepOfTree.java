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


	public int bfs(TreeNode root) {
		if (root == null) return 0;

		Queue<TreeNode> queue = new LinkedList<>();
		TreeNode perLast = root;
		TreeNode curLast = root;
		queue.add(root);
		int level = 1;
		while (!queue.isEmpty()) {
			TreeNode tmp = queue.poll();

			if (tmp.left != null) {
				perLast = tmp.left;
				queue.add(tmp.left);
			}

			if (tmp.right != null) {
				perLast = tmp.right;
				queue.add(tmp.right);
			}
			if (tmp == curLast && !queue.isEmpty()) {
				level++;
				curLast = perLast;
			}

		}
		return level;
	}

}
