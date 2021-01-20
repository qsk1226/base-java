package com.goddess.base.thread.interrupt;

/**
 * 中断Runnable接口
 *
 * @author qinshengke
 * @since 2020/5/30 14:04
 **/
public class InterruptRunnable {

	private static class UseRunnable implements Runnable {
		@Override
		public void run() {
			// 需要在线程中通过while方式不断的判断线程的中断标志位
			while (!Thread.currentThread().isInterrupted()) {
				System.out.println(Thread.currentThread().getName() + " I am implements Runnable.");
			}
			System.out.println(Thread.currentThread().getName() + " interrupt flag is " + Thread.currentThread().isInterrupted());
		}
	}

	public static void main(String[] args) throws InterruptedException {
		UseRunnable useRunnable = new UseRunnable();
		Thread endThread = new Thread(useRunnable, "endThread");
		endThread.start();

		Thread.sleep(20);
		endThread.interrupt();
	}

}
