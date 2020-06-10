package com.goddess.base.gc;

/**
 * 引用计数器方式无法解决相互引用的问题
 *
 * @author qinshengke
 * @since 2020/1/9
 */
public class ReferenceCountingGC {

	public Object instance = null;

	private static final int _1MB = 1024 * 1024;

	private byte[] bigSize = new byte[6 * _1MB];

	public static void testGC() throws Throwable {
		ReferenceCountingGC objA = new ReferenceCountingGC();
		ReferenceCountingGC objB = new ReferenceCountingGC();
		objA.instance = objB;
		objB.instance = objA;

		objA = null;
		objB = null;

		//System.gc();
	}


	public static void main(String[] args) {
		try {
			testGC();
		} catch (Throwable throwable) {
			throwable.printStackTrace();
		}
	}
}
