package com.goddess.base.algorithm.stackOrQueue;

import java.util.Queue;

/**
 * 猫狗队列
 *
 * @author qinshengke
 * @since 2021/4/6
 **/
public class CatDogQueue {

	private Queue<DogEntity> dogQueue;
	private Queue<CatEntity> catQueue;

	public CatDogQueue(Queue<DogEntity> dogQueue, Queue<CatEntity> catQueue) {
		this.dogQueue = dogQueue;
		this.catQueue = catQueue;
	}

	/**
	 * 队列中是否存在猫或狗
	 */
	public Boolean isEmpty() {
		return !dogQueue.isEmpty() || !catQueue.isEmpty();
	}

	/**
	 * 是否存在猫
	 */
	public Boolean isCatEmpty() {
		return catQueue.isEmpty();
	}

	/**
	 * 是否存在狗
	 */
	public Boolean isDogEmpty() {
		return dogQueue.isEmpty();
	}

	/**
	 * 依次弹出猫
	 */
	public Object pollCat() {
		return catQueue.poll();
	}

	/**
	 * 依次弹出狗
	 */
	public Object pollDog() {
		return dogQueue.poll();
	}

	/**
	 * 依次弹出猫或狗
	 */
	public Object pollAll() {
		CatEntity cat = catQueue.peek();
		DogEntity dog = dogQueue.peek();
		if (!catQueue.isEmpty() && !dogQueue.isEmpty()) {
			if (cat.time > dog.time) {
				return dogQueue.poll();
			} else {
				return catQueue.poll();
			}
		} else if (!catQueue.isEmpty()) {
			return catQueue.poll();
		} else if (!dogQueue.isEmpty()) {
			return dogQueue.poll();
		} else {
			return null;
		}
	}

	/**
	 * 添加猫或狗
	 */
	public Object add(Animal obj) {
		if ("猫".equals(obj.type)) {
			catQueue.add(new CatEntity(obj, System.currentTimeMillis()));
		}
		if ("狗".equals(obj.type)) {
			dogQueue.add(new DogEntity(obj, System.currentTimeMillis()));
		}
		return obj;
	}


	class Animal {
		protected String type;
	}

	class CatEntity {
		public CatEntity(Animal cat, long time) {
			this.cat = cat;
			this.time = time;
		}

		protected Animal cat;
		protected long time;
	}

	class DogEntity {
		public DogEntity(Animal dog, long time) {
			this.dog = dog;
			this.time = time;
		}

		protected Animal dog;
		protected long time;
	}
}
