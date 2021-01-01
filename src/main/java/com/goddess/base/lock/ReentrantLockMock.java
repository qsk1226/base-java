package com.goddess.base.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock 独占锁示例
 *
 * @author qinshengke
 * @since 2020/4/14 21:43
 **/
public class ReentrantLockMock {
	private int count = 0;
	private final Lock lock = new ReentrantLock();

	private void add() {
		lock.lock();
		try {
			this.count++;
		} finally {
			lock.unlock();
		}
	}

	static class UseLock extends Thread {
		ReentrantLockMock reentrantLockMock;

		UseLock(ReentrantLockMock reentrantLockMock) {
			this.reentrantLockMock = reentrantLockMock;
		}

		@Override
		public void run() {
			reentrantLockMock.add();
		}
	}

	public static void main(String[] args) {
		ReentrantLockMock reentrantLockMock = new ReentrantLockMock();
		for (int i = 0; i < 100; i++) {
			new UseLock(reentrantLockMock).start();
		}
		System.out.println("最终：" + reentrantLockMock.count);

	}

}
