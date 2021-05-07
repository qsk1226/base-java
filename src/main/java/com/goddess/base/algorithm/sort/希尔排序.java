package com.goddess.base.algorithm.sort;

/**
 * 希尔排序
 *
 * @author qinshengke
 * @since 2021/3/3
 **/
public class 希尔排序 {
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
	}
}
