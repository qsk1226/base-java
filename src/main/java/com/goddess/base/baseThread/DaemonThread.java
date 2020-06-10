package com.goddess.base.baseThread;

/**
 * 守护线程：
 *
 * @author qinshengke
 * @since 2020/5/30 14:14
 **/
public class DaemonThread {
	private static class UseThread extends Thread {

		@Override
		public void run() {
			try {
				while (true) {
					System.out.println(Thread.currentThread().getName() + " Iam extends Thread.");
				}
			} finally {
				// 守护线程中finally不一定起作用
				System.out.println("-------finally");
			}
		}
	}

	static {
		UseThread useThread = new UseThread();
		useThread.setDaemon(true);
		useThread.start();
	}

	public static void main(String[] args) throws InterruptedException {

		UseThread useThread = new UseThread();
		useThread.setDaemon(true);
		useThread.start();
		Thread.sleep(2000);


	}

}
