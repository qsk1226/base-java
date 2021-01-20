package com.goddess.base.concurrent;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author qinshengke
 * @since 2020/12/3 下午2:20
 **/
public class TestConcurrent {
	volatile static AtomicLong count = new AtomicLong(0);

	public static void main(String[] args) {

		long l = System.currentTimeMillis();
		new Thread(()->{
			for (int i = 0; i < 250000000; i++) {
				count.getAndAdd(1);
			}
		}).start();

		new Thread(()->{
			for (int i = 0; i < 250000000; i++) {
				count.getAndAdd(1);
			}
		}).start();

		while (count.get() < 499999999) {

		}

		System.out.println(count.get() + "  "  +  (System.currentTimeMillis() - l)/1000);


	}
}
