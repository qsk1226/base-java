package com.goddess.base.memory;

/**
 * jvm栈OOM
 * -Xss256k
 * @author qinshengke
 * @since 2020/4/11 23:31
 **/
public class StackOOMErrorMock {
    public static void main(String[] args) {
        for (int i = 0; ; i++) {
            new Thread(()->{
                while (true) {

                }
            }).start();
        }
    }
}
