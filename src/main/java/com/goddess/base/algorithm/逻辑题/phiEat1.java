package com.goddess.base.algorithm.逻辑题;

/**
 * 银行家吃饭问题
 * 如果不加num<4，synchronized(left)后，如果另一个哲学家进程拿了right的筷子，
 * 另一个哲学家又拿了这个哲学家右边的筷子...依此类推，产生循环等待链，即产生死锁。就会产生死锁。
 * <p>
 * 我们标记3个结点去分析各个代码块进入的最多线程数。
 * <p>
 * 2.加了num<4这个条件后，可能会有5个线程，同时满足if判断语句(结点1)；
 * 而又因为synchronized了一个筷子(left)，所以最多有4个进程进入了synchronized(left){}代码块钟，
 * 执行了num++，(结点2)，那么虽然此时可能有5个进程进入了if(num<4)语句，但是第5个进程也会被阻挡在synchronized外面。
 * 在synchronized(right)后，最多有2个进程去吃东西(结点3),因为只有5个筷子，
 * 同时只能让两个人去吃，其它3个人等待，看图比较容易明白。
 *
 * @author qinshengke
 * @since 2022/5/16
 **/
public class phiEat1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object[] chObject = new Object[5];
		//object必须要初始化一下呀
		for (int i = 0; i < 5; i++) {
			chObject[i] = i;
		}

		//5个哲学家
		PhiPerson1 firThread = new PhiPerson1(0, chObject);
		PhiPerson1 secThread = new PhiPerson1(1, chObject);
		PhiPerson1 thirThread = new PhiPerson1(2, chObject);
		PhiPerson1 fourThread = new PhiPerson1(3, chObject);
		PhiPerson1 fifThread = new PhiPerson1(4, chObject);

		//开吃了
		new Thread(firThread).start();
		new Thread(secThread).start();
		new Thread(thirThread).start();
		new Thread(fourThread).start();
		new Thread(fifThread).start();
	}

}

/**
 * 实现Runnable接口
 *
 * @author qinshengke
 * @since 2022/5/16
 **/
class PhiPerson1 implements Runnable {

	// 全部使用static关键字 静态成员属于整个类，当系统第一次使用该类时，就会为其分配内存空间直到该类被卸载才会进行资源回收
	// 为什么用static修饰 因为多线程多个哲学家需要共享筷子这个对象
	// static关键字修饰的变量 该类所有的对象共享同一个成员
	Object[] chops;
	// 同时拿左手边筷子的人数 也是全局变量
	static int Num = 0;
	// 当前哲学家的编号 私有变量
	private int pos;

	public PhiPerson1(int position, Object[] chops) { //构造函数
		// TODO Auto-generated constructor stub
		this.chops = chops;
		this.pos = position;
	}

	@Override
	public void run() { //重写run方法
		// TODO Auto-generated method stub
		while (true) {
			//我右边筷子在数组中的下标
			int right = (pos + 1) % 5;
			//左边筷子在数组中的下标
			int left = (pos) % 5;
			//最多允许4个人同时拿左手边的筷子
			if (Num < 4) {
				//结点1：5个进程都有可能进入这个地方，锁 左手边的筷子 就是等待左边的人用我左手边的筷子吃完了后我再拿来吃。。
				synchronized (chops[left]) {
					Num++;//同时拿左手边筷子的人的数量+1 //这里没有锁住num，有可能会使得在没有num++时，5个进程都进来，
					//结点2：最多4个进程进到这个地方，因为synchronized (chops[left])后，需要left筷子的另1个进程要在外面等待
					System.out.println(Num);
					System.out.println("第" + (pos + 1) + "个哲学家拿了左手边的筷子");
					//右手边的筷子 锁  就是等待右手边的筷子没人拿了我再拿
					synchronized (chops[right]) {
						//结点3：最多有2个进程进入到这个地方，因为只有5个筷子，所以最多两个人同时拿。
						System.out.println("第" + (pos + 1) + "个哲学家拿了右手边的筷子");
						System.out.println("第" + (pos + 1) + "个哲学家正在eating");
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println("第" + (pos + 1) + "个哲学家吃完了，把筷子放回了原处，开始thinking");
						Num--;//同时拿左手边筷子的人的数量-1
					}
				}

			}
		}
	}
}
