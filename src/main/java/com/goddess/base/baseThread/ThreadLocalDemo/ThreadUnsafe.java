package com.goddess.base.baseThread.ThreadLocalDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ThreadLocal费线程安全操作
 *
 * @author qinshengke
 * @since 2020/4/11 17:04
 **/
public class ThreadUnsafe {

    static class UseThreadUnsafe implements Runnable {
        private int value;

        UseThreadUnsafe(int value) {
            this.value = value;
        }

        @Override
        public void run() {
            Object o = ThreadLocalContext.get();
            if (o == null) {
                ThreadLocalContext.set(value+1);
            }
            System.out.println(Thread.currentThread().getName()+" 线程局部变量表：" + ThreadLocalContext.get());
            //ThreadLocalContext.remove();
        }
    }


    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        try {
            for (int i = 0; i < 6; i++) {
                executorService.execute(new UseThreadUnsafe(i));
            }
            System.out.println("pool execute over");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            executorService.shutdown();
        }
    }

}
