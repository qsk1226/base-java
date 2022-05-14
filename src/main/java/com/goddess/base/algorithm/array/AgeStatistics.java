package com.goddess.base.algorithm.array;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 一个文件包含全国人民的年龄，每一行都是一个年龄，统计每个年龄的人数
 *
 * @author qinshengke
 * @since 2022/4/10
 **/
public class AgeStatistics {

	/**
	 * 三岁的有多少人
	 */
	public static void main(String[] args) {
		String fileName = "/Users/qinshengke/age1.txt";
		int[] statistic = statistic(fileName);
		for (int i = 0; i < statistic.length; i++) {
			System.out.println("年龄 i ，" + i + "人数：" + statistic[i]);
		}
		System.out.println(statistic[3]);
	}

	public static int[] statistic(String fileName) {
		int[] result = new int[0];
		try {
			InputStreamReader isr = new InputStreamReader(new FileInputStream(fileName));
			BufferedReader bis = new BufferedReader(isr);

			result = new int[200];

			String lineStr = null;
			while ((lineStr = bis.readLine()) != null) {
				int age = Integer.parseInt(lineStr);
				result[age] = result[age] + 1;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
}
