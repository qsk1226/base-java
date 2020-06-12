package com.goddess.base.design_model.decorator;

/**
 * 外观装饰
 *
 * @author qinshengke
 * @since 2020/6/12 15:07
 **/
public class OutWardDecorator extends AbsDecorator {
	public OutWardDecorator(AbsCar absCar) {
		super(absCar);
	}

	@Override
	public String getDescription() {
		return super.getDescription() +" 重新喷漆";
	}

	@Override
	public double cost() {
		return super.cost()+10000;
	}

	@Override
	protected void doSomething() {
		System.out.println(getDescription());
	}
}
