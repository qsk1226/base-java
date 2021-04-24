package com.goddess.base.algorithm.滑动窗口;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个正整数 target ，输出所有和为 target 的  连续正整数序列（至少含有两个数）。
 * <p>
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * target = 9 --->  输出 [[2,3,4],[4,5]]
 *
 * @author qinshengke
 * @since 2021/4/24
 **/
public class FindContinuousSequence {

	public static void main(String[] args) {
		findContinuousSequence(9);
	}
	/**
	 * 滑动窗口解法
	 */
	public static int[][] findContinuousSequence(int target) {
		int i = 1; // 滑动窗口的左边界
		int j = 1; // 滑动窗口的右边界
		int sum = 0; // 滑动窗口中数字的和
		List<int[]> res = new ArrayList<>();

		while (i <= target / 2) {
			if (sum < target) {
				// 右边界向右移动
				sum += j;
				j++;
			} else if (sum > target) {
				// 左边界向右移动
				sum -= i;
				i++;
			} else {
				// 记录结果
				int[] arr = new int[j - i];
				for (int k = i; k < j; k++) {
					arr[k - i] = k;
				}
				res.add(arr);
				// 左边界向右移动
				sum -= i;
				i++;
			}
		}

		return res.toArray(new int[res.size()][]);
	}


	public int[][] findContinuousSequence1(int target) {
		List<int[]> vec = new ArrayList<int[]>();
		int sum = 0, limit = (target - 1) / 2; // (target - 1) / 2 等效于 target / 2 下取整
		for (int i = 1; i <= limit; ++i) {
			for (int j = i; ; ++j) {
				sum += j;
				if (sum > target) {
					sum = 0;
					break;
				} else if (sum == target) {
					int[] res = new int[j - i + 1];
					for (int k = i; k <= j; ++k) {
						res[k - i] = k;
					}
					vec.add(res);
					sum = 0;
					break;
				}
			}
		}
		return vec.toArray(new int[vec.size()][]);
	}


	/**
	 * 双指针方式
	 */
	public int[][] findContinuousSequence2(int target) {
		List<int[]> vec = new ArrayList<int[]>();
		for (int l = 1, r = 2; l < r; ) {
			int sum = (l + r) * (r - l + 1) / 2;
			if (sum == target) {
				int[] res = new int[r - l + 1];
				for (int i = l; i <= r; ++i) {
					res[i - l] = i;
				}
				vec.add(res);
				l++;
			} else if (sum < target) {
				r++;
			} else {
				l++;
			}
		}
		return vec.toArray(new int[vec.size()][]);
	}
}
