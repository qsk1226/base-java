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
		/*int[] array = {1, 3, 5, 7, 9, 10, 13, 17};
		System.out.println(bSearch(array, 17));*/
	}



	public static int bSearch(int[] array, int value) {
		int low = 0;
		int high = array.length;
		int mid = 0;
		while (low <= high) {
			mid = (low + high) / 2;
			if (array[mid] == value) {
				return mid;
			} else if (array[mid] < value) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}

}
