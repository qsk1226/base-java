package com.goddess.base.blocking;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * 延迟队列对象
 *
 * @author qinshengke
 * @since 2020/6/22 21:57
 **/
public class DelayedItem<T> implements Delayed {
	/**
	 * 到期时间,但传入的数值代表过期的时长，传入单位毫秒
	 */
	private long activeTime;
	/**
	 * 业务数据，泛型
	 */
	private T data;

	/**
	 * 传入过期时长,单位秒，内部转换
	 */
	public DelayedItem(long expirationTime, T data) {
		this.activeTime = expirationTime * 1000 + System.currentTimeMillis();
		this.data = data;
	}

	public long getActiveTime() {
		return activeTime;
	}

	public T getData() {
		return data;
	}

	/**
	 * 这个方法返回到激活日期的剩余时间，时间单位由单位参数指定。
	 */
	@Override
	public long getDelay(TimeUnit unit) {
		return unit.convert(activeTime - System.currentTimeMillis(), unit);
	}

	/**
	 * Delayed接口继承了Comparable接口，按剩余时间排序，实际计算考虑精度为纳秒数
	 */
	@Override
	public int compareTo(Delayed o) {
		long d = (getDelay(TimeUnit.MILLISECONDS) - o.getDelay(TimeUnit.MILLISECONDS));
		if (d == 0) {
			return 0;
		} else {
			if (d < 0) {
				return -1;
			} else {
				return 1;
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		DelayQueue<DelayedItem> queue = new DelayQueue<>();

		queue.offer(new DelayedItem<>(10, 20));
		queue.offer(new DelayedItem<>(10, 30));
		while (!queue.isEmpty()) {
			System.out.println("111");
			System.out.println(queue.take());
		}
	}
}
