package com.goddess.base.blocking;

/**
 * 阻塞队列接口
 *
 * @author qinshengke
 * @since 2021/2/23
 **/
public interface CustomBlockingQueue<T> {

	void put(T message);

	T take();
}
