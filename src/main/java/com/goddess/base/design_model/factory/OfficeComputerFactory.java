package com.goddess.base.design_model.factory;

import com.goddess.base.design_model.factory.product.Cpu;
import com.goddess.base.design_model.factory.product.IntelCpu;
import com.goddess.base.design_model.factory.product.KingstonMemory;
import com.goddess.base.design_model.factory.product.Memory;

/**
 * 办公电脑-抽象工厂
 *
 * @author qinshengke
 * @since 2020/6/8 15:28
 **/
public class OfficeComputerFactory extends AbstractComputerFactory {
	@Override
	public Cpu createCpu() {
		return new IntelCpu();
	}

	@Override
	public Memory createMemory() {
		return new KingstonMemory();
	}
}
