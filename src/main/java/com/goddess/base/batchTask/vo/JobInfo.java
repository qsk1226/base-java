package com.goddess.base.batchTask.vo;

import com.goddess.base.batchTask.CheckJobProcessor;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 提交给框架执行的工作实体类
 * 工作： 表示本批次需要处理的同性质任务（task）的一个集合
 *
 * @author qinshengke
 * @since 2020/6/22 21:18
 **/
public class JobInfo<R> {
	/**
	 * 工作名，用以区分框架中唯一的工作
	 */
	private final String jobName;
	/**
	 * 工作中任务的长度
	 */
	private final int jobLength;
	/**
	 * 处理工作中任务的处理器
	 */
	private final ITaskProcessor<?, ?> taskProcessor;

	/**
	 * 任务的成功次数
	 */
	private AtomicInteger successCount;
	/**
	 * 工作中任务目前已经处理的次数
	 */
	private AtomicInteger taskProcessCount;

	private LinkedBlockingDeque<TaskResult<R>> taskDetailQueues;

	private final long expireTime;

	private static CheckJobProcessor checkJob = CheckJobProcessor.getInstance();

	public JobInfo(String jobName, int jobLength, ITaskProcessor<?, ?> taskProcessor, long expireTime) {
		this.jobName = jobName;
		this.jobLength = jobLength;
		this.taskProcessor = taskProcessor;
		this.expireTime = expireTime;
		successCount = new AtomicInteger(0);
		taskProcessCount = new AtomicInteger(0);
		taskDetailQueues = new LinkedBlockingDeque<TaskResult<R>>(jobLength);
	}


	public int getSuccessCount() {
		return successCount.get();
	}

	public int getTaskProcessCount() {
		return taskProcessCount.get();
	}

	//提供工作中失败的次数
	public int getFailCount() {
		return taskProcessCount.get() - successCount.get();
	}

	public ITaskProcessor<?, ?> getTaskProcessor() {
		return taskProcessor;
	}

	public int getJobLength() {
		return jobLength;
	}

	/**
	 * 提供工作的整体进度信息
	 */
	public String getTotalProcess() {
		return "Success[" + successCount.get() + "]/Current[" + taskProcessCount.get()
				+ "] Total[" + jobLength + "]";
	}

	/**
	 * 提供工作中每个任务的处理结果
	 */
	public List<TaskResult<R>> getTaskDetail() {
		List<TaskResult<R>> taskResultList = new LinkedList<>();
		TaskResult<R> taskResult;
		while ((taskResult = taskDetailQueues.pollFirst()) != null) {
			taskResultList.add(taskResult);
		}
		return taskResultList;
	}

	/**
	 * 每个任务处理完成后，记录任务的处理结果，因为从业务应用的角度来说，
	 * 对查询任务进度数据的一致性要不高
	 * 我们保证最终一致性即可，无需对整个方法加锁
	 */
	public void addTaskResult(TaskResult<R> taskResult) {
		if (TaskResultType.SUCCESS.equals(taskResult.getResultType())) {
			successCount.incrementAndGet();
		}
		taskProcessCount.incrementAndGet();
		taskDetailQueues.addLast(taskResult);
		if (taskProcessCount.get() >= jobLength) {
			checkJob.putJob(jobName, expireTime);
		}
	}
}
