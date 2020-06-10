package com.goddess.base.design_model.singleton;

/**
 * 私有静态内部类单例模式
 * 从外部无法访问静态内部类 LazyHolder，只有当调用 Singleton.getInstance() 方法的时候，才能得到单例对象 INSTANCE。
 * INSTANCE 对象初始化的时机并不是在单例类 Singleton 被加载的时候，而是在调用 getInstance 方法，使得静态内部类 LazyHolder 被加载的时候。
 * 这种实现方式是利用classloader的加载机制来实现懒加载，并保证构建单例的线程安全。
 *
 * @author qinshengke
 * @since 2020/5/30 13:17
 **/
public class StaticSingleton {

	private static class LazyHolder {
		private static final StaticSingleton INSTANCE = new StaticSingleton();
	}

	private StaticSingleton() {
	}

	public static StaticSingleton getInstance() {
		return LazyHolder.INSTANCE;
	}

}
