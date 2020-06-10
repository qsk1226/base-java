package com.goddess.base.baseThread.ThreadLocalDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ThreadLocal内存泄漏的风险演示
 * -XX:+PrintGCDetails -XX:+PrintGC -Xmx50m
 *
 * @author qinshengke
 * @since 2020/4/8 23:16
 **/
public class ThreadOOM {


	static class UseData {
		private byte[] element = new byte[1024 * 1024 * 10];// 10M
	}

	static class UseThreadOOM implements Runnable {
		@Override
		public void run() {
			ThreadLocalContext.set(new UseData());
			ThreadLocalContext.remove();
		}
	}

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		try {
			for (int i = 0; i < 3000; i++) {
				executorService.execute(new UseThreadOOM());
			}
			System.out.println("pool execute over");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			executorService.shutdown();
		}
	}

}
