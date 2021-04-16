package com.goddess.base.algorithm.tree;

import java.util.Arrays;

/**
 * 给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。
 *
 * @author qinshengke
 * @since 2021/4/16
 **/
class SortedArrayToBST {
	public TreeNode sortedArrayToBST(int[] nums) {
		return sortedArrayToBST(nums, 0, nums.length);
	}

	public TreeNode sortedArrayToBST1(int[] nums) {
		if (nums.length == 0)
			return null;

		int mid = nums.length / 2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, mid));
		root.right = sortedArrayToBST(Arrays.copyOfRange(nums, mid + 1, nums.length));
		return root;
	}

	public TreeNode sortedArrayToBST(int[] nums, int start, int end) {
		if (start == end) {
			return null;
		}
		int mid = (start + end) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = sortedArrayToBST(nums, start, mid);
		root.right = sortedArrayToBST(nums, mid + 1, end);
		return root;
	}
}