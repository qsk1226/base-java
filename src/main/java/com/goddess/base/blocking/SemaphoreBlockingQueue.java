package com.goddess.base.blocking;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * 基于信号量的阻塞队列
 *
 * @author qinshengke
 * @since 2021/3/9
 **/
public class SemaphoreBlockingQueue<E> implements CustomBlockingQueue<E> {
	private final List<E> valueList;
	/**
	 * 可以进行put操作的许可数量
	 */
	private final Semaphore putActionNum;
	/**
	 * 可以进行take操作的许可数量
	 */
	private final Semaphore getActionNum;
	private final Semaphore mutex;

	public SemaphoreBlockingQueue(int capacity) {
		//维护队列大小
		putActionNum = new Semaphore(capacity);
		//初始化时，队列为空，put操作许可数量为0
		getActionNum = new Semaphore(0);
		//用于保护非线程安全的valueList操作，用于并发生产时控制
		mutex = new Semaphore(1);
		valueList = new ArrayList<E>(capacity);
	}


	public void put(E message) {
		try {
			//put操作许可减1
			putActionNum.acquire();
			mutex.acquire();
			valueList.add(message);
			mutex.release();
			//get操作许可加1
			getActionNum.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public E take() {
		E message = null;
		try {
			//get操作许可减1
			getActionNum.acquire();
			mutex.acquire();
			if (valueList.size() > 0) {
				message = valueList.get(0);
				valueList.remove(0);
			} else {
				return null;
			}
			mutex.release();
			//put操作许可加1
			putActionNum.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return message;
	}
}
