package com.goddess.base.concurrent.pattern.guarded;

/**
 * 抽象了目标动作，并关联了目标动作所需的保护条件。
 *
 * @author qinshengke
 * @since 2020/9/10 21:16
 **/
public abstract class GuardedAction<T> {
	/** 保护条件*/
	protected final Predicate predicate;

	public GuardedAction(Predicate predicate) {
		this.predicate = predicate;
	}

	/**
	 * 关联目标方法
	 */
	public abstract T action(AlarmInfo alarmInfo) throws Exception;



}
