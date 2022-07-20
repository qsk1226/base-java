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


	public static void main(String[] args) {
		树对称 treeDemo = new 树对称();
		boolean symmetric = treeDemo.BFS(treeDemo.root);
		System.out.println(symmetric);
	}

	/**
	 * 树是否是对称的
	 */
	public boolean BFS(TreeNode root) {
		if (root == null)
			return true;

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

			if (left == null && right == null)
				continue;
			if ((left == null || right == null) || left.val != right.val)
				return false;

			queue.add(left.left);
			queue.add(right.right);

			queue.add(left.right);
			queue.add(right.left);
		}

		return true;
	}


	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		//调用递归函数，比较左节点，右节点
		return dfs(root.left, root.right);
	}

	boolean dfs(TreeNode left, TreeNode right) {
		//递归的终止条件是两个节点都为空
		//或者两个节点中有一个为空
		//或者两个节点的值不相等
		if (left == null && right == null) {
			return true;
		}
		if (left == null || right == null) {
			return false;
		}
		if (left.val != right.val) {
			return false;
		}
		//再递归的比较 左节点的左孩子 和 右节点的右孩子
		//以及比较  左节点的右孩子 和 右节点的左孩子
		return dfs(left.left, right.right) && dfs(left.right, right.left);
	}

}
