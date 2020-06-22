package com.goddess.base.batchTask;

import com.goddess.base.batchTask.vo.ITaskProcessor;
import com.goddess.base.batchTask.vo.JobInfo;
import com.goddess.base.batchTask.vo.TaskResult;
import com.goddess.base.batchTask.vo.TaskResultType;

/**
 * 任务
 *
 * @author qinshengke
 * @since 2020/6/22 23:20
 **/
public class PendingTask<T, R> implements Runnable {
	private JobInfo<R> jobInfo;
	private T processData;

	public PendingTask(JobInfo<R> jobInfo, T processData) {
		this.jobInfo = jobInfo;
		this.processData = processData;
	}

	@Override
	public void run() {
		R retVal = null;
		ITaskProcessor<T, R> taskProcessor = (ITaskProcessor<T, R>) jobInfo.getTaskProcessor();

		TaskResult<R> result = null;

		try {
			result = taskProcessor.taskExecute(processData);
			if (null == result) {
				result = new TaskResult<>(TaskResultType.EXCEPTION, retVal, "result is null");
			}
			if (result.getResultType() == null) {
				if (result.getReason() == null) {
					result = new TaskResult<R>(TaskResultType.EXCEPTION, retVal, "result is null");
				} else {
					result = new TaskResult<R>(TaskResultType.EXCEPTION, retVal, "result is null,reason:" + result.getReason());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = new TaskResult<R>(TaskResultType.EXCEPTION, retVal, e.getMessage());
		} finally {
			jobInfo.addTaskResult(result);
		}

	}
}