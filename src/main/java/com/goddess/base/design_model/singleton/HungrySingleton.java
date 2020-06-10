package com.goddess.base.design_model.singleton;

/**
 * 饿汉式单例模式
 *
 * @author qinshengke
 * @since 2020/5/30 13:13
 **/
public class HungrySingleton {
	private static HungrySingleton instance = new HungrySingleton();

	private HungrySingleton() {
	}

	public static HungrySingleton getInstance() {
		return instance;
	}

}
