package com.goddess.base.design_model.adapter;

/**
 * 对象适配器
 *
 * @author qinshengke
 * @since 2020/6/9 17:53
 **/
public class ChargeAdapter implements TypeCCharge {
	/**
	 * 被适配对象
	 */
	private TraditionalCharge traditionalCharge;

	public ChargeAdapter(TraditionalCharge traditionalCharge) {
		this.traditionalCharge = traditionalCharge;
	}

	@Override
	public void chargeWithTypeC() {
		System.out.println("使用Type-C 转接头适配安卓传统充电器");
		traditionalCharge.chargeWithTraditional();
	}

	public static void main(String[] args) {
		ChargeAdapter chargeAdapter = new ChargeAdapter(new TraditionalChargeImpl());
		chargeAdapter.chargeWithTypeC();
	}
}
