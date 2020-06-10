package com.goddess.base.design_model.dynamicProxy.jdk;

import java.lang.reflect.Proxy;

/**
 * jdk动态代理客户端
 *
 * @author qinshengke
 * @since 2020/4/28 22:41
 **/
public class Client {

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        UserService userServiceProxy = (UserService) Proxy.newProxyInstance(userService.getClass().getClassLoader(),
                userService.getClass().getInterfaces(), new UserServiceInvocation(userService));
        userServiceProxy.addUser(new UserBean());
        System.out.println("end");

    }
}
