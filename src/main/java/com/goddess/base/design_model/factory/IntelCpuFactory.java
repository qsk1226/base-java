package com.goddess.base.design_model.factory;

import com.goddess.base.design_model.factory.product.Cpu;
import com.goddess.base.design_model.factory.product.IntelCpu;

/**
 * 工厂方法模式
 *
 * @author qinshengke
 * @since 2020/6/8 14:10
 **/
public class IntelCpuFactory implements CpuFactory {
	@Override
	public Cpu createCpu() {
		return new IntelCpu();
	}
}
