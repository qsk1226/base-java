package com.goddess.base.algorithm.sort;

import com.goddess.base.algorithm.array.SortTestHelper;

import java.util.Arrays;

/**
 * 1、比较相邻的元素。如果第一个比第二个大，就交换他们两个。
 * <p>
 * 2、对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。
 * <p>
 * 3、针对所有的元素重复以上的步骤，除了最后一个。
 * <p>
 * 4、持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
 *
 * @author qinshengke
 * @since 2021/3/3
 **/
public class 冒泡排序 {

	/**
	 * 数组 a 前 n 位进行排序 O(N^2)
	 */
	public static void bubbleSort(int[] a, int n) {
		int i, j;
		//表示 n 次排序过程
		for (i = 0; i < n; i++) {
			for (j = 1; j < n - i; j++) {
				//前面的数字大于后面的数字就交换
				if (a[j - 1] > a[j]) {
					// 交换 a[j-1]和 a[j]
					int temp = a[j - 1];
					a[j - 1] = a[j];
					a[j] = temp;
				}
			}
		}

		System.out.println(Arrays.toString(a));
	}

	public static void main(String[] args) {
		int[] nums = SortTestHelper.generateRandomArray(10, 30);
		bubbleSort(nums, nums.length);
	}

}