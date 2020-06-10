package com.goddess.base.concurrent.lock;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.LockSupport;

/**
 * 先入先出非重入锁
 *
 * @author qinshengke
 * @since 2020/4/18 20:46
 **/
public class FiFOMutex {

	private final AtomicBoolean locked = new AtomicBoolean(false);
	private final Queue<Thread> waiters = new ConcurrentLinkedQueue<>();

	public void lock() {
		boolean wasInterrupted = false;
		Thread current = Thread.currentThread();
		waiters.add(current);

		// Block while not first in queue or cannot acquire lock
		while (waiters.peek() != current ||
				!locked.compareAndSet(false, true)) {
			LockSupport.park(this);
			// ignore interrupts while waiting
			if (Thread.interrupted())
				wasInterrupted = true;
		}

		waiters.remove();
		// reassert interrupt status on exit
		if (wasInterrupted)
			current.interrupt();
	}

	public void unlock() {
		locked.set(false);
		LockSupport.unpark(waiters.peek());
	}

}
