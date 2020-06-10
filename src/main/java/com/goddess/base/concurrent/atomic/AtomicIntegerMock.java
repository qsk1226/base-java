package com.goddess.base.concurrent.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * AtomicInteger使用
 *
 * @author qinshengke
 * @since 2020/4/14 21:28
 **/
public class AtomicIntegerMock {
    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                atomicInteger.getAndSet(atomicInteger.get() + 1);
            }).start();
            System.out.println(atomicInteger.get());
        }
    }
}
