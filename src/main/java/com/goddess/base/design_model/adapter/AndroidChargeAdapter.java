package com.goddess.base.design_model.adapter;

/**
 * 类适配器
 *
 * @author qinshengke
 * @since 2020/6/9 20:31
 **/
public class AndroidChargeAdapter extends TraditionalChargeImpl implements TypeCCharge{

	@Override
	public void chargeWithTypeC() {
		System.out.println("使用Type-C 转接头适配安卓传统充电器");
		chargeWithTraditional();
	}

	public static void main(String[] args) {
		AndroidChargeAdapter androidChargeAdapter = new AndroidChargeAdapter();
		androidChargeAdapter.chargeWithTypeC();
	}
}
