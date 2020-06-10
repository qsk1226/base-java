package com.goddess.base.design_model.factory;

import com.goddess.base.design_model.factory.product.AMDCpu;
import com.goddess.base.design_model.factory.product.Cpu;
import com.goddess.base.design_model.factory.product.Memory;
import com.goddess.base.design_model.factory.product.SamsungMemory;

/**
 * 游戏电脑抽象工厂模式
 *
 * @author qinshengke
 * @since 2020/6/8 14:27
 **/
public class GameComputerFactory extends AbstractComputerFactory {

	@Override
	public Cpu createCpu() {
		return new AMDCpu();
	}

	@Override
	public Memory createMemory() {
		return new SamsungMemory();
	}
}
