package com.goddess.base.database_pool;

import java.sql.Connection;

/**
 * TODO
 *
 * @author qinshengke
 * @since 2020/5/9 11:22
 **/
public class PooledConnection {
	private Connection connection;
	private String userName;
	private String url;
	private String password;

	protected int poolMaximumActiveConnections = 10;
	protected int poolMaximumIdleConnections = 5;
	protected int poolMaximumCheckoutTime = 20000;
	protected int poolTimeToWait = 20000;
	protected int poolMaximumLocalBadConnectionTolerance = 3;
	protected String poolPingQuery = "NO PING QUERY SET";
	protected boolean poolPingEnabled;
}
