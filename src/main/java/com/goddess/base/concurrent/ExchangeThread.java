package com.goddess.base.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 两条线程交替执行
 *
 * @author qinshengke
 * @since 2021/3/9
 **/
public class ExchangeThread {

	static Lock lock = new ReentrantLock();
	static Condition condition = lock.newCondition();
	static int count = 1;

	/**
	 * 一个 Condition 的交替执行
	 */
	static class RunOneCondition implements Runnable {
		@Override
		public void run() {
			lock.lock();
			try {
				while (count <= 100) {
					System.out.println(Thread.currentThread().getName() + "---" + count++);
					condition.signalAll();
					condition.await();
					condition.signalAll();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		}
	}

	static final Object objLock = new Object();

	/**
	 * 使用 Object 对象的 wait/notifyAll 方法
	 */
	static class RunWaitNotify implements Runnable {

		@Override
		public void run() {
			synchronized (objLock) {
				try {
					while (count <= 100) {
						System.out.println(Thread.currentThread().getName() + "---" + count++);
						objLock.notifyAll();
						objLock.wait();
						objLock.notifyAll();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}


	public static void main(String[] args) throws InterruptedException {
		/*
		new Thread(new RunOneCondition(), "jack").start();
		new Thread(new RunOneCondition(), "lyly").start();
		// 测试 Object 对象的 wait/notifyAll
		new Thread(new RunWaitNotify(), "jack").start();
		new Thread(new RunWaitNotify(), "lyly").start();
		*/



	}
}
