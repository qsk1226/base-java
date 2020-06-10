package com.goddess.base.design_model.adapter;

/**
 * 安卓传统方式充电实现
 *
 * @author qinshengke
 * @since 2020/6/9 17:52
 **/
public class TraditionalChargeImpl implements TraditionalCharge {
	@Override
	public void chargeWithTraditional() {
		System.out.println("使用传统的安卓充电头进行充电");
	}
}
