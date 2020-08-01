package com.goddess.base.gc;

/**
 * 局部变量表的复用引起的GC问题
 * -XX:-UseCompressedOops -XX:+UseConcMarkSweepGC
 * <p>
 * java -cp .\sa-jdi.jar sun.jvm.hotspot.HSDB
 *
 * @author qinshengke
 * @since 2020/7/19 20:21
 **/
public class JVMShouldAssignNull {
	public static void main(String[] args) {
		/*// bytes数组内存没有被回收
		byte[] bytes = new byte[1024 * 1024 * 64];
		System.gc();
*/
		// bytes数组内存没有被回收
		/*{
			byte[] bytes1 = new byte[1024 * 1024 * 64];
		}
		System.gc();*/

		{
			byte[] bytes2 = new byte[1024 * 1024 * 64];
			bytes2 = null;
		}

		System.gc();

	}
}
