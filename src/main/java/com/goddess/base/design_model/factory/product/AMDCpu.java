package com.goddess.base.design_model.factory.product;

/**
 * AMD 品牌 Cpu
 *
 * @author qinshengke
 * @since 2020/6/8 14:02
 **/
public class AMDCpu implements Cpu {
	@Override
	public long calculate() {
		System.out.println("飞机以300公里每小时速度前进");
		return 300;
	}
}
