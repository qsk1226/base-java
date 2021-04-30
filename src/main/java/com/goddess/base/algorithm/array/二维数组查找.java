package com.goddess.base.algorithm.array;

/**
 * .
 *
 * @author qinshengke
 * @since 2021/4/30
 **/
public class 二维数组查找 {


	/**
	 *
	 * [
	 *   [1,   4,  7, 11, 15],
	 *   [2,   5,  8, 12, 19],
	 *   [3,   6,  9, 16, 22],
	 *   [10, 13, 14, 17, 24],
	 *   [18, 21, 23, 26, 30]
	 * ]
	 *
	 * 如此数组想左旋转45°，可以看成一个搜索二叉树
	 *
	 * “根节点” 对应的是矩阵的 “左下角” 和 “右上角” 元素，本文称之为 标志数 ，以 matrix 中的 左下角元素 为标志数 flag ，则有:
	 *
	 * 若 flag > target ，则 target 一定在 flag 所在 行的上方 ，即 flag 所在行可被消去。
	 * 若 flag < target ，则 target 一定在 flag 所在 列的右方 ，即 flag 所在列可被消去。
	 *
	 *
	 * 从矩阵 matrix 左下角元素（索引设为 (i, j) ）开始遍历，并与目标值对比：
	 * 当 matrix[i][j] > target 时，执行 i-- ，即消去第 i 行元素；
	 * 当 matrix[i][j] < target 时，执行 j++ ，即消去第 j 列元素；
	 * 当 matrix[i][j] = target 时，返回 truetrue ，代表找到目标值。
	 *
	 */
	public boolean findNumberIn2DArray(int[][] matrix, int target) {
		int i = matrix.length - 1, j = 0;
		while(i >= 0 && j < matrix[0].length)
		{
			if(matrix[i][j] > target) i--;
			else if(matrix[i][j] < target) j++;
			else return true;
		}
		return false;
	}

	/**
	 * 对每一行数据采用折半查找
	 */
	public boolean findNumberIn2DArray1(int[][] matrix, int target) {
		int line = matrix.length;
		for(int i = 0;i<line;i++) {
			int[] arr = matrix[i];
			// 二分查找
			if (search(arr, target)) {
				return true;
			}
		}
		return false;
	}

	public boolean search(int[] arr, int tar) {
		int low = 0;
		int high = arr.length - 1;
		while(low <= high) {
			int mid = (low+high) /2;
			if (tar < arr[mid]) {
				high = mid-1;
			} else if (tar > arr[mid]) {
				low = mid+1;
			} else {
				return true;
			}
		}
		return false;
	}
}
