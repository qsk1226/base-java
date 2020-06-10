package com.goddess.base.database_pool;

import java.util.concurrent.BlockingQueue;

/**
 * 带连接池的数据源
 *
 * @author qinshengke
 * @since 2020/5/9 11:23
 **/
public class PooledDataSource {

	/*存储链接*/
	private static BlockingQueue<PooledConnection> POOLED_CONNECTIONS;


	public PooledDataSource() {

	}


}
