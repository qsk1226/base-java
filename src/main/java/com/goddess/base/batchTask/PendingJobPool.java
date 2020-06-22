package com.goddess.base.batchTask;

import com.goddess.base.batchTask.vo.ITaskProcessor;
import com.goddess.base.batchTask.vo.JobInfo;
import com.goddess.base.batchTask.vo.TaskResult;
import com.goddess.base.batchTask.vo.TaskResultType;

import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

/**
 * 主题类，也是调用这主要使用的类
 *
 * @author qinshengke
 * @since 2020/6/22 21:17
 **/
public class PendingJobPool {
	/*框架运行时的线程数，与机器的CPU数相同*/
	private static final int THREAD_COUNTS = Runtime.getRuntime().availableProcessors();
	/*队列，线程池使用，用以存放待处理的任务*/
	private static BlockingQueue<Runnable> taskQueue = new ArrayBlockingQueue<Runnable>(5000);
	/*线程池，固定大小，有界队列*/
	private static ExecutorService taskExecutor
			= new ThreadPoolExecutor(THREAD_COUNTS, THREAD_COUNTS, 60, TimeUnit.SECONDS, taskQueue);

	/*工作信息的存放容器*/
	private static ConcurrentHashMap<String, JobInfo<?>> jobInfoMap = new ConcurrentHashMap<String, JobInfo<?>>();

	public static Map<String, JobInfo<?>> getMap() {
		return jobInfoMap;
	}

	/*以单例模式启动*/
	private PendingJobPool() {
	}

	private static class JobPoolHolder {
		public static PendingJobPool pool = new PendingJobPool();
	}

	public static PendingJobPool getInstance() {
		return JobPoolHolder.pool;
	}

	/**
	 * 调用者提交工作中的任务
	 */
	public <T, R> void putTask(String jobName, T t) {
		JobInfo<R> jobInfo = getJob(jobName);
		PendingTask<T, R> task = new PendingTask<>(jobInfo, t);
		taskExecutor.execute(task);
	}

	/**
	 * 根据工作名称检索工作
	 */
	@SuppressWarnings("unchecked")
	private <R> JobInfo<R> getJob(String jobName) {
		JobInfo<R> jobInfo = (JobInfo<R>) jobInfoMap.get(jobName);
		if (null == jobInfo)
			throw new RuntimeException(jobName + "是非法任务！");
		return jobInfo;
	}

	/**
	 * 调用者注册工作，如工作名，任务的处理器等等
	 */
	public <R> void registerJob(String jobName, int jobLength, ITaskProcessor<?, ?> taskProcessor, long expireTime) {
		JobInfo<R> jobInfo = new JobInfo<R>(jobName, jobLength, taskProcessor, expireTime);
		if (jobInfoMap.putIfAbsent(jobName, jobInfo) != null) {
			throw new RuntimeException(jobName + "已经注册！");
		}
	}

	/**
	 * 获得工作的整体处理进度
	 */
	public <R> String getTaskProgess(String jobName) {
		JobInfo<R> jobInfo = getJob(jobName);
		return jobInfo.getTotalProcess();
	}

	/*获得每个任务的处理详情*/
	public <R> List<TaskResult<R>> getTaskDetail(String jobName) {
		JobInfo<R> jobInfo = getJob(jobName);
		return jobInfo.getTaskDetail();
	}

}
