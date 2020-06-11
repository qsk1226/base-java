package com.goddess.base.design_model.chain;

/**
 * 责任链客户端
 *
 * @author qinshengke
 * @since 2020/6/11 15:33
 **/
public class ChainClient {
	public static void main(String[] args) {
		Handler topManagerHandler = new TopManagerHandler("狗蛋");
		Handler managerHandler = new ManagerHandler("饭桶", topManagerHandler);
		Handler directorHandler = new DirectorHandler("事妈", managerHandler);

		directorHandler.process(new LeaveRequest("窦娥", 3));
	}

}
