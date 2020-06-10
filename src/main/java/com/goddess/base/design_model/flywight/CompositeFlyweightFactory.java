package com.goddess.base.design_model.flywight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 复合享元工厂角色类
 * <p>
 * 享元工厂角色提供两种不同的方法，一种用于提供单纯享元对象，另一种用于提供复合享元对象。
 *
 * @author qinshengke
 * @since 2020/6/10 16:21
 **/
public class CompositeFlyweightFactory {

	private Map<Character, Flyweight> files = new HashMap<>();

	/**
	 * 复合享元工厂方法
	 */
	public Flyweight factory(List<Character> compositeState) {
		ConcreteCompositeFlyweight compositeFly = new ConcreteCompositeFlyweight();

		for (Character state : compositeState) {
			compositeFly.add(state, this.factory(state));
		}

		return compositeFly;
	}

	/**
	 * 单纯享元工厂方法
	 */
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
		List<Character> compositeState = new ArrayList<>();
		compositeState.add('a');
		compositeState.add('b');
		compositeState.add('c');
		compositeState.add('a');
		compositeState.add('b');

		CompositeFlyweightFactory flyFactory = new CompositeFlyweightFactory();
		Flyweight compositeFly1 = flyFactory.factory(compositeState);
		Flyweight compositeFly2 = flyFactory.factory(compositeState);
		compositeFly1.operation("Composite Call");

		System.out.println("---------------------------------");
		System.out.println("复合享元模式是否可以共享对象：" + (compositeFly1 == compositeFly2));

		Character state = 'a';
		Flyweight fly1 = flyFactory.factory(state);
		Flyweight fly2 = flyFactory.factory(state);
		System.out.println("单纯享元模式是否可以共享对象：" + (fly1 == fly2));
	}

}