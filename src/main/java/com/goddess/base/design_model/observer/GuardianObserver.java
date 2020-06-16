package com.goddess.base.design_model.observer;

/**
 * 具体观察者
 *
 * @author qinshengke
 * @since 2020/6/12 17:46
 **/
public class GuardianObserver implements Observer {

	private String name;

	public GuardianObserver(String name) {
		this.name = name;
	}

	@Override
	public void update(String message) {
		System.out.println(name + "-" + message);
	}
}
