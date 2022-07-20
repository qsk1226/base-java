package com.goddess.base.algorithm.sort;

import com.goddess.base.algorithm.array.SortTestHelper;

import java.util.Arrays;

/**
 * 插入排序的平均时间复杂度也是 O(n^2)
 * 将第一待排序序列第一个元素看做一个有序序列，把第二个元素到最后一个元素当成是未排序序列。
 * <p>
 * 从头到尾依次扫描未排序序列，将扫描到的每个元素插入有序序列的适当位置。（如果待插入的元素与有序序列中的某个元素相等，则将待插入元素插入到相等元素的后面。）
 *
 * @author qinshengke
 * @since 2021/3/3
 **/
public class InsertSort {
	public static void main(String[] args) {

		int[] arr = SortTestHelper.generateRandomArray(200, 100);
		sort(arr);
	}

	//核心代码---开始
	public static void sort(int[] arr) {
		System.out.println(Arrays.toString(arr));
		for (int i = 0; i < arr.length; i++) {
			// 寻找元素 arr[i] 合适的插入位置
			for (int j = i; j > 0; j--)
				if (arr[j] < arr[j - 1]) {
					swap(arr, j, j - 1);
				} else {
					break;
				}
		}
		System.out.println(Arrays.toString(arr));
	}

	private static void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

}
