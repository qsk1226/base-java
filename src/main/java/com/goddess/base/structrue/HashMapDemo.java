package com.goddess.base.structrue;

import com.goddess.base.concurrent.util.SleepTools;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 *
 * @author qinshengke
 * @since 2020/10/3 22:10
 **/
public class HashMapDemo {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>(10);
		map.put("战士", 1);
		map.put("法师", 2);
		map.put("盗贼", 3);
		map.put("术士", 4);
		map.put("牧师", 5);
		map.put("猎人", 6);
		map.put("圣骑士", 7);
		map.put("萨满", 8);
		map.put("死亡骑士", 9);
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}


		SleepTools.second(1000);
	}
}
