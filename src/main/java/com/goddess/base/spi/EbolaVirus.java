package com.goddess.base.spi;

/**
 * 埃博拉病毒计划
 *
 * @author qinshengke
 * @since 2021/1/20
 **/
public class EbolaVirus implements HumanCleaner{
	@Override
	public Object clean() {

		System.out.println("埃博拉病毒爷爷来了");
		return "";
	}
}
