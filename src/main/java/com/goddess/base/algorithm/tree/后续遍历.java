package com.goddess.base.algorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * TODO
 *
 * @author qinshengke
 * @since 2022/5/17
 **/
public class 后续遍历 {
	/**
	 * 后续遍历
	 */
	public List<Integer> after(TreeNode root) {

		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		List<Integer> list = new ArrayList<Integer>();
		while (root!= null || !stack.isEmpty()) {

			while (root!=null) {
				stack.push(root);
				root = root.left;
			}


		}

		return list;

	}
}
