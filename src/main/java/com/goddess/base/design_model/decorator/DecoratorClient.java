package com.goddess.base.design_model.decorator;

/**
 * 装饰者客户端
 *
 * @author qinshengke
 * @since 2020/6/12 15:14
 **/
public class DecoratorClient {
	public static void main(String[] args) {
		NormalCar normalCar = new NormalCar();
		EngineDecorator engineDecorator = new EngineDecorator(normalCar);
		OutWardDecorator outWardDecorator = new OutWardDecorator(engineDecorator);
		outWardDecorator.doSomething();

	}
}
