package com.goddess.base.concurrent.pattern.guarded;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 基于java条件变量实现的Blocker
 *
 * @author qinshengke
 * @since 2020/9/10 22:03
 **/
public class ConditionViaBlocker implements Blocker {

	private final Lock lock;

	private final Condition condition;

	public ConditionViaBlocker(Lock lock) {
		this.lock = lock;
		this.condition = lock.newCondition();
	}

	public ConditionViaBlocker() {
		this.lock = new ReentrantLock();
		this.condition = lock.newCondition();
	}

	@Override
	public <T> T callWithGuard(GuardedAction<T> guardedAction, AlarmInfo message) throws Exception {
		lock.lockInterruptibly();

		T result ;
		try {
			final Predicate guard = guardedAction.predicate;
			while (!guard.evaluate()) {
				condition.await();
			}
			result = guardedAction.action(message);
			return result;
		} finally {
			lock.unlock();
		}
	}

	@Override
	public void signalAfter(Callable<Boolean> stateOperation) throws Exception {
		lock.lockInterruptibly();
		try {
			if (stateOperation.call()) {
				condition.signal();
			}
		} finally {
			lock.unlock();
		}

	}

	@Override
	public void signal() throws Exception{
		lock.lockInterruptibly();
		try {
				condition.signal();
		} finally {
			lock.unlock();
		}
	}

	@Override
	public void broadcastAfter(Callable<Boolean> stateOperation) throws Exception {
		lock.lockInterruptibly();

		try {
			if (stateOperation.call()) {
				condition.signalAll();
			}
		} finally {
			lock.unlock();
		}
	}

	@Override
	public void broadcast() {

	}
}
