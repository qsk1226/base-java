package com.goddess.base.design_model.decorator;

/**
 * 发动机装饰
 *
 * @author qinshengke
 * @since 2020/6/12 14:39
 **/
public class EngineDecorator extends AbsDecorator {

	public EngineDecorator(AbsCar absCar) {
		super(absCar);
	}

	@Override
	protected void doSomething() {
		System.out.println(getDescription());
	}

	@Override
	public String getDescription() {
		return super.getDescription() +" 更换V8发动机";
	}

	@Override
	public double cost() {
		return super.cost()+ 100000;
	}
}
