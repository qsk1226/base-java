package com.goddess.base.gc;

import com.goddess.base.Employee;

import java.lang.ref.SoftReference;

/**
 * TODO
 *
 * @author qinshengke
 * @since 2020/7/31 16:39
 **/
public class SoftReferenceMock {
	public static void main(String[] args) {
		Employee aRef = new Employee();
		SoftReference aSoftRef = new SoftReference(aRef);

		Employee o =(Employee) aSoftRef.get();



	}
}
