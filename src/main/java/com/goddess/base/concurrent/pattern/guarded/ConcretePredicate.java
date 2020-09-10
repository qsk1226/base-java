package com.goddess.base.concurrent.pattern.guarded;

/**
 * 应用程序实现的具体保护条件
 *
 * @author qinshengke
 * @since 2020/9/10 21:17
 **/
public class ConcretePredicate implements Predicate {
	/**
	 * 用于记录 AlarmAgent 是否连接上告警服务器
	 */
	private volatile Boolean noticeFlag = false;

	@Override
	public boolean evaluate() {
		return noticeFlag;
	}

	@Override
	public void update(Boolean noticeFlag) {
		this.noticeFlag = noticeFlag;
	}
}
