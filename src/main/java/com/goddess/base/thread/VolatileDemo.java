package com.goddess.base.thread;

/**
 * volatile使用
 *
 * @author qinshengke
 * @since 2020/5/30 21:11
 **/
public class VolatileDemo {
	private volatile static boolean ready;
	private static int number = 1;

	private static class PrintThread extends Thread {
		public PrintThread(String name) {
			super(name);
		}
		@Override
		public void run() {
			while (!ready) {
				System.out.println("number: " + number++);
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		new PrintThread("volatile apply").start();
		Thread.sleep(2000);
		ready = true;
	}
}
