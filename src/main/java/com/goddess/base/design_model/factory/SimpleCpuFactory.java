package com.goddess.base.design_model.factory;

import com.goddess.base.design_model.factory.product.Cpu;
import com.goddess.base.design_model.factory.product.IntelCpu;

/**
 * 简单工厂
 *
 * @author qinshengke
 * @since 2020/6/8 14:05
 **/
public class SimpleCpuFactory {

	public static Cpu createCpu() {
		return new IntelCpu();
	}
}
