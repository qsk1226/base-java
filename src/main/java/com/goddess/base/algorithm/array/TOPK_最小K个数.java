package com.goddess.base.algorithm.array;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.IntStream;

/**
 * TOP K 问题，最小 K 个数
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 * @author qinshengke
 * @since 2021/4/24
 **/
public class TOPK_最小K个数 {

	public static void main(String[] args) {
		int[] arr = new int[]{0, 11, 1, 33, 2, 9, 13, 44, 5};
		int[] leastNumbers = getLeastNumbers(arr, 2);
		Arrays.stream(leastNumbers).forEach(System.out::println);
	}

	public static int[] getLeastNumbers(int[] arr, int k) {

		// 最后一个参数表示我们要找的是下标为 k-1 的数
		quickSearch(arr, 0, arr.length - 1);
		return Arrays.copyOf(arr, k);
	}

	/**
	 * 快速查寻
	 */
	private static void quickSearch(int[] nums, int low, int high) {
		if (low > high) return;
		int i = low, j = high;

		while (i < j) {
			while (i < j && nums[j] >= nums[low]) j--;
			while (i < j && nums[i] <= nums[low]) i++;
			swap(nums, i, j);
		}
		swap(nums, i, low);
		quickSearch(nums, low, i - 1);
		quickSearch(nums, i + 1, high);

	}


	/**
	 * ===========================================================
	 * 保持堆的大小为K，然后遍历数组中的数字，遍历的时候做如下判断：
	 * 1. 若目前堆的大小小于K，将当前数字放入堆中。
	 * 2. 否则判断当前数字与大根堆堆顶元素的大小关系，如果当前数字比大根堆堆顶还大，这个数就直接跳过；
	 * 反之如果当前数字比大根堆堆顶小，先poll掉堆顶，再将该数字放入堆中。
	 */
	public int[] getLeastNumbers1(int[] arr, int k) {
		if (k == 0 || arr.length == 0) {
			return new int[0];
		}
		// 默认是小根堆，实现大根堆需要重写一下比较器。
		Queue<Integer> pq = new PriorityQueue<>((v1, v2) -> v2 - v1);
		for (int num : arr) {
			if (pq.size() < k) {
				pq.offer(num);
			} else if (num < pq.peek()) {
				pq.poll();
				pq.offer(num);
			}
		}

		// 返回堆中的元素
		int[] res = new int[pq.size()];
		int idx = 0;
		for (int num : pq) {
			res[idx++] = num;
		}
		return res;
	}

	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}