package com.goddess.base.classloader;

/**
 * 虚拟机字节码执行引擎派发
 *
 * @author qinshengke
 * @since 2020/4/6 12:22
 **/
public class DynamicDispatch {

    abstract static class Human {
        public abstract void sayHello();
    }

    static class Man extends Human {
        public void sayHello() {
            System.out.println("Hello man");
        }
    }

    static class Woman extends Human {
        public void sayHello() {
            System.out.println("Hello woman");
        }
    }


    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        man.sayHello();
        woman.sayHello();
    }
}