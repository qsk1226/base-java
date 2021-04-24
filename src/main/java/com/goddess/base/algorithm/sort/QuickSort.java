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
		int[] arr = new int[]{0,11, 1, 33, 2, 9, 13, 44, 5};
		int[] xx = quickSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(xx));
	}

	public static int[] quickSort(int[] array,int low,int high) {

		if (low < high) {
			int jizhun = array[low];
			int index = low + 1;
			for (int i = index; i <= high; i++) {
				if (array[i] < jizhun) {
					int tmp = array[i];
					array[i] = array[index];
					array[index] = tmp;
					index++;
				}
			}

			int tmp = array[low];
			array[low] = array[index - 1];
			array[index - 1] = tmp;

			quickSort(array, low, index-1);
			quickSort(array, index, high);
		}
		return array;
	}


}