package com.goddess.base.lock.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 共享锁简单实现
 **/
public class SimpleShareLock implements Lock {

    private static final int OFFSET = 1;
    //为n表示允许n个线程同时获得锁
    private final Sync sync = new Sync(4 * OFFSET);

    private static final class Sync extends AbstractQueuedSynchronizer {

        Sync(int count) {
            if (count <= 0) {
                throw new IllegalArgumentException("允许共享同步状态的线程数不能小于1");
            }
            setState(count);
        }

        /**
         * @param reduceCount 扣减个数
         * @return 返回小于0，表示当前线程获得同步状态失败，大于0表示当前线程获得同步状态成功
         */
        public int tryAcquireShared(int reduceCount) {
            for (; ; ) {
                int current = getState();
                int newCount = current - reduceCount;
                // 需要保证线程安全使用CAS操作
                if (newCount < 0 || compareAndSetState(current, newCount)) {
                    return newCount;
                }
            }
        }

        /**
         * @param returnCount 归还个数
         * @return
         */
        public boolean tryReleaseShared(int returnCount) {
            for (; ; ) {
                int current = getState();
                int newCount = current + returnCount;
                if (compareAndSetState(current, newCount)) {
                    return true;
                }
            }
        }

        ConditionObject newCondition() {
            return new ConditionObject();
        }
    }

    public void lock() {
        sync.acquireShared(OFFSET);
    }

    public void unlock() {
        sync.releaseShared(OFFSET);
    }

    public void lockInterruptibly() throws InterruptedException {
        sync.acquireSharedInterruptibly(OFFSET);
    }

    public boolean tryLock() {
        return sync.tryAcquireShared(OFFSET) >= 0;
    }

    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireSharedNanos(OFFSET, unit.toNanos(time));
    }

    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }
}