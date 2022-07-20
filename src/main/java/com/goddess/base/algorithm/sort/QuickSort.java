package com.goddess.base.algorithm.sort;

import java.util.Arrays;

/**
 * 快速排序
 *
 * @author qinshengke
 * @since 2021/3/3
 **/
public class QuickSort {

	public static void main(String[] args) {
		int[] arr = new int[]{0, 11, 1, 33, 2, 9, 13, 44, 5};
		int[] xx = quick(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(xx));
	}

	public static int[] quickSort(int[] array, int low, int high) {

		if (low < high) {
			int index = low + 1;
			int jizhun = array[low];
			for (int i = index; i <= high; i++) {
				if (array[i] < jizhun) {
					swap(array, i, index);
					index++;
				}
			}

			swap(array, low, index - 1);

			quickSort(array, low, index - 1);
			quickSort(array, index, high);
		}
		return array;
	}

	public static int[] quick(int[] nums, int low, int high) {
		if (low > high) return nums;
		int i = low, j = high;

		while (i < j) {
			while (i < j && nums[j] >= nums[low]) j--;
			while (i < j && nums[i] <= nums[low]) i++;
			swap(nums, i, j);
		}
		swap(nums, i, low);
		quick(nums, low, i - 1);
		quick(nums, i + 1, high);
		return nums;
	}
	private static void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

}