package com.goddess.base.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * 执行人类清除计划
 *
 * @author qinshengke
 * @since 2021/1/20
 **/
public class Plan {
	public static void main(String[] args) {
		ServiceLoader<HumanCleaner> load = ServiceLoader.load(HumanCleaner.class);
		Iterator<HumanCleaner> iterator = load.iterator();

		while (iterator.hasNext()) {
			HumanCleaner next = iterator.next();
			next.clean();
		}
	}
}
