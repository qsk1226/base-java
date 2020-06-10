package com.goddess.base.baseThread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * 新线程的创建方式
 *
 * @author qinshengke
 * @since 2020/3/28 10:59
 **/
public class NewThread {

	public static void main(String[] args) {
		try {
			FutureTask<String> futureTask = new FutureTask<>(new UseCall());
			new Thread(futureTask).start();

			new Thread(new UseRunnable()).start();

			System.out.println(futureTask.get());

			UseThread interruptThread = new UseThread("别打断我");
			interruptThread.start();
			interruptThread.interrupt();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 使用Runnable接口实现线程
	 */
	private static class UseRunnable implements Runnable {
		Thread thread = Thread.currentThread();

		@Override
		public void run() {
			System.out.println("runnable 接口实现");
		}
	}

	/**
	 * 使用Callable接口
	 */
	private static class UseCall implements Callable<String> {
		@Override
		public String call() throws Exception {
			System.out.println("Callable 接口实现");

			return "返回Callable 接口结果值";
		}
	}

	/**
	 * 使用Thread类实现线程
	 */
	private static class UseThread extends Thread {

		UseThread(String name) {
			super(name);
		}

		@Override
		public void run() {
			// 线程未被打断
			while (!isInterrupted()) {
				System.out.println(getName() + " : 正在执行");
			}
			System.out.println(getName() + "interrupt flag is :" + (isInterrupted() ? "被打断" : "爽歪歪"));
		}
	}

}
