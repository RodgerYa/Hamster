package com.hamster.ak.common.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author yanwenbo
 */

@Getter
@AllArgsConstructor
public enum AccountPeriodEnum {

    DAYBILL(0, "日账单"),
    WEEKBILL(1, "周账单"),
    MONTHBILL(2, "月账单"),
    YEARBILL(3, "年账单");

    private Integer code;
    private String name;
}
