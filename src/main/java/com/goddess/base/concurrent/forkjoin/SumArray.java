package com.goddess.base.concurrent.forkjoin;

import java.util.concurrent.ForkJoinPool;

/**
 * @author qinshengke
 * @since 2020/4/13 21:20
 **/
public class SumArray {

	public static void main(String[] args) {
		int[] src = MakeArray.makeArray();
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		SumTask sumTask = new SumTask(src, 0, src.length - 1);

		Integer invoke = forkJoinPool.invoke(sumTask);
		System.out.println(invoke);

	}


}
