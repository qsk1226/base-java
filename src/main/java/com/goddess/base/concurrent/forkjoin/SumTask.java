package com.goddess.base.concurrent.forkjoin;

import java.util.concurrent.RecursiveTask;


/**
 * 带返回值的forkJoinTask
 *
 * @author qinshengke
 * @since 2020/4/14 21:26
 **/
public class SumTask extends RecursiveTask<Integer> {

	private static final int threshold = MakeArray.ARRAY_LENGTH / 10;
	private int[] src;
	private int fromIndex;
	private int toIndex;

	public SumTask(int[] src, int fromIndex, int toIndex) {
		this.src = src;
		this.fromIndex = fromIndex;
		this.toIndex = toIndex;
	}


	@Override
	protected Integer compute() {
		if (toIndex - fromIndex < threshold) {
			int count = 0;
			for (int i = fromIndex; i <= toIndex; i++) {
				count += src[i];
			}
			return count;
		} else {
			int mid = (fromIndex + toIndex) / 2;
			SumTask left = new SumTask(src, fromIndex, mid);
			SumTask right = new SumTask(src, mid + 1, toIndex);

			invokeAll(left, right);

			return left.join() + right.join();
		}

	}
}