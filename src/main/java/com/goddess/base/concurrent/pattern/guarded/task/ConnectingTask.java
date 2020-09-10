package com.goddess.base.concurrent.pattern.guarded.task;

import com.goddess.base.concurrent.pattern.guarded.AlarmAgent;

/**
 * 负责与告警服务器建立网络连接
 *
 * @author qinshengke
 * @since 2020/9/10 23:25
 **/
public class ConnectingTask implements Runnable {
	private final AlarmAgent alarmAgent;

	public ConnectingTask(AlarmAgent alarmAgent) {
		this.alarmAgent = alarmAgent;
	}

	@Override
	public void run() {
		try {
			// 模拟耗时操作
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		alarmAgent.onConnected();
	}
}
