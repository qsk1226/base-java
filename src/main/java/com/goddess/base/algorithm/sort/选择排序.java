package com.goddess.base.algorithm.sort;

import java.util.Arrays;

/**
 * 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置。
 * <p>
 * 再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
 * <p>
 * 重复第二步，直到所有元素均排序完毕。
 *
 * @author qinshengke
 * @since 2021/3/3
 **/
public class 选择排序 {

	public void selectSort(int[] array) {

		for (int i = 0; i < array.length; i++) {
			int minIndex = i;
			int hand = array[i];
			for (int j = i + 1; j < array.length; j++) {
				int compare = array[j];
				if (compare < hand) {
					hand = compare;
					minIndex = j;
				}
			}

			// 将找到的最小值和i位置所在的值进行交换
			if (i != minIndex) {
				int tmp = array[i];
				array[i] = array[minIndex];
				array[minIndex] = tmp;
			}

		}
		System.out.println(Arrays.toString(array));
	}

	public static void main(String[] args) {
		选择排序 选择排序 = new 选择排序();
		选择排序.selectSort(new int[]{2, 3, 1, 5, 72, 22, 33, 11});
	}

}
