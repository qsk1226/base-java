package com.goddess.base.thread_pool;

import java.sql.Connection;
import java.util.LinkedList;

/**
 * 连接池，用来存放连接
 *
 * @author qinshengke
 * @since 2020/4/12 21:18
 **/
public class MyDBConnectionPool {

	private static LinkedList<Connection> pool = new LinkedList<>();

	public MyDBConnectionPool(int initalSize) {
		if (initalSize > 0) {
			pool.add(ConnectionUtils.fetchConnection());
		}

	}

	void release(Connection connection) {
		if (connection != null) {
			synchronized (pool) {
				pool.addLast(connection);
				pool.notifyAll();
			}
		}

	}

	public Connection fetchConnection(long miles) throws InterruptedException {

		synchronized (pool) {
			if (miles < 0) {
				while (pool.isEmpty()) {
					pool.wait();
				}
				return pool.removeFirst();
			} else {
				Long xx = System.currentTimeMillis() + miles;
				long remainMils = miles;
				while (pool.isEmpty() && remainMils > 0) {
					pool.wait(remainMils);
					// 被唤醒之后 重新计算超时时长
					remainMils = System.currentTimeMillis() - xx;
				}
				if (!pool.isEmpty()) {
					return pool.removeFirst();
				}
				return null;
			}
		}
	}


}
