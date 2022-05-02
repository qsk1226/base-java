package com.goddess.base.algorithm.array;

import com.goddess.base.algorithm.tree.TreeNode;

/**
 * 给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。
 *
 * @author qinshengke
 * @since 2022/4/21
 **/
public class ConvertMinTree {

	public static TreeNode convertMinTree(int[] nums, int left, int right) {
		if (nums == null||nums.length == 0||left>right) return null;
		int mid = (left + right) >> 1;
		TreeNode treeNode = new TreeNode(nums[mid]);
		treeNode.setLeft(convertMinTree(nums,left, mid-1));
		treeNode.setRight(convertMinTree(nums,mid+1, right));
		return treeNode;
	}

	public static void main(String[] args) {
		int[] nums = {-10,-3,0,3,9};
		convertMinTree(nums,0,nums.length-1);

	}
}
