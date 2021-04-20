package com.goddess.base.algorithm.array;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class GetLeastNumbers {

	public int[] getLeastNumbers(int[] arr, int k) {
		if (k == 0 || arr.length == 0) {
			return new int[0];
		}
		// 最后一个参数表示我们要找的是下标为k-1的数
		return quickSearch(arr, 0, arr.length - 1, k - 1);
	}

	private int[] quickSearch(int[] nums, int lo, int hi, int k) {
		// 每快排切分1次，找到排序后下标为j的元素，如果j恰好等于k就返回j以及j左边所有的数；
		int j = partition(nums, lo, hi);
		if (j == k) {
			return Arrays.copyOf(nums, j + 1);
		}
		// 否则根据下标j与k的大小关系来决定继续切分左段还是右段。
		return j > k ? quickSearch(nums, lo, j - 1, k) : quickSearch(nums, j + 1, hi, k);
	}

	// 快排切分，返回下标j，使得比nums[j]小的数都在j的左边，比nums[j]大的数都在j的右边。
	private int partition(int[] nums, int lo, int hi) {
		int v = nums[lo];
		int i = lo, j = hi + 1;
		while (true) {
			while (++i <= hi && nums[i] < v) ;
			while (--j >= lo && nums[j] > v) ;
			if (i >= j) {
				break;
			}
			int t = nums[j];
			nums[j] = nums[i];
			nums[i] = t;
		}
		nums[lo] = nums[j];
		nums[j] = v;
		return j;
	}

	// ===========================================================
	// 保持堆的大小为K，然后遍历数组中的数字，遍历的时候做如下判断：
	// 1. 若目前堆的大小小于K，将当前数字放入堆中。
	// 2. 否则判断当前数字与大根堆堆顶元素的大小关系，如果当前数字比大根堆堆顶还大，这个数就直接跳过；
	// 反之如果当前数字比大根堆堆顶小，先poll掉堆顶，再将该数字放入堆中。
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


	// ============================================

	public int findKthLargest(int[] nums, int k) {
		int heapSize = nums.length;
		buildMaxHeap(nums, heapSize);
		for (int i = nums.length - 1; i >= nums.length - k + 1; --i) {
			swap(nums, 0, i);
			--heapSize;
			maxHeapify(nums, 0, heapSize);
		}
		return nums[0];
	}

	public void buildMaxHeap(int[] a, int heapSize) {
		for (int i = heapSize / 2; i >= 0; --i) {
			maxHeapify(a, i, heapSize);
		}
	}

	public void maxHeapify(int[] a, int i, int heapSize) {
		int l = i * 2 + 1, r = i * 2 + 2, largest = i;
		if (l < heapSize && a[l] > a[largest]) {
			largest = l;
		}
		if (r < heapSize && a[r] > a[largest]) {
			largest = r;
		}
		if (largest != i) {
			swap(a, i, largest);
			maxHeapify(a, largest, heapSize);
		}
	}

	public void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}