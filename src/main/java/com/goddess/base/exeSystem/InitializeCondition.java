package com.goddess.base.exeSystem;

import java.lang.reflect.Constructor;

/**
 * 主动引用和被动引用
 *
 * @author qinshengke
 * @since 2020/4/5 11:25
 **/
public class InitializeCondition {
	public static void main(String[] args) throws Exception{
		// 被动引用，通过子类引用父类的常量，由于常量在编译之后存入到了常量池，使用的时候，实际上并没有直接引用到定义常量的类，因此不会触发定义常量的类初始化。
		// System.out.println(SubClass.v1);

		// 被动引用，通过数组定义来引用类，不会触发此类的初始化
		// SuperClass[] superClasses = new SuperClass[10];

		// 被动引用，通过子类引用父类的静态字段，不会导致子类的初始化，但会使父类初始化
		// System.out.println(SubClass.value);

		// 主动引用，使用的是子类的静态方法，需要初始化子类，初始化子类之前需要初始化父类
		// SubClass.printSubClass();ClassInit

		// 主动引用，子类初始化前 先初始化 父类
		//SubClass subClass = new SubClass();

		//主动引用，需要初始化子类，
		// Class<?> aClass = Class.forName("com.goddess.base.exeSystem.SubClass");

	}

}




