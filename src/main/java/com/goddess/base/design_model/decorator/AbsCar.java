package com.goddess.base.design_model.decorator;

import lombok.Data;

/**
 * 抽象车辆,组件间、装饰者、被装饰者的超类
 *
 * @author qinshengke
 * @since 2020/6/12 10:18
 **/
@Data
public abstract class AbsCar {
	/**
	 * 车辆描述
	 */
	public abstract String getDescription();

	/**
	 * 价格
	 */
	public abstract double cost();
}
