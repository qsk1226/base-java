package com.goddess.base.concurrent.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CachedData {
	Object data;
	volatile boolean cacheValid;
	final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

	void processCachedData() {
		// 先上 读锁
		rwl.readLock().lock();
		if (!cacheValid) {
			// Must release read lock before acquiring write lock
			rwl.readLock().unlock();
			rwl.writeLock().lock();
			try {
				// Recheck state because another thread might have
				// acquired write lock and changed state before we did.
				if (!cacheValid) {
					data = "cached";
					cacheValid = true;
				}
				// Downgrade by acquiring read lock before releasing write lock
				rwl.readLock().lock();
			} finally {
				rwl.writeLock().unlock(); // Unlock write, still hold read
			}
		}

		try {
			System.out.println("");
		} finally {
			rwl.readLock().unlock();
		}
	}

	public static void main(String[] args) {
		CachedData cachedData = new CachedData();
		cachedData.processCachedData();

	}


}