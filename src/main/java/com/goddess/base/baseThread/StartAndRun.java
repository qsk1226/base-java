package com.goddess.base.baseThread;

/**
 * start和run的区别
 *
 * 执行Thread的run()方法 是在main线程中执行
 * 执行Thread的start()方法是另外启动一个线程执行
 * run()   ------>   thread-main-----90
 * start() ------>   thread-go die-----90
 *
 * @author qinshengke
 * @since 2020/3/28 13:55
 **/
public class StartAndRun {

	public static void main(String[] args) throws InterruptedException {
		ThreadRun threadRun = new ThreadRun();
		threadRun.setName("go die");

		threadRun.start();

		Thread.currentThread().join();

	}

	private static class ThreadRun extends Thread {
		@Override
		public void run() {
			int i = 90;
			while (i > 0) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("thread-" + Thread.currentThread().getName() + "-----" + i--);
			}
		}
	}

}
