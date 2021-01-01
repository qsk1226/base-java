package com.goddess.base.lock.deadlock;

/**
 * Synchronized 死锁
 *
 * @author qinshengke
 * @since 2020/7/13 21:51
 **/
public class SynchronizedDeadLock {

	public static void main(String[] args) {
		new ThreadX().start();
		new ThreadY().start();
	}

}


class ThreadX extends Thread {
	@Override
	public void run() {
		sayHello();
	}

	public static synchronized void sayHello() {
		System.out.println("ThreadX lock");
		try {
			Thread.sleep(4000);
			ThreadY.sayHello();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class ThreadY extends Thread {

	@Override
	public void run() {
		sayHello();
	}

	public static synchronized void sayHello() {
		System.out.println("ThreadY lock");
		try {
			Thread.sleep(4000);
			ThreadX.sayHello();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}