package com.goddess.base.gc;

import java.util.ArrayList;

/**
 * 测试堆上的垃圾回收
 * -XX:+PrintGCDetails -XX:+PrintGC -Xms300M -Xmx300M
 *
 * @author qinshengke
 * @since 2020/8/2 00:28
 **/
public class HeapGC {
    byte[] _100KB = new byte[1024*100];//100KB
    public static void main(String[] args) throws Exception {
        ArrayList<HeapGC> heapGCS =new ArrayList<>();
        while (true){
            heapGCS.add(new HeapGC());
            Thread.sleep(10);
        }
    }
}

