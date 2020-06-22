package com.goddess.base.batchTask.vo;

/**
 * 任务处理后返回的结果实体类
 *
 * @author qinshengke
 * @since 2020/6/22 21:18
 **/
public class TaskResult<R> {
	/**
	 * 方法执行结果
	 */
	private final TaskResultType resultType;
	/**
	 * 方法执行后的结果数据
	 */
	private final R returnValue;
	/**
	 * 如果方法失败，这里可以填充失败原因
	 */
	private final String reason;

	public TaskResult(TaskResultType resultType, R returnValue, String reason) {
		this.resultType = resultType;
		this.returnValue = returnValue;
		this.reason = reason;
	}

	public TaskResult(TaskResultType resultType, R returnValue) {
		this.resultType = resultType;
		this.returnValue = returnValue;
		this.reason = "SUCCESS";
	}

	public TaskResultType getResultType() {
		return resultType;
	}

	public String getReason() {
		return reason;
	}

	public R getReturnValue() {
		return returnValue;
	}

	@Override
	public String toString() {
		return "TaskResult [resultType=" + resultType
				+ ", returnValue=" + returnValue
				+ ", reason=" + reason + "]";
	}
}
