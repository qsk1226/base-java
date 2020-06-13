package com.goddess.base.design_model.observer;

/**
 * 抽象被观察者
 *
 * @author qinshengke
 * @since 2020/6/12 17:47
 **/
public interface Subject {
	/**
	 * 增加订阅者
	 *
	 * @param observer
	 */
	public void addObserver(Observer observer);

	/**
	 * 删除订阅者
	 *
	 * @param observer
	 */
	public void removeObserver(Observer observer);

	/**
	 * 通知订阅者更新消息
	 */
	public void notifyObserver(String message);
}
