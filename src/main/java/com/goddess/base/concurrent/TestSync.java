package com.goddess.base.concurrent;

import lombok.extern.slf4j.Slf4j;

/**
 * 测试Synchronized关键字锁 --- 非公平锁
 * <p>
 * 如果这里打印的结果是无序的则表示 非公平锁
 * 有序则公平锁
 * 倒叙 为什么几乎上不可能研究
 * 因为他存在一个队列  C++
 *
 * @author qinshengke
 * @since 2020/9/4 21:58
 **/
@Slf4j(topic = "TestSync")
public class TestSync {

	private static final Object lock = new Object();

	public static void main(String[] args) throws InterruptedException {

		Thread[] threadPool = new Thread[10];

		for (int i = 0; i < 10; i++) {
			Thread thread = new Thread(() -> {
				synchronized (lock) {
					log.info(Thread.currentThread().getName() + "  get sync lock");
				}
			});
			threadPool[i] = thread;
		}

		synchronized (lock) {
			for (int i = 0; i < 10; i++) {
				threadPool[i].start();
			}
			// Thread.sleep(10);
		}


	}
}
