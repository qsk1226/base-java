package com.goddess.base.baseThread.interrupt;

import java.util.concurrent.locks.LockSupport;

/**
 * 线程的可中断
 *
 * @author qinshengke
 * @since 2020/12/21
 **/
class MyThread extends Thread {
	private Object object;

	public MyThread(Object object) {
		this.object = object;
	}

	public void run() {
		System.out.println("before interrupt");
		try {
			// 休眠3s
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Thread thread = (Thread) object;
		// 中断线程
		thread.interrupt();
		System.out.println("after interrupt");
	}
}

public class InterruptDemo {
	public static void main(String[] args) {
		MyThread myThread = new MyThread(Thread.currentThread());
		myThread.start();
		System.out.println("before park");
		// 获取许可
		LockSupport.park("ParkAndUnparkDemo");
		System.out.println("after park");
	}
}
