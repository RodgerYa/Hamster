package com.hamster.ak.common.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author yanwenbo
 */

@Getter
@AllArgsConstructor
public enum AccountTypeEnum {

    // 资产账户
    ALIPAY(0, "支付宝"),
    VCHATPAY(1, "微信支付"),
    CHASH(2, "现金"),
    BANKCARD(3, "银行卡"),
    OTHER(4, "其他");
    // 资产账户-投资理财

    private Integer code;
    private String name;
}
