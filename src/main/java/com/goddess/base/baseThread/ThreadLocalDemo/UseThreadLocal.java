package com.goddess.base.baseThread.ThreadLocalDemo;


/**
 * ThreadLocal的使用可以与
 * 变量threadLocal可以更改为普通的变量 1 的情况做对比
 *
 * @author qinshengke
 * @since 2020/3/28 14:53
 **/
public class UseThreadLocal {
	static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 1);

	static class UseThreadLocalDemo extends Thread {

		private final Integer value;

		public UseThreadLocalDemo(Integer value) {
			super(String.valueOf(value + 1));
			this.value = value;
		}

		@Override
		public void run() {
			// 从当前线程的threadLocal中获取绑定的value值
			Integer integer = threadLocal.get();
			if (integer == null) {
				threadLocal.set(1);
			}
			threadLocal.set(integer + value);
			System.out.println("线程:" + getName() + " 获取threadLocal值:" + threadLocal.get());
			threadLocal.remove();
		}
	}

	public static void main(String[] args) {
		Thread[] runs = new Thread[3];

		for (int i = 0; i < 3; i++) {
			runs[i] = new UseThreadLocalDemo(i);
		}
		for (Thread run : runs) {
			run.start();
		}
	}
}
