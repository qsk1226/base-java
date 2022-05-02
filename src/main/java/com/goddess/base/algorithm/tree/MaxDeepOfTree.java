package com.goddess.base.algorithm.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 一颗树的最大深度，要记录每一层的边缘位置，然后和要层序遍历的最后一个做比较
 *
 * @author qinshengke
 * @since 2021/4/16
 **/
public class MaxDeepOfTree extends TreeNodeDemo {

	public static void main(String[] args) {
		System.out.println(maxDeep(root));
		System.out.println(maxDeep1(root));
	}

	// 广度优先算法，通过队列实现
	public static int maxDeep(TreeNode root) {
		if (root == null) return 0;

		Queue<TreeNode> queue = new LinkedList<>();

		TreeNode preLast = root;
		TreeNode curLast = root;

		queue.add(root);
		int level = 1;

		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if (node.left != null) {
				preLast = node.left;
				queue.add(node.left);
			}
			if (node.right != null) {
				preLast = node.right;
				queue.add(node.right);
			}

			if(node == curLast && !queue.isEmpty()) {
				level++;
				curLast = preLast;
			}
		}
		return level;
	}

	public static int maxDeep1(TreeNode root) {
		if (root == null) return 0;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int count = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size > 0) {
				TreeNode node = queue.poll();
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
				size--;
			}
			count++;
		}
		return count;
	}
}
