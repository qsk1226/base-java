package com.goddess.base.design_model.flywight;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元工厂角色类
 * <p>
 * 必须指出的是，客户端不可以直接将具体享元类实例化，而必须通过一个工厂对象，利用一个factory()方法得到享元对象。
 * 一般而言，享元工厂对象在整个系统中只有一个，因此也可以使用单例模式。
 * 当客户端需要单纯享元对象的时候，需要调用享元工厂的factory()方法，并传入所需的单纯享元对象的内蕴状态，由工厂方法产生所需要的享元对象。
 *
 * @author qinshengke
 * @since 2020/6/10 16:01
 **/
public class FlyweightFactory {
	private Map<Character, Flyweight> files = new HashMap<>();

	public Flyweight factory(Character state) {
		//先从缓存中查找对象
		Flyweight fly = files.get(state);
		if (fly == null) {
			//如果对象不存在则创建一个新的Flyweight对象
			fly = new ConcreteFlyweight(state);
			//把这个新的Flyweight对象添加到缓存中
			files.put(state, fly);
		}
		return fly;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FlyweightFactory factory = new FlyweightFactory();
		Flyweight fly = factory.factory('a');
		fly.operation("First Call");

		fly = factory.factory('b');
		fly.operation("Second Call");

		fly = factory.factory('a');
		fly.operation("Third Call");
	}

}