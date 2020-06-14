package com.goddess.base.concurrent.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock
 *
 * @author qinshengke
 * @since 2020/4/14 21:43
 **/
public class LockMock {
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

	public static void main(String[] args) {

		LockMock lockMock = new LockMock();
		for (int i = 0; i < 100; i++) {
			new UseLock(lockMock).start();
		}
		System.out.println("最终：" + lockMock.count);

	}

	static class UseLock extends Thread {
		LockMock lockMock;

		UseLock(LockMock lockMock) {
			this.lockMock = lockMock;
		}

		@Override
		public void run() {
			lockMock.add();
		}
	}

}
