package com.goddess.base.annotation;

/**
 * .
 *
 * @author qinshengke
 * @since 2021/1/22
 **/
public class BleachTest {
	@Bleach(name = "yihu")
	public String sayHello(String something) {

		System.out.println(something);
		return something;
	}
}
