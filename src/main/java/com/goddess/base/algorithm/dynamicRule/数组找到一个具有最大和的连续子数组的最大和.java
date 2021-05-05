package com.goddess.base.algorithm.dynamicRule;

/**
 * 动态规划：给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * @author qinshengke
 * @since 2021/4/16
 **/
public class 数组找到一个具有最大和的连续子数组的最大和 {

	public int maxSubArray(int[] nums) {
		int pre = 0, maxAns = nums[0];
		for (int x : nums) {
			pre = Math.max(pre + x, x);
			maxAns = Math.max(maxAns, pre);
		}
		return maxAns;
	}

	/**
	 * 动态规划的是首先对数组进行遍历，当前最大连续子序列和为 sum，结果为 ans
	 * 如果 sum > 0，则说明 sum 对结果有增益效果，则 sum 保留并加上当前遍历数字
	 * 如果 sum <= 0，则说明 sum 对结果无增益效果，需要舍弃，则 sum 直接更新为当前遍历数字
	 * 每次比较 sum 和 ans的大小，将最大值置为ans，遍历结束返回结果
	 * 时间复杂度：O(n)O(n)
	 */
	public int maxSubArray1(int[] nums) {
		int ans = nums[0];
		int sum = 0;
		for (int num : nums) {
			if (sum > 0) {
				sum += num;
			} else {
				sum = num;
			}
			ans = Math.max(ans, sum);
		}
		return ans;
	}

	public int maxSubArrayx(int[] nums) {
		return f(nums, 0);
	}

	public int f(int[] nums, int start) {

		int result=nums[start];
		int sum = 0;

		for(int i = start; i < nums.length; i++) {
			sum= Math.max(nums[i], nums[i] + sum);
			result = Math.max(result, sum);
		}
		return result;
	}

	public static void main(String[] args) {
		数组找到一个具有最大和的连续子数组的最大和 maxSubArray = new 数组找到一个具有最大和的连续子数组的最大和();
		int[] array = new int[]{-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArray.maxSubArrayx(array));
	}

}
