package com.goddess.base.conc_utils;

import com.goddess.base.conc_utils.events.EventData;

/**
 * 事件发布器
 *
 * @author qinshengke
 * @since 2020/4/3 22:13
 **/
public interface EventPublisher {


	default void publishEvent(EventData eventData) {
		publishEvent(eventData);
	}

	/**
	 * 发布事件
	 **/
	void publishEvent(Object event);
}
