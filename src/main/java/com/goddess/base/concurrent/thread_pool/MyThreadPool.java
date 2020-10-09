package com.goddess.base.concurrent.thread_pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 线程池简单实现
 *
 * @author qinshengke
 * @since 2020/4/27 21:45
 **/
public class MyThreadPool {
	// 任务队列
	private static BlockingQueue<Runnable> taskBlockingQueue;

	private Worker[] workers;

	public MyThreadPool(int taskCount, int workerCount) {
		if (taskCount <= 0 || workerCount <= 0)
			throw new IllegalArgumentException();
		taskBlockingQueue = new ArrayBlockingQueue<>(taskCount);
		initWorker(workerCount);
	}

	private void initWorker(int workerCount) {
		this.workers = new Worker[workerCount];
		for (int i = 0; i < workerCount; i++) {
			Worker worker = new Worker();
			workers[i] = worker;
			workers[i].start();
		}
	}

	public void execute(Runnable task) {
		try {
			taskBlockingQueue.put(task);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


	public void destroy() {
		for (Worker worker : workers) {
			worker.shutdown();
		}
		workers = null;
	}

	// 工作线程
	private class Worker extends Thread {
		@Override
		public void run() {
			Runnable task = null;
			while (!isInterrupted()) {
				try {
					task = taskBlockingQueue.take();
				} catch (InterruptedException e) {
					// something
				}
				if (task != null) {
					task.run();
				}
			}
		}

		public void shutdown() {
			interrupt();
		}
	}

}
