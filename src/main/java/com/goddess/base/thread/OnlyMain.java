package com.goddess.base.thread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * 管理线程
 *
 * @author qinshengke
 * @since 2020/3/28 10:46
 **/
public class OnlyMain {

	public static void main(String[] args) {

		// Java虚拟机线程系统的管理接口
		ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
		ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);

		for (ThreadInfo threadInfo : threadInfos) {
			System.out.println(threadInfo.getThreadName() + "---" + threadInfo.getThreadId());
		}
	}
}
