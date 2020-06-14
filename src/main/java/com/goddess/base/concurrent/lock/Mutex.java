package com.goddess.base.concurrent.lock;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;


/**
 * 这是一个不可重入互斥锁类，它使用零值来表示解锁状态，一个表示锁定状态。
 * 虽然不可重入锁不严格要求记录当前的所有者线程，但是这样做无论如何使得使用更容易监视。
 * 它还支持条件并公开其中一种仪器方法：
 *
 * @author qinshengke
 * @since 2020/4/18 23:23
 **/
class Mutex implements Lock, java.io.Serializable {

	// 内部AQS工具类
	private static class Sync extends AbstractQueuedSynchronizer {
		//是否是锁定状态
		protected boolean isHeldExclusively() {
			return getState() == 1;
		}

		// 如果state==0 尝试获取锁
		public boolean tryAcquire(int acquires) {
			assert acquires == 1;
			if (compareAndSetState(0, 1)) {
				setExclusiveOwnerThread(Thread.currentThread());
				return true;
			}
			return false;
		}

		// 将state设置为 0 以释放锁
		protected boolean tryRelease(int releases) {
			assert releases == 1;
			if (getState() == 0) {
				throw new IllegalMonitorStateException();
			}
			//当前线程设置为null
			setExclusiveOwnerThread(null);
			// 设置锁定状态为 0
			setState(0);
			return true;
		}

		// 提供条件类
		Condition newCondition() {
			return new ConditionObject();
		}

		// Deserializes properly
		private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
			s.defaultReadObject();
			setState(0);
		}
	}

	// The sync object does all the hard work. We just forward to it.
	private final Sync sync = new Sync();

	public void lock() {
		sync.acquire(1);
	}

	public boolean tryLock() {
		return sync.tryAcquire(1);
	}

	public void unlock() {
		sync.release(1);
	}

	public Condition newCondition() {
		return sync.newCondition();
	}

	public boolean isLocked() {
		return sync.isHeldExclusively();
	}

	public boolean hasQueuedThreads() {
		return sync.hasQueuedThreads();
	}

	public void lockInterruptibly() throws InterruptedException {
		sync.acquireInterruptibly(1);
	}

	public boolean tryLock(long timeout, TimeUnit unit) throws InterruptedException {
		return sync.tryAcquireNanos(1, unit.toNanos(timeout));
	}
}