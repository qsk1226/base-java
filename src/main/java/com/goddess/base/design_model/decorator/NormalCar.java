package com.goddess.base.design_model.decorator;

/**
 * 普通车
 *
 * @author qinshengke
 * @since 2020/6/12 11:36
 **/
public class NormalCar extends AbsCar{

	@Override
	public String getDescription() {
		return "破车一两";
	}

	@Override
	public double cost() {
		return 100;
	}
}
