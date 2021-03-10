package com.goddess.base.blocking;

import java.util.LinkedList;
import java.util.List;

public class WaiteNotifyBlockingQueue<E> implements CustomBlockingQueue<E> {

	private final List<E> queue = new LinkedList<>();
	private int limit = 10;

	public WaiteNotifyBlockingQueue(int limit) {
		this.limit = limit;
	}


	public synchronized void put(E item) {
		try {
			while (this.queue.size() >= this.limit)
				wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (this.queue.size() == 0) {
			notifyAll();
		}
		this.queue.add(item);
	}

	public synchronized E take() {
		try {
			while (this.queue.size() == 0)
				wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (this.queue.size() == this.limit) {
			notifyAll();
		}
		return this.queue.remove(0);
	}

}
