package com.goddess.base.concurrent.pattern;

/**
 * 无状态的类，即使使用 UserVo
 */
public class StatelessClass {
	public int service(int a,int b){

	    return a+b;
    }

    public void serviceUser(UserVo user) {
        //do sth user
    }


}
