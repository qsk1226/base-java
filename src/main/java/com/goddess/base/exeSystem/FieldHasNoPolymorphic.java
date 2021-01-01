package com.goddess.base.exeSystem;

/**
 * java 分派机制演示
 *
 * @author qinshengke
 * @since 2020/4/6 13:40
 **/
public class FieldHasNoPolymorphic {
	static class BigBrother {
		public int money = 1;

		public BigBrother() {
			money = 2;
			showMeTheMoney();
		}

		public void showMeTheMoney() {
			System.out.println("BigBrother had ￥" + money);
		}
	}


	static class LittleBrother extends BigBrother {
		public int money = 3;

		public LittleBrother() {
			money = 4;
			showMeTheMoney();
		}

		public void showMeTheMoney() {
			System.out.println("LittleBrother had ￥" + money);
		}
	}

	public static void main(String[] args) {
		BigBrother brother = new LittleBrother();
		System.out.println("brother had ￥" + brother.money);
	}
}

//LittleBrother had ￥0
//LittleBrother had ￥4
//brother had ￥2