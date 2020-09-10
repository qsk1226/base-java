package com.goddess.base.concurrent.pattern.guarded.task;

import com.goddess.base.concurrent.pattern.guarded.AlarmAgent;

import java.util.TimerTask;

/**
 * 心跳任务，可由定时器安排一次性或重复执行。
 *
 * @author qinshengke
 * @since 2020/9/10 23:25
 **/
public class HeartbeatTask extends TimerTask {
	private final AlarmAgent alarmAgent;

	public HeartbeatTask(AlarmAgent alarmAgent) {
		this.alarmAgent = alarmAgent;
	}

	@Override
	public void run() {
		if(!testConnection()) {
			alarmAgent.disConnected();
			reconnect();
		}
	}


	private boolean testConnection() {

		return true;
	}

	private void reconnect() {
		ConnectingTask connectingTask = new ConnectingTask(alarmAgent);
		connectingTask.run();
	}

}
