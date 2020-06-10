package com.goddess.base.concurrent;

/**
 * 死锁
 *
 * @author qinshengke
 * @since 2020/1/7
 */
public class DeadLock {
    public static void main(String[] args) {
        new Thread(() -> ThreadA.sayHello()).start();

        new Thread(() -> ThreadB.sayHello()).start();
    }
}

class ThreadA {

    public static synchronized void sayHello() {
        System.out.println("ThreadA lock");
        try {
            Thread.sleep(4000);
            ThreadB.sayHello();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class ThreadB {

    public static synchronized void sayHello() {
        System.out.println("ThreadB lock");
        try {
            Thread.sleep(4000);
            ThreadA.sayHello();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}