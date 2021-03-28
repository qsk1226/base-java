package com.goddess.base.algorithm.tree;

/**
 * 1、给定个数组 array，一直其中无重复值，判断array 是否可能是节点值类型为 整型的搜索二叉树后序遍历的结果。
 * 2、通过符合后序遍历形成的数组，重构出来二叉树
 *
 * @author qinshengke
 * @since 2021/3/28
 **/
public class SearchBinTree {
	public boolean isPostArray(int[] array) {
		if (array == null || array.length == 0) {
			return false;
		}
		return isPost(array, 0, array.length - 1);
	}

	public boolean isPost(int[] array, int start, int end) {
		if (start == end) return true;

		int less = -1;
		int more = end;
		for (int i = start; i < end; i++) {
			if (array[end] > array[i]) {
				less = i;
			} else {
				more = more == end ? i : more;
			}
		}
		if (less == -1 || more == end) {
			return isPost(array, start, end - 1);
		}
		if (less != more - 1) {
			return false;
		}

		return isPost(array, start, less) && isPost(array, more, end - 1);
	}
}
