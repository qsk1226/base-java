package com.goddess.base.algorithm;

/**
 * 折半查找
 *
 * @author qinshengke
 * @since 2021/3/3
 **/
public class 折半查找 {

	public static int biSearch(int[] array, int a) {
		int lo = 0;
		int hi = array.length - 1;
		int mid;

		while (lo <= hi) {
			mid = (lo + hi) / 2;//中间位置
			if (array[mid] == a) {
				return mid + 1;
			} else if (array[mid] < a) {
				//向右查找
				lo = mid + 1;
			} else {
				//向左查找
				hi = mid - 1;
			}
		}
		return -1;
	}


	public static void main(String[] args) {

	}
}
