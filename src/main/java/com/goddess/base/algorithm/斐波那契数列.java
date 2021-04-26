package com.goddess.base.algorithm;

import java.math.BigInteger;

/**
 * TODO
 *
 * @author qinshengke
 * @since 2021/4/25
 **/
public class 斐波那契数列 {

	public static BigInteger fib(int n) {
		BigInteger sum = BigInteger.ZERO;
		BigInteger a=BigInteger.ZERO;
		BigInteger b=BigInteger.ONE;
		for(int i = 0; i< n; i++) {
			sum= (a.add(b)).mod(BigInteger.valueOf(1000000007));
			a=b;
			b=sum;
		}
		return a;
	}

	public static BigInteger f(int n) {
		BigInteger[] tmp = new BigInteger[n+1];
		tmp[0] = BigInteger.ZERO;
		tmp[1] = BigInteger.ONE;
		for (int i = 2; i<= n; i++) {
			tmp[i] = tmp[i-1].add(tmp[i-2]);
		}
		return tmp[n];
	}


	public static void main(String[] args) {
		System.out.println(fib(10000000));
	}

}
