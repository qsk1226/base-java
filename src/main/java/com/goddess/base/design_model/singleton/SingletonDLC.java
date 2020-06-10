package com.goddess.base.design_model.singleton;

/**
 * 懒汉+双重检测机制
 *
 * @author qinshengke
 * @since 2020/3/28 17:49
 **/
public class SingletonDLC {
	//
	private volatile static SingletonDLC singletonDLC;

	private SingletonDLC() {
	}

	public static SingletonDLC getInstance() {
		if (singletonDLC == null) {
			synchronized (SingletonDLC.class) {
				if (singletonDLC == null) {
					singletonDLC = new SingletonDLC();
				}
			}
		}
		return singletonDLC;
	}
}
