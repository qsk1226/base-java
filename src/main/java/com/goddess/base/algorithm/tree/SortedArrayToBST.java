package com.goddess.base.algorithm.tree;

/**
 * 给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。
 *
 * @author qinshengke
 * @since 2021/4/16
 **/
public class SortedArrayToBST {


	public TreeNode sortedArrayToBST(int[] nums) {
		return sortedArrayToBST(nums, 0, nums.length);
	}

	public TreeNode sortedArrayToBST(int[] nums, int start, int end) {
		if (start == end) {
			return null;
		}
		String xx = "";
		int mid = (start + end) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = sortedArrayToBST(nums, start, mid - 1);
		root.right = sortedArrayToBST(nums, mid + 1, end);
		return root;
	}
}