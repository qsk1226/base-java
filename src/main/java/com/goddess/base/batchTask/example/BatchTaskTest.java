package com.goddess.base.batchTask.example;

import com.goddess.base.batchTask.PendingJobPool;
import com.goddess.base.batchTask.vo.TaskResult;

import java.util.List;
import java.util.Random;

/**
 * TODO
 *
 * @author qinshengke
 * @since 2020/6/22 23:07
 **/
public class BatchTaskTest {


	private final static String JOB_NAME = "计算数值";
	private final static int JOB_LENGTH = 1000;

	//查询任务进度的线程
	private static class QueryResult implements Runnable {

		private PendingJobPool pool;

		public QueryResult(PendingJobPool pool) {
			super();
			this.pool = pool;
		}

		@Override
		public void run() {
			int i = 0;
			while (i < 350) {
				List<TaskResult<String>> taskDetail = pool.getTaskDetail(JOB_NAME);
				if (!taskDetail.isEmpty()) {
					System.out.println(pool.getTaskProgess(JOB_NAME));
					System.out.println(taskDetail);
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				i++;
			}
		}

	}

	public static void main(String[] args) {
		MyTaskProcessor myTaskProcessor = new MyTaskProcessor();
		PendingJobPool pool = PendingJobPool.getInstance();
		pool.registerJob(JOB_NAME, JOB_LENGTH, myTaskProcessor, 5);
		Random r = new Random();
		for (int i = 0; i < JOB_LENGTH; i++) {
			pool.putTask(JOB_NAME, r.nextInt(1000));
		}
		Thread t = new Thread(new QueryResult(pool));
		t.start();
	}
}
