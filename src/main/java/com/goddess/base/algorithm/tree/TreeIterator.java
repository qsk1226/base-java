package com.goddess.base.algorithm.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树的遍历
 *
 * @author qinshengke
 * @since 2021/3/3
 **/
public class TreeIterator {
	static TreeNode root = new TreeNode(4);

	static {
		insert(root, -1);
		insert(root, -2);
		insert(root, -3);
		insert(root, 1);
		insert(root, 3);
		insert(root, 6);
		insert(root, 9);
	}

	/**
	 * 构建二叉搜索树
	 */
	public static TreeNode insert(TreeNode root, int val) {
		if (root == null) {
			return new TreeNode(val);//新建树节点
		} else {
			TreeNode cur;
			if (val <= root.val) {//小的放在左侧
				cur = insert(root.left, val);//递归一直到root为空时，调用第一个IF实现新建树节点
				root.left = cur;
			} else {//大的放在右侧
				cur = insert(root.right, val);
				root.right = cur;
			}
			return root;
		}
	}

	/**
	 * 前序遍历
	 */
	public static void pre(TreeNode root) {
		if (root == null) return;
		System.out.print(root.getVal() + "-->");
		pre(root.getLeft());
		pre(root.getRight());
	}

	/**
	 * 中序遍历
	 */
	public static void middle(TreeNode root) {
		if (root == null) return;
		middle(root.getLeft());
		System.out.print(root.getVal() + "-->");
		middle(root.getRight());
	}

	/**
	 * 后序遍历
	 */
	public static void after(TreeNode root) {
		if (root == null) return;
		after(root.getLeft());
		after(root.getRight());
		System.out.print(root.getVal() + "-->");
	}

	/**
	 * 广度优先搜索 BFS
	 */
	public static void bfs(TreeNode tree) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(tree);

		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			System.out.print(node.getVal() + "-->");

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
	public static void dfsPre(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);

		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			System.out.print(node.getVal() + "-->");

			// stack先进后出，所以先右后左
			if (node.getRight() != null) {
				stack.push(node.getRight());
			}
			if (node.getLeft() != null) {
				stack.push(node.getLeft());
			}
		}
	}

	/**
	 * 深度优先算法实现的中序遍历
	 */
	public static void dfsMiddle(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = root;
		while (cur != null || !stack.empty()) {
			while (cur != null) {
				stack.push(cur);
				cur = cur.left;
			}
			cur = stack.pop();
			System.out.print(cur.val + "-->");
			cur = cur.right;
		}
	}

	public static void dfsAfter(TreeNode root) {
		LinkedList<TreeNode> stack = new LinkedList<>();
		TreeNode currentRoot = root;
		TreeNode rightRoot = null;
		while (currentRoot != null || !stack.isEmpty()) {
			while (currentRoot != null) {
				stack.push(currentRoot);
				currentRoot = currentRoot.left;
			}
			currentRoot = stack.pop();
			//当前节点没有右节点或上一个结点（已经输出的结点）是当前结点的右结点，则输出当前结点
			while (currentRoot.right == null || currentRoot.right == rightRoot) {
				System.out.print(currentRoot.val + "-->");
				rightRoot = currentRoot;
				if (stack.isEmpty()) {
					return;
				}
				currentRoot = stack.pop();
			}
			stack.push(currentRoot);//还有未遍历的右侧节点
			currentRoot = currentRoot.right;
		}
	}

	public static List<Integer> postorderTraversal(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		List<Integer> list = new LinkedList<>();
		TreeNode lastVisited = null;
		while (!stack.isEmpty() || root != null) {
			if (root != null) {
				stack.push(root);
				root = root.left;
			} else {
				TreeNode node = stack.peek();
				if (node.right != null && lastVisited != node.right) {
					root = node.right;
				} else {
					list.add(node.val);
					System.out.print(node.val + "-->");
					lastVisited = stack.pop();
				}
			}
		}

		return list;
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

		System.out.println("广度优先算法层序遍历");
		bfs(root);
		System.out.println("");

		System.out.println("深度优先算法前序遍历");
		dfsPre(root);
		System.out.println("");

		System.out.println("深度优先算法中序遍历");
		dfsMiddle(root);
		System.out.println("");

		System.out.println("深度优先算法后续遍历");
		dfsAfter(root);
		System.out.println("");


		System.out.println("深度优先算法后续遍历");
		postorderTraversal(root);
		System.out.println("");
	}
}
