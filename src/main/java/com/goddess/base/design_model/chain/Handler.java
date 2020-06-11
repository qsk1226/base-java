package com.goddess.base.design_model.chain;

import lombok.Data;

/**
 * 抽象处理类
 *
 * @author qinshengke
 * @since 2020/6/11 15:21
 **/
@Data
public abstract class Handler {
	protected String name; // 处理者姓名
	protected Handler nextHandler;  // 下一个处理者

	public Handler(String name) {
		this.name = name;
	}

	public Handler(String name, Handler nextHandler) {
		this.name = name;
		this.nextHandler = nextHandler;
	}

	public abstract boolean process(LeaveRequest leaveRequest); // 处理请假
}
