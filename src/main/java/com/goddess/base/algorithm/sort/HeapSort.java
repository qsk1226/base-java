package com.goddess.base.algorithm.sort;

/**
 * 堆排序，使用数组存储堆的时候
 * 父节点、左子树和右字数的位置
 * int parent = index/2;
 * int left = 2 * index + 1;
 * int right = 2 * index + 2;
 *
 * @author qinshengke
 * @since 2021/5/7
 **/
public class HeapSort {

	public int[] sortArray(int[] nums) {
		int len = nums.length;
		for(int i = len/2 - 1; i >= 0; i--){
			shiftDown(nums, i, len - 1);
		}
		int i = len - 1;
		while(i > 0){
			swap(nums, i--, 0);
			shiftDown(nums, 0, i);
		}
		return nums;
	}

	private void shiftDown(int[] nums, int i, int end){
		int tmp = nums[i];
		while(2 * i + 1 <= end){
			// 左节点
			int child = 2 * i + 1;
			// 比较左节点和右节点，右节点大的时候，返回右节点下标
			if(child != end && nums[child + 1] > nums[child]){
				child++;
			}
			if(tmp < nums[child]) {
				nums[i] = nums[child];
				i = child;
			}else{
				break;
			}
		}
		nums[i] = tmp;
	}

	public void swap(int nums[], int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	/**
	 * 上浮构建堆
	 */
	public int[] sortArray1(int[] nums) {
		for (int i = nums.length-1; i > 0; i--) {
			buildMaxHeap(nums, i);
			swap(nums, 0, i);
		}
		return nums;
	}

	public void buildMaxHeap(int[] arr, int length) {
		for (int i = 0; i <= length; i++) {
			swim(arr, i);
		}
	}

	public void swim(int[] nums, int index) {
		while (index >= 1 && nums[index / 2] < nums[index]) {
			swap(nums, index / 2, index);//交换
			index = index / 2;
		}
	}

	public static void main(String[] args) {
		int[] arr = new int[]{3,5,4,7,8,9,10,1,2,6};
		HeapSort x = new HeapSort();
		x.sortArray(arr);
	}
}
