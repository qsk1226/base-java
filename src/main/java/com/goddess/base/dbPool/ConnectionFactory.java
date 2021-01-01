package com.goddess.base.dbPool;

import java.sql.Connection;

/**
 * 数据库连接工厂
 *
 * @author qinshengke
 * @since 2020/5/30 20:21
 **/
public class ConnectionFactory {
	public Connection createConnection() {
		return new CustomeConnection();
	}

}
