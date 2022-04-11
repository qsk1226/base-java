package com.goddess.base.algorithm.array;

/**
 * 输出在数组中第一个大于等于查找值的位置，如果数组中不存在这样的数，则输出数组长度加一。
 *
 * @author qinshengke
 * @since 2021/4/20
 **/
public class BinarySearch {
	/**
	 * n = 5, v = 4,  a = [1,2,4,4,4,4,5]
	 */
	public static int upper(int length, int v, int[] a) {
		int low = 0;
		int high = length;
		while (low < high) {
			int mid = (low + high) / 2;
			if (v >= a[mid]) {
				low = mid + 1;
				int tmp = mid;
				while(a[tmp] >= v) {
					tmp--;
				}
				return tmp+2;
			} else if (v < a[mid]) {
				high = mid - 1;
			}
		}
		return high + 1;
	}

	public static void main(String[] args) {
		int[] a = new int[]{1,2,4,4,4,4,5};
		System.out.println(upper(7,4, a));
	}
}
