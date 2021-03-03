package com.goddess.base.blocking;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionBlockingQueue<E> implements CustomBlockingQueue<E> {
	//默认的队列容量
	private static final int DEFAULT_CAPTITY = 10;
	private final ReentrantLock lock = new ReentrantLock();
	private final Condition notFull = lock.newCondition();
	private final Condition notEmpty = lock.newCondition();

	private final E[] elements;
	//队列的容量
	private int capcity;
	//队列目前的所包含的元素个数
	private int size;
	//队列头
	private int head;
	//队列尾
	private int tail;

	public ConditionBlockingQueue() {
		this(DEFAULT_CAPTITY);
	}

	public ConditionBlockingQueue(int captity) {
		if (captity < 0) {
			throw new IndexOutOfBoundsException("index:" + captity);
		}
		this.capcity = captity;
		head = tail = 0;
		elements = (E[]) new Object[captity];
	}
	@Override
	public void put(E e) {
		lock.lock();
		try {
			while (size == capcity) {
				try {
					notFull.await();
				} catch (InterruptedException interruptedException) {
					interruptedException.printStackTrace();
				}
			}
			elements[tail] = e;
			++size;
			++tail;
			tail = tail == capcity ? 0 : tail;

		} finally {
			notEmpty.signalAll();
			lock.unlock();
		}
	}

	@Override
	public E take() {
		lock.lock();
		E e;
		try {
			while (size == 0) {
				try {
					notEmpty.await();
				} catch (InterruptedException interruptedException) {
					interruptedException.printStackTrace();
				}
			}
			--size;
			e = elements[head++];
			head = head == capcity ? 0 : head;
			return e;
		} finally {
			notFull.signalAll();
			lock.unlock();
		}
	}
}