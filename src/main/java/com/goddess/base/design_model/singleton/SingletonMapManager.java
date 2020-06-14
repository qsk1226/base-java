package com.goddess.base.design_model.singleton;

import java.util.HashMap;
import java.util.Map;

/**
 * 使用容器来实现单例模式
 *
 * @author qinshengke
 * @since 2020/5/30 13:19
 **/
public class SingletonMapManager {
	private static final Map<String, Object> objMap = new HashMap<>();

	private SingletonMapManager() {
	}

	public static void registerService(String key, Object instance) {
		if (!objMap.containsKey(key)) {
			objMap.put(key, instance);
		}
	}

	public static Object getService(String key) {
		return objMap.get(key);
	}
}