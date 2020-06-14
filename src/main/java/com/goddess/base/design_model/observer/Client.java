package com.goddess.base.design_model.observer;

/**
 * 观察者模式客户端
 *
 * @author qinshengke
 * @since 2020/6/14 10:41
 **/
public class Client {

	public static void main(String[] args) {
		SubscriptionSubject mSubscriptionSubject = new SubscriptionSubject();
		//创建监护人
		GuardianObserver user1 = new GuardianObserver("孩儿他爹");
		GuardianObserver user2 = new GuardianObserver("孩儿他娘");
		// 添加监护
		mSubscriptionSubject.addObserver(user1);
		mSubscriptionSubject.addObserver(user2);
		// 通知打架的通知
		mSubscriptionSubject.notifyObserver("孩儿又在学校打架了");
	}
}
