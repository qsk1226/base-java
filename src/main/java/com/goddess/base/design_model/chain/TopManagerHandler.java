package com.goddess.base.design_model.chain;

import java.util.Random;

/**
 * 总经理
 *
 * @author qinshengke
 * @since 2020/6/11 15:32
 **/
public class TopManagerHandler extends Handler {
	public TopManagerHandler(String name) {
		super(name);
	}

	public TopManagerHandler(String name, Handler nextHandler) {
		super(name, nextHandler);
	}

	@Override
	public boolean process(LeaveRequest leaveRequest) {
		boolean result = (new Random().nextInt(10)) > 3; // 随机数大于3则为批准，否则不批准
		String log = "总经理<%s> 审批 <%s> 的请假申请，请假天数： <%d> ，审批结果：<%s> ";
		System.out.println(String.format(log, this.name, leaveRequest.getName(), leaveRequest.getNumOfDays(), result ? "批准" : "不批准"));

		// 总经理不批准
		return result;// 总经理最后批准
	}
}
