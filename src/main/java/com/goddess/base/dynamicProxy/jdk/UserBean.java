package com.goddess.base.dynamicProxy.jdk;

/**
 * 用户
 *
 * @author qinshengke
 * @since 2020/4/28 22:55
 **/
public class UserBean {
	private String name = "隔壁老王";

	@Override
	public String toString() {
		return this.name;
	}
}
