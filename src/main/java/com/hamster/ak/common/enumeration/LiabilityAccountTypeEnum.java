package com.hamster.ak.common.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author yanwenbo
 */

@Getter
@AllArgsConstructor
public enum LiabilityAccountTypeEnum {
    // 负债账户
    CREDITCARD(10, "信用卡"),
    MYHUABEI(11, "蚂蚁花呗"),
    JDBAITIAO(12, "京东白条"),
    OTHER(13, "其他");

    private Integer code;
    private String name;
}
