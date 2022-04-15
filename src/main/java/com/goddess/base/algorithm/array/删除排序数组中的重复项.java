package com.goddess.base.algorithm.array;

/**
 * 删除排序数组中的重复项,返回新数组的长度 要求 O(1)
 *
 * @author qinshengke
 * @since 2022/4/14
 **/
public class 删除排序数组中的重复项 {
	/**
	 * [1,2,3,3,4,4,5]
	 */
	public static void main(String[] args) {
		int[] a = new int[]{1,2,3,3,4,4,5};
		System.out.println(xx(a));
	}

	public static int xx(int[] nums) {
		int i = 0;
		for (int j = 1; j < nums.length;j++) {
			if (nums[i] != nums[j]) {
				i++;
				nums[i] = nums[j];
			}
		}
		return i+1;
	}
}
