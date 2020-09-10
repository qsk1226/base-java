package com.goddess.base.concurrent.pattern.guarded;

import com.goddess.base.concurrent.pattern.guarded.task.ConnectingTask;
import com.goddess.base.concurrent.pattern.guarded.task.HeartbeatTask;
import lombok.extern.slf4j.Slf4j;
import sun.security.ssl.Debug;

import javax.sound.sampled.Line;
import java.util.Timer;
import java.util.concurrent.Callable;

/**
 * 受保护对象GuardedObject
 *
 * @author qinshengke
 * @since 2020/9/10 21:13
 **/
@Slf4j(topic = "guarded-pattern")
public class AlarmAgent {



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

	/**
	 * 发送告警信息，此方法会等待连接上告警服务器才会调用 doSendAlarm方法，如果sendAlarm方法在被调用时，
	 * GuardedObject实例与告警服务器的连接未建立完毕，或者连接断开，sendAlarm方法会使当前线程阻塞。
	 * 此方法的保护条件为 connectedToServer 的值为 true
	 */
	public void sendAlarm(final AlarmInfo alarmInfo) throws Exception {
		/*
		 * 可能需要等待,直到AlarmAgent连接上告警服务器(或者连接中断后重新连上服务器)
		 * 相当于 @link{{@link GuardedAction}}
		 * */
		GuardedAction<Void> guardedAction = new GuardedAction<Void>(predicate) {
			@Override
			public Void action(AlarmInfo alarmInfo) throws Exception {
				try {
					doSendAlarm(alarmInfo);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				return null;
			}
		};
		blocker.callWithGuard(guardedAction, alarmInfo);
	}

	public void sendAlarm(final GuardedAction<?> guardedAction, final AlarmInfo alarmInfo) throws Exception {
		/*
		 * 可能需要等待,直到AlarmAgent连接上告警服务器(或者连接中断后重新连上服务器)
		 * 相当于 @link{{@link GuardedAction}}
		 * */
		blocker.callWithGuard(guardedAction, alarmInfo);
	}
	/**
	 * 通过网络连接将告警信息发送给告警服务器
	 */
	protected void doSendAlarm(AlarmInfo alarmInfo) throws InterruptedException {
		log.info("sending alarm ：{}", alarmInfo);
		Thread.sleep(50);
	}

	public void init() {
		Thread connectingThread = new Thread(new ConnectingTask(this));

		connectingThread.start();

		heartbeatTimer.schedule(new HeartbeatTask(this), 60000, 2000);
	}

	public void disConnected() {
		log.info("disconnected from alarm server.");
		predicate.update(false);
	}

	public void onConnected() {
		// 将标志位connectedToServer 置为 true，并通知 blocker 去唤醒被暂挂的
		try {
			blocker.signalAfter(new Callable<Boolean>() {
				@Override
				public Boolean call() throws Exception {
					predicate.update(true);
					log.info("connected to server");
					return Boolean.TRUE;
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
