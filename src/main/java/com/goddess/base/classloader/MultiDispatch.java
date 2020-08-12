package com.goddess.base.classloader;

import com.sun.corba.se.impl.presentation.rmi.StubFactoryStaticImpl;

/**
 * 多分派/单分派
 *
 * @author qinshengke
 * @since 2020/8/9 21:37
 **/
public class MultiDispatch {

	static class QQ {
	}

	static class _360 {
	}

	public static class Father {
		public void hardChoice(QQ arg) {
			System.out.println("father choose qq");
		}

		public void hardChoice(_360 arg) {
			System.out.println("father choose 360");
		}
	}

	public static class Son extends Father {
		public void hardChoice(QQ arg) {
			System.out.println("son choose qq");
		}

		public void hardChoice(_360 arg) {
			System.out.println("son choose 360");
		}
	}

	public static void main(String[] args) {
		Father father = new Father();
		Father son = new Son();
		father.hardChoice(new _360());
		son.hardChoice(new QQ());
	}
}