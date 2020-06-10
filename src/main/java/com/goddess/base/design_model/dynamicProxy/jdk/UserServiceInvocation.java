package com.goddess.base.design_model.dynamicProxy.jdk;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 用户服务代理
 *
 * @author qinshengke
 * @since 2020/4/28 22:42
 **/
@Slf4j
public class UserServiceInvocation implements InvocationHandler {
    private Object realObj;

    public UserServiceInvocation(Object realObj) {
        super();
        this.realObj = realObj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (args == null)
            throw new IllegalArgumentException("args can not be null~");
        Object invoke = method.invoke(realObj, args);
        log.info("代理方法执行完成");
        return invoke;

    }
}
