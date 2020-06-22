package com.goddess.base.batchTask.vo;

/**
 * 要求框架使用者实现任务接口，因为任务在调用时才知道，需要根据传入的参数和方法返回值均使用泛型
 *
 * @author qinshengke
 * @since 2020/6/22 21:18
 **/
public interface ITaskProcessor<T, R> {
	/**
	 * 执行任务
	 *
	 * @param data 任务数据
	 * @return 返回值
	 */
	TaskResult<R> taskExecute(T data);
}
