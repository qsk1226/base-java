package com.goddess.base.classloader;

/**
 * 主动引用和被动引用
 *
 * @author qinshengke
 * @since 2020/4/5 11:25
 **/
public class NotInitalization {
    public static void main(String[] args) {
        //System.out.println(SubClass.value);

        //SuperClass[] superClasses = new SuperClass[10];

        SubClass.printSubClass();
    }

}


class SuperClass {
    static {
        System.out.println("SuperClass init");
    }

    public static int value = 123;
}

class SubClass extends SuperClass {

    static {
        System.out.println("SubClass init");
    }

    public static void printSubClass() {
        System.out.println("SubClass静态方法被调用");
    }
}