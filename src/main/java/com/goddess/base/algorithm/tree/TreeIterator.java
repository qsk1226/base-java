package com.goddess.base.algorithm.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树的遍历
 *
 * @author qinshengke
 * @since 2021/3/3
 **/
public class TreeIterator {
	static TreeNode root;

	static {
		root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		root.setLeft(left);
		TreeNode right = new TreeNode(3);
		root.setRight(right);

		left.setLeft(new TreeNode(4));
		left.setRight(new TreeNode(5));

		right.setLeft(new TreeNode(9));
	}

	/**
	 * 前序遍历
	 */
	public static void pre(TreeNode root) {
		if (root == null) return;
		System.out.print(root.getValue() + "-->");
		pre(root.getLeft());
		pre(root.getRight());
	}

	/**
	 * 中序遍历
	 */
	public static void middle(TreeNode root) {
		if (root == null) return;
		middle(root.getLeft());
		System.out.print(root.getValue() + "-->");
		middle(root.getRight());
	}

	/**
	 * 后序遍历
	 */
	public static void after(TreeNode root) {
		if (root == null) return;
		after(root.getLeft());
		after(root.getRight());
		System.out.print(root.getValue() + "-->");
	}

	/**
	 * 广度优先搜索 BFS
	 */
	public static void bfs(TreeNode tree) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(tree);

		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			System.out.print(node.getValue() + "-->");

			// queue先进先出，所以先左后右
			if (node.getLeft() != null) {
				queue.add(node.getLeft());
			}
			if (node.getRight() != null) {
				queue.add(node.getRight());
			}
		}
	}

	/**
	 * 深度优先算法实现的先序遍历
	 */
	public static void dfs(TreeNode tree) {
		Stack<TreeNode> stack = new Stack<>();
		stack.push(tree);

		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			System.out.print(node.getValue() + "-->");

			// stack先进后出，所以先右后左
			if (node.getRight() != null) {
				stack.push(node.getRight());
			}
			if (node.getLeft() != null) {
				stack.push(node.getLeft());
			}
		}
	}

	public static void main(String[] args) {
		System.out.print("前序遍历:");
		pre(root);
		System.out.println("");

		System.out.print("中序遍历:");
		middle(root);
		System.out.println("");

		System.out.print("后续遍历:");
		after(root);
		System.out.println("");

		bfs(root);
		System.out.println("");

		dfs(root);
		System.out.println("");
	}
}
