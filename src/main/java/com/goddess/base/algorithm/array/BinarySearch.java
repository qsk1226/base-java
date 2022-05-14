package com.goddess.base.algorithm.array;

/**
 * 输出在数组中第一个大于等于查找值的位置，如果数组中不存在这样的数，则输出数组长度加一。
 *
 * @author qinshengke
 * @since 2021/4/20
 **/
public class BinarySearch {

	public static void main(String[] args) {
		int[] a = new int[]{1,2,3,4,4,4,4,4,5,6,7,8,9,10,11,12,13,14};
		System.out.println(tmpUpper(a,5));
	}

	public static int tmpUpper(int[] nums, int value) {
		int low = 0;
		int tmp = 0;
		int high = nums.length;
		while (low < high) {
			int mid = (low + high)/2;
			if (nums[mid] < value) {
				low = mid + 1 ;
			} else {
				high = mid - 1;
				tmp = mid;
				while (nums[tmp] >= value) {
					tmp--;
				}
				if (tmp != mid) {
					return tmp + 2;
				}
			}
		}
		return tmp + 1;
	}

}
