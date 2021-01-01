package com.goddess.base.concurrent;

import com.goddess.base.concurrent.util.SleepTools;

import java.util.concurrent.CountDownLatch;

/**
 * 所有兄线程都完成之前，都得等着，如果都收拾好了，开始下一步行动
 *
 * @author qinshengke
 * @since 2020/10/3 12:32
 **/
public class UseCountDownLatch {

	static CountDownLatch latch = new CountDownLatch(6);

	/*初始化线程*/
	private static class InitThread implements Runnable {

		public void run() {
			System.out.println("Thread_" + Thread.currentThread().getId() + " ready init work......");
			latch.countDown();
			for (int i = 0; i < 2; i++) {
				System.out.println("Thread_" + Thread.currentThread().getId() + " ........continue do its work");
			}
		}
	}

	/*业务线程等待latch的计数器为0完成*/
	private static class BusiThread implements Runnable {

		public void run() {
			try {
				latch.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			for (int i = 0; i < 3; i++) {
				System.out.println("BusiThread_" + Thread.currentThread().getId() + " do business-----");
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		new Thread(() -> {
			SleepTools.ms(1);
			System.out.println("Thread_" + Thread.currentThread().getId() + " ready init work step 1st......");
			latch.countDown();
			System.out.println("begin step 2nd.......");
			SleepTools.ms(1);
			System.out.println("Thread_" + Thread.currentThread().getId() + " ready init work step 2nd......");
			latch.countDown();
		}).start();

		new Thread(new BusiThread()).start();

		for (int i = 0; i <= 3; i++) {
			Thread thread = new Thread(new InitThread());
			thread.start();
		}

		latch.await();
	}
}