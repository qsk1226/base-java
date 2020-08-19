package com.goddess.base.concurrent;

/**
 * 死锁
 *
 * @author qinshengke
 * @since 2020/1/7
 */
public class SynchronizedObjDeadLock {
	public static void main(String[] args) {
		new SynchronizedObjDeadLock().deadLock();
	}
	private static final Object objectA = new Object();
	private static final Object objectB = new Object();

	private void deadLock() {

		new Thread(()->{
			synchronized (objectA) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("dA");
				synchronized (objectB) {
					System.out.println("dB");
				}
			}
		}).start();

		new Thread(()->{
			synchronized (objectB) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("B");
				synchronized (objectA) {
					System.out.println("A");
				}
				// G1HeapRegionSize
			}
		}).start();

	}
}
