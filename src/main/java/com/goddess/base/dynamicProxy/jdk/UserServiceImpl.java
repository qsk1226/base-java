package com.goddess.base.dynamicProxy.jdk;

/**
 * 用户服务实现
 *
 * @author qinshengke
 * @since 2020/4/28 22:41
 **/
public class UserServiceImpl implements UserService {
	@Override
	public void addUser(UserBean user) {
		System.out.println("保存用户" + user.toString());
	}
}
