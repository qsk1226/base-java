package com.goddess.base.spi;

/**
 * 新冠病毒计划
 *
 * @author qinshengke
 * @since 2021/1/20
 **/
public class COVID_19 implements HumanCleaner{
	@Override
	public Object clean() {

		System.out.println("新冠爷爷来了");
		return "";
	}
}
