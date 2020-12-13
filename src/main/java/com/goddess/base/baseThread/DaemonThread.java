package com.goddess.base.baseThread;

import lombok.extern.slf4j.Slf4j;

/**
 * 守护线程
 * - 当主线程结束时，（守护线程）自动关闭，就免去了还要继续关闭子线程的麻烦。
 * - 在 Daemon 线程中产生的新线程也是 Daemon 的
 * - Java自带的多线程框架，比如ExecutorService，会将守护线程转换为用户线程，所以如果要使用后台线程就不能用Java的线程池
 * - 在 Daemon 线程中产生的新线程也是 Daemon 的
 *
 * @author qinshengke
 * @since 2020/5/30 14:14
 **/
@Slf4j(topic = "qinshengke")
public class DaemonThread {
	private static class UseThread extends Thread {

		@Override
		public void run() {
			try {
				while (true) {
					log.info(Thread.currentThread().getName() + " Iam extends Thread.");
				}
			} finally {
				// 守护线程中finally不一定起作用
				log.info("-------finally");
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
