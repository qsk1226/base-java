package com.goddess.base.design_model.factory.product;

/**
 * 英特尔cpu
 *
 * @author qinshengke
 * @since 2020/6/8 14:04
 **/
public class IntelCpu implements Cpu {
	@Override
	public long calculate() {
		return 500;
	}
}
