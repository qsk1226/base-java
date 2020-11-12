package com.goddess.base.concurrent;

import org.openjdk.jol.info.ClassLayout;

/**
 * 偏向锁重偏向
 *
 * @author qinshengke
 * @since 2020/9/23 17:30
 **/
public class biasedLimitSyn {

	public static void main(String[] args) {
		Object obj = new Object();

		for (int i = 0; i < 10; i++) {
			synchronized (obj) {
				System.out.println("main---" + ClassLayout.parseInstance(obj).toPrintable());
			}
		}

		System.out.println("oooo---" + ClassLayout.parseInstance(obj).toPrintable());
		for (int i = 0; i < 10; i++) {
			new Thread(()->{
				synchronized (obj) {
					System.out.println("t---" + ClassLayout.parseInstance(obj).toPrintable());
				}
			}).start();
		}

		System.out.println("xxxxxx---" + ClassLayout.parseInstance(obj).toPrintable());
	}
}
