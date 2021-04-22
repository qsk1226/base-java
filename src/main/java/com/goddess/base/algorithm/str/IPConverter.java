package com.goddess.base.algorithm.str;

/**
 * IPV4 与 整数之间的转换
 * IPV6 128位
 *
 * @author qinshengke
 * @since 2021/4/6
 **/
public class IPConverter {


	public static int ip2Int(String ip) {
		if (ip == null || ip.length() == 0) return 0;
		String[] split = ip.split("\\.");
		int result = 0;

		for (int i = 0; i < split.length; i++) {
			int tmp = Integer.parseInt(split[i]) << (8 * i);
			result |= tmp;
		}
		return result;
	}


	public static String int2IP(int ipInteger) {
		if (ipInteger == -1) return "255.255.255.255";
		String[] ipStr = new String[4];
		for (int i = 0; i < 4; i++) {
			int tmp = ipInteger & (255 << (8 * i));
			int result = tmp >> 8 * i;
			ipStr[i] = String.valueOf(result);
		}
		return String.join(".", ipStr);
	}


	public static void main(String[] args) {
		int intIP = ip2Int("255.255.255.255");
		System.out.println(intIP);// 16885952
		System.out.println(int2IP(intIP));
	}


}
