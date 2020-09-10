package com.goddess.base.concurrent.pattern.guarded;

/**
 * 应用程序所显现的具体目标动作，及其关联的保护条件
 *
 * @author qinshengke
 * @since 2020/9/10 21:40
 **/
public class ConcreteGuardedAction<T> extends GuardedAction<T> {
	private final AlarmAgent alarmAgent;

	public ConcreteGuardedAction(AlarmAgent alarmAgent, Predicate predicate) {
		super(predicate);
		this.alarmAgent = alarmAgent;
	}

	@Override
	public T action(AlarmInfo alarmInfo) throws Exception {
		try {
			alarmAgent.doSendAlarm(alarmInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
