package com.goddess.base.algorithm.tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 换行输出树的每一行(包含行号)
 *
 * @author qinshengke
 * @since 2021/3/27
 **/
public class 逐层输出树或者按照Z顺序输出树 {

	public void printByLevel(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		int level = 1;
		TreeNode last = root;
		TreeNode nLast = null;
		queue.offer(root);
		System.out.print("level-" + (level++) + "  ===>  ");
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			System.out.print(node.getVal());

			if (node.getLeft() != null) {
				queue.offer(node.getLeft());
				nLast = node.getLeft();
			}

			if (node.getRight() != null) {
				queue.offer(node.getRight());
				nLast = node.getRight();
			}

			if (node == last && !queue.isEmpty()) {
				System.out.print("\nleven-" + (level++) + "  ===>  ");
				last = nLast;
			}
		}
	}
	// Z 字型逐层输出树
	public void printByZigZag(TreeNode head) {
		Deque<TreeNode> dq = new LinkedList<>();
		int level = 1;
		boolean lr = true;
		TreeNode last = head;
		TreeNode nLast = null;

		dq.offerFirst(head);
		printLevel(level++, lr);
		while (!dq.isEmpty()) {
			if (lr) {
				head = dq.pollFirst();
				if (head.getLeft() != null) {
					nLast = nLast == null ? head.getLeft() : nLast;
					dq.offerLast(head.getLeft());
				}
				if (head.getRight() != null) {
					nLast = nLast == null ? head.getRight() : nLast;
					dq.offerLast(head.getRight());
				}
			} else {
				head = dq.pollLast();
				if (head.getRight() != null) {
					nLast = nLast == null ? head.getRight() : nLast;
					dq.offerFirst(head.getRight());
				}
				if (head.getLeft() != null) {
					nLast = nLast == null ? head.getLeft() : nLast;
					dq.offerFirst(head.getLeft());
				}
			}
			System.out.print(head.getVal() + "  ");
			if (head == last && !dq.isEmpty()) {
				lr = !lr;
				last = nLast;
				nLast = null;
				System.out.println();
				printLevel(level++, lr);
			}
		}
		System.out.println();
	}


	public void printLevel(int level, boolean lr) {
		System.out.print("level-" + level + " from ");
		System.out.print(lr ? "left to right: " : "right to left : ");
	}


	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		root.setLeft(left);
		TreeNode right = new TreeNode(3);
		root.setRight(right);

		left.setLeft(new TreeNode(4));
		left.setRight(new TreeNode(5));

		right.setLeft(new TreeNode(9));
		逐层输出树或者按照Z顺序输出树 printTreeByLevel = new 逐层输出树或者按照Z顺序输出树();
		printTreeByLevel.printByLevel(root);

		System.out.println("\n====================");
		printTreeByLevel.printByZigZag(root);

	}

}
