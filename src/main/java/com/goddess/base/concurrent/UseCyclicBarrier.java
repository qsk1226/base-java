package com.goddess.base.concurrent;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;

public class UseCyclicBarrier {

	private static CyclicBarrier barrier
			= new CyclicBarrier(4, new CollectThread());

	//存放子线程工作结果的容器
	private static ConcurrentHashMap<String, Long> resultMap
			= new ConcurrentHashMap<>();

	public static void main(String[] args) {
		for (int i = 0; i < 4; i++) {
			Thread thread = new Thread(new SubThread());
			thread.start();
		}

	}

	/*汇总的任务*/
	private static class CollectThread implements Runnable {

		@Override
		public void run() {
			StringBuilder result = new StringBuilder();
			for (Map.Entry<String, Long> workResult : resultMap.entrySet()) {
				result.append("[" + workResult.getValue() + "]");
			}
			System.out.println(" the result = " + result);
			System.out.println("do other business........");
		}
	}

	/*相互等待的子线程*/
	private static class SubThread implements Runnable {

		@Override
		public void run() {
			long id = Thread.currentThread().getId();
			resultMap.put(Thread.currentThread().getId() + "", id);
			try {
				Thread.sleep(1000 + id);
				System.out.println("Thread_" + id + " ....do something ");
				barrier.await();
				// 这里CyclicBarrier 计数器再次使用
				Thread.sleep(1000 + id);
				System.out.println("Thread_" + id + " ....do its business ");
				barrier.await();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
}