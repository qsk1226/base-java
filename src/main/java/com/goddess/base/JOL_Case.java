package com.goddess.base;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;


/**
 * 查看jdk中对象的信息
 *
 * @author qinshengke
 * @since 2020/4/15 22:10
 **/
public class JOL_Case {
	public static void main(String[] args) throws InterruptedException {
		Object a = new Object();
		System.out.println("Object 对象:");
		//查看对象内部信息
		System.out.println(ClassLayout.parseInstance(a).toPrintable());

		//查看对象外部信息
		System.out.println(GraphLayout.parseInstance(a).toPrintable());

		//获取对象总大小
		System.out.println("size : " + GraphLayout.parseInstance(a).totalSize());


		ObjInfo objInfo = new ObjInfo();
		System.out.println(ClassLayout.parseInstance(objInfo).toPrintable());
		//获取对象总大小
		System.out.println(GraphLayout.parseInstance(objInfo));
		System.out.println("size : " + GraphLayout.parseInstance(objInfo).totalSize());

		ObjInfo[] arr = new ObjInfo[5];
		System.out.println(ClassLayout.parseInstance(arr).toPrintable());

	}


	static class ObjInfo {
		private boolean _boolean;
		private byte _byte;
		private short _short;
		private char _char;
		private int _int;
		private float _float;
		private double _double;
		private long _long;

		private String _string;

		private Integer _integer;
		private Integer[] integers;

		private ObjRef objRef;
		private ObjRef[] objRefs;
	}

	class ObjRef {
		private String ref;
	}

}
