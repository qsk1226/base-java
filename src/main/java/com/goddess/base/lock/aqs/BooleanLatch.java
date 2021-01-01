package com.goddess.base.lock.aqs;

import com.goddess.base.concurrent.util.SleepTools;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class BooleanLatch {

	private static class Sync extends AbstractQueuedSynchronizer {
		boolean isSignalled() {
			return getState() != 0;
		}

		protected int tryAcquireShared(int ignore) {
			return isSignalled() ? 1 : -1;
		}

		protected boolean tryReleaseShared(int ignore) {
			setState(ignore);
			return true;
		}
	}

	private final Sync sync = new Sync();

	public boolean isSignalled() {
		return sync.isSignalled();
	}

	public void signal() {
		sync.releaseShared(1);
	}

	public void await() throws InterruptedException {
		sync.acquireSharedInterruptibly(1);
	}

	public static void main(String[] args) {
		BooleanLatch booleanLatch = new BooleanLatch();

		new Thread(() -> {
			try {
				booleanLatch.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "我进门了");

		}).start();

		new Thread(() -> {
			try {
				booleanLatch.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "我进门了");
		}).start();

		SleepTools.second(10);
		booleanLatch.signal();
	}
}