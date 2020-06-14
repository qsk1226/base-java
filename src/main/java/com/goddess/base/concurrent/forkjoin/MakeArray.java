package com.goddess.base.concurrent.forkjoin;

import java.util.Random;

/**
 * TODO
 *
 * @author qinshengke
 * @since 2020/4/13 21:16
 **/
public class MakeArray {
	public static final int ARRAY_LENGTH = 4000;
	public static final int threshold = 47;

	public static int[] makeArray() {
		Random random = new Random();
		int[] ints = new int[ARRAY_LENGTH];
		for (int i = 0; i < ARRAY_LENGTH; i++) {
			ints[i] = random.nextInt(ARRAY_LENGTH * 3);
		}
		return ints;
	}

}
