package com.goddess.base.algorithm;

public class LoopQueue {
	int front;

	int rear;

	int maxSize;

	Object queueList[];

//初始化队列

	public LoopQueue() {
		maxSize = 1024;

		queueList = new Object[maxSize];

		rear = 0;

		front = 0;

	}

//初始化队列

	public LoopQueue(int maxSize) {
		this.maxSize = maxSize;

		queueList = new Object[maxSize];

		rear = 0;

		front = 0;

	}

//判断队列是否为空

	public boolean isEmpty() {
		return this.front == this.rear ? true : false;

	}

//判断队列是否已满

	public boolean isFull() {
		return ((rear + 1) % this.maxSize) == this.front ? true : false;

	}

//取循环队列的对头元素

	public Object getFront() {
		if (isEmpty() == false) return queueList[this.front];

		else {
			System.out.println("ERROR:Queue is Empty");

			return "";

		}

	}

//入队

	public void enQueue(Object e) {
		if (isFull() == false) {
			this.queueList[this.rear] = e;

			this.rear = (this.rear + 1) % this.maxSize;

		} else System.out.println("ERROR::Queue is Full");

	}

//出队

	public void deQueue() {
		if (isEmpty() == false) {
			this.front = (this.front + 1) % this.maxSize;

		} else System.out.println("ERROR::Queue is empty");

	}

//获取队列长度

	public int QueueLength() {
		return (this.rear - this.front + this.maxSize) % this.maxSize;

	}

	public static void main(String[] args) {
		LoopQueue q = new LoopQueue();

		System.out.println("队列是否为空：" + q.isEmpty());

		System.out.println("队列是否为满：" + q.isFull());

		System.out.println("队列长度:" + q.QueueLength());

		q.enQueue(5);

		q.enQueue(4);

		q.enQueue(3);

		q.enQueue(2);

		q.enQueue(1);

		System.out.println("队列长度:" + q.QueueLength());

		q.deQueue();

		System.out.println("队列是否为空：" + q.isEmpty());

		System.out.println("对头元素:" + q.getFront());

		System.out.println("队列长度:" + q.QueueLength());

	}

}