package com.goddess.base.concurrent.pattern.guarded;

/**
 * 抽象了保护条件
 *
 * @author qinshengke
 * @since 2020/9/10 21:17
 **/
public interface Predicate {
	/**
	 * 保护条件的方法
	 */
	boolean evaluate();

	void update(Boolean noticeFlag);

}
