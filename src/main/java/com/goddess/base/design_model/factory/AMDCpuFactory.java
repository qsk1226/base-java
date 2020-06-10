package com.goddess.base.design_model.factory;

import com.goddess.base.design_model.factory.product.AMDCpu;
import com.goddess.base.design_model.factory.product.Cpu;

/**
 * 工厂方法模式
 *
 * @author qinshengke
 * @since 2020/6/8 14:11
 **/
public class AMDCpuFactory implements CpuFactory {
	@Override
	public Cpu createCpu() {
		return new AMDCpu();
	}
}
