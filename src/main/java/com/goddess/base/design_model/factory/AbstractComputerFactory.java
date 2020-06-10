package com.goddess.base.design_model.factory;

import com.goddess.base.design_model.factory.product.Cpu;
import com.goddess.base.design_model.factory.product.Memory;

/**
 * 抽象工厂模式
 *
 * @author qinshengke
 * @since 2020/6/8 14:23
 **/
public abstract class AbstractComputerFactory {

	/**
	 * cpu
	 */
	public abstract Cpu createCpu();

	/**
	 * 内存条
	 */
	public abstract Memory createMemory();
}
