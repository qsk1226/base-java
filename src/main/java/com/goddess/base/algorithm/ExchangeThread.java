package com.goddess.base.algorithm;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 两条线程交替执行
 *
 * @author qinshengke
 * @since 2021/3/9
 **/
public class ExchangeThread {
	static int count = 1;

	static Lock lock = new ReentrantLock();
	static Condition condition = lock.newCondition();

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

	/**==================================================*/
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
	/**==================================================*/
	static final ReentrantLock twoConditionLock = new ReentrantLock();
	static Condition condition1 = twoConditionLock.newCondition();
	static Condition condition2 = twoConditionLock.newCondition();

	static class RunTwoCondition1 implements Runnable {
		@Override
		public void run() {
			twoConditionLock.lock();
			try {
				while (count <= 100) {
					System.out.println(Thread.currentThread().getName() + "---" + count++);
					condition1.await();
					condition2.signalAll();
				}
			}catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				twoConditionLock.unlock();
			}
		}
	}

	static class RunTwoCondition2 implements Runnable {
		@Override
		public void run() {
			twoConditionLock.lock();
			try {
				while (count <= 100) {
					System.out.println(Thread.currentThread().getName() + "---" + count++);
					condition1.signalAll();
					condition2.await();
				}
			}catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				twoConditionLock.unlock();
			}
		}
	}

	/**==================================================*/

	public static void main(String[] args) throws InterruptedException {
		/*
		new Thread(new RunOneCondition(), "jack").start();
		new Thread(new RunOneCondition(), "lyly").start();
		// 测试 Object 对象的 wait/notifyAll
		new Thread(new RunWaitNotify(), "jack").start();
		new Thread(new RunWaitNotify(), "lyly").start();
		*/
		new Thread(new RunTwoCondition1(), "jack").start();
		new Thread(new RunTwoCondition2(), "lyly").start();


	}
}
