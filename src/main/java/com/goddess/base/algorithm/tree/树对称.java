package com.goddess.base.algorithm.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 树是否是对称的
 *
 * @author qinshengke
 * @since 2021/3/10
 **/
public class 树对称 {
	TreeNode root = new TreeNode(1);

	{
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.right.right = new TreeNode(3);
	}

	/**
	 * 树是否是对称的
	 */
	public boolean BFS(TreeNode root) {
		if (root == null)
			return true;

		boolean isMirror = true;
		Queue<TreeNode> queue = new LinkedList<>();
		if (root.left == null || root.right == null) {
			return root.left == root.right;
		}
		queue.add(root.left);
		queue.add(root.right);

		while (!queue.isEmpty()) {

			TreeNode left = queue.poll();
			TreeNode right = queue.poll();
			//不能删除里面的括号，&&优先级高于||
			if ((left == null || right == null) && left != right)
				return false;
			if (left == null || right == null)
				continue;
			if (left.val != right.val)
				return false;

			queue.add(left.left);
			queue.add(right.right);
			queue.add(left.right);
			queue.add(right.left);
		}

		return isMirror;
	}

	public static void main(String[] args) {
		树对称 treeDemo = new 树对称();
		boolean symmetric = treeDemo.BFS(treeDemo.root);
		System.out.println(symmetric);
	}

}
