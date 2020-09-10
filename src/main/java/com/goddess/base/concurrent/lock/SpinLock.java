package com.goddess.base.concurrent.lock;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

/**
 * TODO
 *
 * @author qinshengke
 * @since 2020/8/26 21:54
 **/
public class SpinLock {
	/**
	 * 锁状态
	 */
	volatile AtomicInteger status = new AtomicInteger(0);


	public void lock() {
		//如果抢锁失败，则进入阻塞模式
		while (!status.compareAndSet(0,1)) {

		}
	}

	public void unlock(){
		status.set(0);
	}



}
