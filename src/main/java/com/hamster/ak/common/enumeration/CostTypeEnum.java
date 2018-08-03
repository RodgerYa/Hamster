package com.hamster.ak.common.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CostTypeEnum {

    FOOD(0, "餐饮"),
    TRAFFIC(1, "交通"),
    BUY(2, "购物"),
    LIVE(3, "居住"),
    ENTERTAINMENT(4, "娱乐"),
    MEDICAL(5, "医疗"),
    EDUCATION(6, "教育"),
    OTHER(7, "其他");

    private Integer code;
    private String name;

}
