package com.goddess.base.algorithm.array;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Random;
/**
 * 生成全国人民姓名
 *
 * @author qinshengke
 * @since 2022/4/23
 **/
public class Test {
	public static void main(String[] args) throws Exception {
		final String fileName = "/Users/qinshengke/age1.txt";
		final Random random = new Random();
		BufferedWriter objWriter = null;
		objWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)));
		for (int i = 0; i < 1400000000; i++) {
			int age = Math.abs(random.nextInt()) % 180;
			objWriter.write(age + "\r\n");
		}
		objWriter.flush();
		objWriter.close();

	}
}
