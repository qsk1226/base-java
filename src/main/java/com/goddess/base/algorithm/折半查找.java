package com.goddess.base.algorithm;

/**
 * 折半查找
 *
 * @author qinshengke
 * @since 2021/3/3
 **/
public class 折半查找 {

	public static int biSearch(int[] array, int a) {
		int low = 0;
		int high = array.length - 1;
		int mid;

		while (low <= high) {
			mid = (low + high) / 2;//中间位置
			if (array[mid] == a) {
				return mid + 1;
			} else if (array[mid] < a) {
				//向右查找
				low = mid + 1;
			} else {
				//向左查找
				high = mid - 1;
			}
		}
		return -1;
	}



	public static void main(String[] args) {

	}
}
