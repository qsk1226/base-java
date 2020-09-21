package com.goddess.base.concurrent.pattern.guarded;

import com.goddess.base.concurrent.pattern.guarded.task.ConnectingTask;
import com.goddess.base.concurrent.pattern.guarded.task.HeartbeatTask;
import lombok.Data;

import java.util.Timer;

/**
 * TODO
 *
 * @author qinshengke
 * @since 2020/9/11 00:33
 **/
@Data
public class GuardedManager {

	/**
	 * predicate 参与者实例
	 */
	private final Predicate predicate = new ConcretePredicate();

	/**
	 * blocker参与者实例
	 */
	private final Blocker blocker = new ConditionViaBlocker();

	/**
	 * 心跳定时器
	 */
	private final Timer heartbeatTimer = new Timer(true);

	private AlarmAgent alarmAgent;

	public void init() {
		Thread connectingThread = new Thread(new ConnectingTask(alarmAgent));

		connectingThread.start();

		heartbeatTimer.schedule(new HeartbeatTask(alarmAgent), 60000, 2000);
	}

	public void sendAlarmInfo(AlarmInfo alarmInfo) throws Exception {
		GuardedAction<Void> concreteGuardedAction = getGuardedAction();
		alarmAgent.sendAlarm(concreteGuardedAction,alarmInfo);
		blocker.callWithGuard(concreteGuardedAction, alarmInfo);
	}

	public <T> GuardedAction<T>  getGuardedAction(){
		return new ConcreteGuardedAction<>(alarmAgent, predicate);
	}
}
