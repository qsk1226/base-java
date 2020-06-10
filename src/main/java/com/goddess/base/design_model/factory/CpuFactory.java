package com.goddess.base.design_model.factory;

import com.goddess.base.design_model.factory.product.Cpu;

/**
 * 工厂方法模式
 *
 * @author qinshengke
 * @since 2020/6/8 14:10
 **/
public interface CpuFactory {
	Cpu createCpu();
}

