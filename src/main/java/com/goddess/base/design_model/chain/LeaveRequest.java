package com.goddess.base.design_model.chain;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 请求
 *
 * @author qinshengke
 * @since 2020/6/11 15:32
 **/
@Data
@AllArgsConstructor
public class LeaveRequest {
    private String name;    // 请假人姓名
    private int numOfDays;  // 请假天数
}
