package com.goddess.base.blocking;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class SemaphoreBlockingQueue<E> implements CustomBlockingQueue<E> {
	private final List<E> valueList;
	private final Semaphore putActionNum;//可以进行put操作的许可数量
	private final Semaphore getActionNum;//可以进行take操作的许可数量
	private final Semaphore mutex;

	public SemaphoreBlockingQueue(int capacity) {
		putActionNum = new Semaphore(capacity);//维护队列大小
		getActionNum = new Semaphore(0);//初始化时，队列为空，put操作许可数量为0
		mutex = new Semaphore(1);//用于保护非线程安全的valueList操作，用于并发生产时控制
		valueList = new ArrayList<E>(capacity);
	}


	public void put(E message) {
		try {
			putActionNum.acquire();//put操作许可减1
			mutex.acquire();
			valueList.add(message);
			mutex.release();
			getActionNum.release();//get操作许可加1
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public E take() {
		E message = null;
		try {
			getActionNum.acquire();//get操作许可减1
			mutex.acquire();
			if (valueList.size() > 0) {
				message = valueList.get(0);
				valueList.remove(0);
			} else {
				return null;
			}
			mutex.release();
			putActionNum.release();//put操作许可加1
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return message;
	}
}
