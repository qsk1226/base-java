package com.goddess.base.blocking;

/**
 * TODO
 *
 * @author qinshengke
 * @since 2021/2/23
 **/
public interface CustomBlockingQueue<T> {

	void put(T message);

	T take();
}
