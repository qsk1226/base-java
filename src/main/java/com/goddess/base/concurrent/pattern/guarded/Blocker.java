package com.goddess.base.concurrent.pattern.guarded;

import java.util.concurrent.Callable;

/**
 * 负责对执行guardedMethod方法的线程进行挂起和唤醒
 * 并执行ConcreteGuardedAction所实现的目标操作
 *
 * @author qinshengke
 * @since 2020/9/10 21:16
 **/
public interface Blocker {
	/**
	 * 负责执行目标操作和暂挂当前线程
	 */
	<T> T callWithGuard(GuardedAction<T> guardedAction, AlarmInfo alarmInfo) throws Exception;

	/**
	 * signalafter:负责执行 stateOperation 指定的动作和唤醒由该方法所属 Blocker 实例所暂挂的线程中的一个线程。
	 */
	void signalAfter(Callable<Boolean> stateOperation) throws Exception;

	/**
	 * signal:负责唤醒由该方法所属 Blocker实例所暂挂的线程中的一个线程。
	 */
	void signal() throws Exception;

	/**
	 * broadcastAfter: 负责执行其参数指定的动作和唤醒由该方法所属 Blocker实例所暂挂的所有线程。
	 */
	void broadcastAfter(Callable<Boolean> stateOperation) throws Exception;

	/**
	 * broadcast:负责唤醒由该方法所属 Blocker实例暂挂的所有线程。
	 */
	public void broadcast();
}
