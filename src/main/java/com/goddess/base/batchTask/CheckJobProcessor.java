package com.goddess.base.batchTask;

import com.goddess.base.batchTask.vo.JobInfo;
import com.goddess.base.collection.DelayedItem;

import java.util.Map;
import java.util.concurrent.DelayQueue;

/**
 * 任务完成后，在一定的时间供查询结果，之后为释放资源节约内存，需要定期处理过期的任务
 *
 * @author qinshengke
 * @since 2020/6/22 21:17
 **/
public class CheckJobProcessor {
	/**
	 * 存放任务的队列
	 */
	private static DelayQueue<DelayedItem<String>> queue = new DelayQueue<>();

	/*单例化*/
	private static class ProcessorHolder {
		public static CheckJobProcessor processor = new CheckJobProcessor();
	}

	public static CheckJobProcessor getInstance() {
		return ProcessorHolder.processor;
	}



	/**
	 * 处理队列中到期任务
	 */
	private static class FetchJob implements Runnable {

		private static DelayQueue<DelayedItem<String>> queue = CheckJobProcessor.queue;
		//缓存的工作信息
		private static Map<String, JobInfo<?>> jobInfoMap = PendingJobPool.getMap();

		@Override
		public void run() {
			while (true) {
				try {
					DelayedItem<String> item = queue.take();
					String jobName = (String) item.getData();
					jobInfoMap.remove(jobName);
					System.out.println(jobName + " 过期了，从缓存中清除");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 任务完成后，放入队列，经过expireTime时间后，会从整个框架中移除
	 */
	public void putJob(String jobName, long expireTime) {
		DelayedItem<String> item = new DelayedItem<>(expireTime, jobName);
		queue.offer(item);
		System.out.println(jobName + "已经放入过期检查缓存，时长：" + expireTime);
	}

	static {
		Thread thread = new Thread(new FetchJob());
		thread.setDaemon(true);
		thread.start();
		System.out.println("开启过期检查的守护线程......");
	}
}
