package com.goddess.base.lock.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 可重入的独占锁
 *
 * @author qinshengke
 * @since 2020/4/19 11:10
 **/
public class SelfLock implements Lock {

	/**
	 * 自定义同步器
	 *
	 * @author qinshengke
	 * @since 2020/4/19 11:11
	 **/
	static class Sync extends AbstractQueuedSynchronizer {
		protected Sync() {
			super();
		}

		// 此处只实现了独占锁，重入锁未实现,非公平锁
		@Override
		protected boolean tryAcquire(int arg) {
			// 第一次获取同步状态
			if (compareAndSetState(0, 1)) {
				// 设置持有独占锁的线程
				setExclusiveOwnerThread(Thread.currentThread());
				return true;
			}
			if (Thread.currentThread() == getExclusiveOwnerThread()) {
				int lockCount = getState() + 1;
				setState(lockCount);
				return true;
			}
			return false;
		}

		@Override
		protected boolean tryRelease(int arg) {
			int currentState = getState();
			if (Thread.currentThread() != getExclusiveOwnerThread()) {
				throw new IllegalMonitorStateException("不是占有同步状态的线程，不允许操作");
			}
			boolean free = false;
			int nextCount = currentState - 1;
			if (nextCount == 0) {
				free = true;
				setExclusiveOwnerThread(null);
			}
			setState(nextCount);
			return free;
		}

		@Override
		protected int tryAcquireShared(int arg) {
			return super.tryAcquireShared(arg);
		}

		@Override
		protected boolean tryReleaseShared(int arg) {
			return super.tryReleaseShared(arg);
		}

		@Override
		protected boolean isHeldExclusively() {
			return super.isHeldExclusively();
		}

		Condition newCondition() {
			return new ConditionObject();
		}
	}

	Sync sync = new Sync();

	@Override
	public void lock() {
		sync.acquire(1);
	}

	@Override
	public void lockInterruptibly() throws InterruptedException {
		sync.acquireInterruptibly(1);
	}

	@Override
	public boolean tryLock() {
		return sync.tryAcquire(1);
	}

	@Override
	public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
		return sync.tryAcquireNanos(1, unit.toNanos(time));
	}

	@Override
	public void unlock() {
		sync.release(1);
	}

	@Override
	public Condition newCondition() {
		return sync.newCondition();
	}

}
