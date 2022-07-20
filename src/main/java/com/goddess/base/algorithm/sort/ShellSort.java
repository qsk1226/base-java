package com.goddess.base.algorithm.sort;

import com.goddess.base.algorithm.array.SortTestHelper;

import java.util.Arrays;

/**
 * 希尔排序时间复杂度是 O(n^(1.3-2))，空间复杂度为常数阶 O(1)
 *
 * @author qinshengke
 * @since 2021/3/3
 **/
public class ShellSort {

	public static void main(String[] args) {
		int[] ints = SortTestHelper.generateRandomArray(20, 30);
		shellSort(ints);
	}

	public static void shellSort(int[] arr) {
		int length = arr.length;
		int temp;
		for (int step = length / 2; step >= 1; step /= 2) {

			for (int i = step; i < length; i++) {
				temp = arr[i];
				int j = i - step;
				while (j >= 0 && arr[j] > temp) {
					arr[j + step] = arr[j];
					j -= step;
				}
				arr[j + step] = temp;
			}
		}
		System.out.println(Arrays.toString(arr));
	}
}
