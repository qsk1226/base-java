package com.goddess.base.memory;

import java.util.HashSet;
import java.util.Set;

/**
 * jdk1.6之前 -XX:PermSize=6M -XX:MaxPermSize=6M
 * jdk1.6之后 -Xmx6M
 *
 * @author qinshengke
 * @since 2020/4/12 00:06
 **/
public class ConstantPoolOOMMock {

    public static void main(String[] args) {
        Set<String> stringSet = new HashSet<>();
        int i = 0;
        while (true) {
            stringSet.add(String.valueOf(i++).intern());
        }
    }
}
