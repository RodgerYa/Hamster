package com.hamster.ak.account.api;

import com.hamster.ak.common.enumeration.CostTypeEnum;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author yanwenbo
 */
@Data
public class BillItemCreation {
    /**
     * 收入 or 支出
     */
    private Boolean isIncome;
    private String userId;
    private Boolean fromAssetsAccount;
    private String accountId;
    private CostTypeEnum costTypeEnum;
    private BigDecimal amount;
    private Date created;
    private String description;

}
