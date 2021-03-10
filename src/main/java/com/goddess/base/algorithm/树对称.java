package com.goddess.base.algorithm;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 树是否是对称的
 *
 * @author qinshengke
 * @since 2021/3/10
 **/
public class 树对称 {
	public boolean isSymmetric(TreeNode root) {
		return judge(root);
	}

	private boolean judge(TreeNode root) {
		if (root.left == null && root.right == null) return true;
		if (root.left != null && root.right == null) return false;
		if (root.left == null && root.right != null) return false;
		return root.left.val == root.right.val &&
				judge(root.left) &&
				judge(root.right);
	}

	class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;
	}


	public boolean BFS(TreeNode root) {
		if(root == null)
			return true;

		boolean isMirror = true;
		Queue<TreeNode> queue = new LinkedList<>();
		if(root.left == null || root.right == null){
			return root.left == root.right;
		}
		queue.add(root.left);
		queue.add(root.right);

		while(!queue.isEmpty()){
			int size = queue.size();
			while(size > 0){
				TreeNode left = queue.poll();
				TreeNode right = queue.poll();
				size -= 2;

				if((left == null || right == null) && left != right)//不能删除里面的括号，&&优先级高于||
					return false;
				if(left == null || right == null)
					continue;
				if(left.val != right.val)
					return false;

				queue.add(left.left);
				queue.add(right.right);
				queue.add(left.right);
				queue.add(right.left);
			}
		}

		return isMirror;
	}
}
