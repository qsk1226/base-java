package com.goddess.base.algorithm;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 最近最少使用缓存
 *
 * @author qinshengke
 * @since 2021/3/12
 **/
public class LRUCache<K, V> extends LinkedHashMap<K, V> {

	private int cacheSize;

	public LRUCache(int cacheSize) {
		super(16, 0.75f, true);
		this.cacheSize = cacheSize;
	}

	@Override
	protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
		return size() >= cacheSize;
	}

	public static void main(String[] args) {
		System.out.println((int)Math.pow(10,1));
	}
}
