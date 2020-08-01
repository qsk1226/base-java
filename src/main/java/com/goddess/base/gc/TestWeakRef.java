package com.goddess.base.gc;

import lombok.Data;

import java.lang.ref.WeakReference;

/**
 * 弱引用示例
 * -XX:+PrintGCDetails -XX:+PrintGC -Xms20m -Xmx20m
 *
 * @author qinshengke
 * @since 2020/8/2 00:46
 **/
public class TestWeakRef {
	@Data
	public static class User {
		public int id = 0;
		public String name = "";

		public User(int id, String name) {
			super();
			this.id = id;
			this.name = name;
		}

		@Override
		public String toString() {
			return "User [id=" + id + ", name=" + name + "]";
		}

	}

	public static void main(String[] args) {
		User u = new User(1, "King");
		WeakReference<User> userWeak = new WeakReference<User>(u);
		u = null;//干掉强引用，确保这个实例只有userWeak的弱引用
		System.out.println(userWeak.get());
		System.gc();//进行一次GC垃圾回收,千万不要写在业务代码中。
		System.out.println("After gc");
		System.out.println(userWeak.get());
	}
}