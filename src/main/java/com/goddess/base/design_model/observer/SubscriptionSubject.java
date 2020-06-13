package com.goddess.base.design_model.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体的被观察者
 *
 * @author qinshengke
 * @since 2020/6/12 17:47
 **/
public class SubscriptionSubject implements Subject {
	//
	private List<Observer> guardianObserver = new ArrayList<>();

	@Override
	public void addObserver(Observer observer) {
		guardianObserver.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		guardianObserver.remove(observer);
	}

	@Override
	public void notifyObserver(String message) {
		for (Observer observer : guardianObserver) {
			observer.update(message);
		}
	}
}