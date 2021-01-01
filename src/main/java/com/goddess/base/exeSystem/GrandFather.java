package com.goddess.base.exeSystem;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;

public class GrandFather {
	void thinking() {
		System.out.println("i am grandfather");
	}

	public static void main(String[] args) {
		Son son = new Son();
		son.thinking();
	}
}

class Father extends GrandFather {
	void thinking() {
		System.out.println("i am father");
	}
}

class Son extends Father {
	void thinking() {
		try {
			// 请读者在这里填入适当的代码（不能修改其他地方的代码）
			// 实现调用祖父类的thinking()方法，打印"i am grandfather"
			MethodType methodType = MethodType.methodType(void.class);
			Field lookupImpl = MethodHandles.Lookup.class.getDeclaredField("IMPL_LOOKUP");
			lookupImpl.setAccessible(true);
			MethodHandle thinking = ((MethodHandles.Lookup) lookupImpl.get(null)).findSpecial(GrandFather.class, "thinking", methodType, GrandFather.class);
			thinking.invoke(this);
		} catch (Throwable throwable) {
			throwable.printStackTrace();
		}
	}
}