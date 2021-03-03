package com.goddess.base.blocking;

import java.util.LinkedList;
import java.util.List;

public class WaiteNotifyBlockingQueue<E> implements CustomBlockingQueue<E> {

	private List<E> queue = new LinkedList<>();
	private int limit = 10;

	public WaiteNotifyBlockingQueue(int limit) {
		this.limit = limit;
	}


	public synchronized void put(E item) {
		while (this.queue.size() >= this.limit) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if (this.queue.size() == 0) {
			notifyAll();
		}
		this.queue.add(item);
	}


	public synchronized E take() {
		while (this.queue.size() == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if (this.queue.size() == this.limit) {
			notifyAll();
		}

		return this.queue.remove(0);
	}

}
