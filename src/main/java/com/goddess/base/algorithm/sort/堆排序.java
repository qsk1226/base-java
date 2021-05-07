package com.goddess.base.algorithm.sort;

import java.util.Arrays;

/**
 * 堆排序
 *
 * @author qinshengke
 * @since 2021/5/7
 **/
public class 堆排序 {

	public int[] sortArray(int[] nums) {

		int len = nums.length;
		int[] array = new int[len + 1];

		for (int i = 0; i < nums.length; ++i) {
			array[i + 1] = nums[i];
		}
		//下沉建堆
		for (int i = len / 2; i >= 1; --i) {
			sink(array, i, len);
		}

		int index = len;
		//排序
		while (index > 1) {
			swap(array, 1, index--);
			sink(array, 1, index);
		}
		for (int i = 1; i < len + 1; ++i) {
			nums[i - 1] = array[i];
		}
		return nums;
	}

	public void sink(int[] nums, int index, int length) {
		//下沉
		while (2 * index <= length) {
			// 获取子节点
			int j = 2 * index;
			//找出子节点中最大或最小的那个
			if (j + 1 <= length && nums[j + 1] > nums[j]) {
				j++;
			}
			// 交换操作，父节点下沉，与最大的孩子交换节点
			if (nums[j] > nums[index]) {
				swap(nums, j, index);
			} else {
				break;
			}
			// 继续下沉
			index = j;
		}
	}

	public void swap(int nums[], int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	/**
	 * 上浮建堆，我们可以用数组保存堆，并且可以通过 index/2 得到其父节点的值
	 */
	public void swim(int[] nums, int index) {
		while (index > 1 && nums[index / 2] > nums[index]) {
			swap(nums, index / 2, index);//交换
			index = index / 2;
		}
	}
}
