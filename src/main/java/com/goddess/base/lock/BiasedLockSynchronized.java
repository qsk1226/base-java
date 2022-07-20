package com.goddess.base.lock;

//import org.openjdk.jol.info.ClassLayout;

/**
 * 开启偏向锁并且偏向锁设置为立即生效
 * jvm默认会偏向延时 5s
 * -XX:+UseBiasedLocking 关闭偏向锁
 * -XX:BiasedLockingStartupDelay=0  偏向锁立即生效
 *
 * @author qinshengke
 * @since 2020/9/18 22:09
 **/
public class BiasedLockSynchronized {
	// static 禁用偏向锁吗
	//private static Object object = new Object();

	public static void main(String[] args) throws InterruptedException {
		/*Object object = new Object();
		System.out.println(" original -- " + ClassLayout.parseInstance(object).toPrintable());
		// main线程 很大概率会限制性 开启偏向锁的时候
		synchronized (object) {
			System.out.println(" 1- main sync locked -- " + ClassLayout.parseInstance(object).toPrintable());
		}

		System.out.println("1 - main sync released -- " + ClassLayout.parseInstance(object).toPrintable());

		// 同一个线程重入锁
		synchronized (object) {
			System.out.println(" 2- main sync locked -- " + ClassLayout.parseInstance(object).toPrintable());
		}
		System.out.println("2 - main sync released -- " + ClassLayout.parseInstance(object).toPrintable());

		Thread t2 = new Thread(() -> {
			synchronized (object) {
				System.out.println("t2 sync --" + ClassLayout.parseInstance(object).toPrintable());
			}
		});

		// 当前对象头地址不是当前线程，升级为轻量级锁
		Thread t1 = new Thread(() -> {
			synchronized (object) {
				System.out.println("t1 sync--" + ClassLayout.parseInstance(object).toPrintable());
				// 此处 t2 不会和 t1 竞争 锁资源，搁外面会竞争,存在竞争则升级成重量级锁
				t2.start();
			}
		});

		t1.start();
		//t2.start();

		t1.join();
		t2.join();
		// t2 在t1中开启的时候，轻量级锁释放后，这里会看到 变成了无锁不可偏向 001
		// t2 不在 t1 中开启，t1 和 t2 竞争 膨胀为 重量锁， 等待t1 和 t2 释放锁后， 锁依然是重量级锁
		System.out.println("finally --" + ClassLayout.parseInstance(object).toPrintable());*/

	}

}
