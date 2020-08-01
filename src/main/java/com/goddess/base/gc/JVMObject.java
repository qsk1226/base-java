package com.goddess.base.gc;

/**
 *

 * @author qinshengke
 * @since 2020/7/19 20:21
 **/
public class JVMObject {
	public static void main(String[] args) {
		String str1 = "abc";
		String str2 = new String("abc");
		String str3 = str2.intern();
		System.out.println(str1 == str2);// false
		System.out.println(str2 == str3);//false
		System.out.println(str1 == str3);//true
		System.gc();
	}
}
