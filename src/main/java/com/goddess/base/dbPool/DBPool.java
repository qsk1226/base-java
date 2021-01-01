package com.goddess.base.dbPool;

import java.sql.Connection;
import java.util.LinkedList;

/**
 * 简单的数据库连接池实现
 *
 * @author qinshengke
 * @since 2020/5/30 20:17
 **/
public class DBPool {
	private static LinkedList<Connection> pool = new LinkedList<>();

	public DBPool(int initialSize) {
		if (initialSize <= 0) {
			throw new IllegalArgumentException("连接数不能小于1");
		}
		ConnectionFactory connectionFactory = new ConnectionFactory();
		for (int i = 0; i < initialSize; i++) {
			pool.addLast(connectionFactory.createConnection());
		}
	}

	/**
	 * 释放连接
	 *
	 * @param connection 数据库连接
	 */
	public void releaseConnection(Connection connection) {
		if (connection != null) {
			synchronized (pool) {
				pool.add(connection);
				pool.notifyAll();
			}
		}
	}

	public Connection getConnection(long mills) throws InterruptedException {
		synchronized (pool) {
			// 永不超时
			if (mills <= 0) {
				while (pool.isEmpty()) {
					pool.wait();
				}
				return pool.removeFirst();
			} else {
				long future = System.currentTimeMillis() + mills;
				/*等待时长*/
				long remaining = mills;
				while (pool.isEmpty() && remaining > 0) {
					pool.wait(remaining);
					/*每次唤醒需要重新唤醒一次*/
					remaining = future - System.currentTimeMillis();
				}
				Connection connection = null;
				if (!pool.isEmpty()) {
					connection = pool.removeFirst();
				}
				return connection;
			}
		}
	}

}
