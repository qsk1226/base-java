package com.goddess.base.batchTask.example;


import com.goddess.base.batchTask.vo.ITaskProcessor;
import com.goddess.base.batchTask.vo.TaskResult;
import com.goddess.base.batchTask.vo.TaskResultType;

import java.util.Random;

/**
 * 类说明：一个实际任务类，将数值加上一个随机数，并休眠随机时间
 */
public class MyTaskProcessor implements ITaskProcessor<Integer, Integer> {

	@Override
	public TaskResult<Integer> taskExecute(Integer data) {
		Random r = new Random();
		int flag = r.nextInt(500);
		try {
			Thread.sleep(flag);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//正常处理的情况
		if (flag <= 300) {
			Integer returnValue = data.intValue() + flag;
			return new TaskResult<Integer>(TaskResultType.SUCCESS, returnValue);
		} else if (flag > 301 && flag <= 400) {//处理失败的情况
			return new TaskResult<Integer>(TaskResultType.FAILURE, -1, "Failure");
		} else {//发生异常的情况
			try {
				throw new RuntimeException("异常发生了！！");
			} catch (Exception e) {
				return new TaskResult<Integer>(TaskResultType.EXCEPTION, -1, e.getMessage());
			}
		}
	}

}