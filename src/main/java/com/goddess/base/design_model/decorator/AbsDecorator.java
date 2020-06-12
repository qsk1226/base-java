package com.goddess.base.design_model.decorator;

/**
 * 抽象装饰
 *
 * @author qinshengke
 * @since 2020/6/12 14:36
 **/
public abstract class AbsDecorator extends AbsCar {

	private AbsCar absCar;

	public AbsDecorator(AbsCar absCar) {
		this.absCar = absCar;
	}

	@Override
	public String getDescription() {
		return this.absCar.getDescription();
	}

	@Override
	public double cost() {
		return this.absCar.cost();
	}

	protected abstract void doSomething();

}
