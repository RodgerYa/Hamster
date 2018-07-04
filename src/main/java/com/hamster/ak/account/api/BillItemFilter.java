package com.hamster.ak.account.api;

import com.hamster.ak.common.enumeration.AccountPeriodEnum;
import com.hamster.ak.common.enumeration.CostTypeEnum;

import java.util.Date;
import java.util.Optional;

/**
 * @author yanwenbo
 */
public class BillItemFilter {

    private Optional<AccountPeriodEnum> period;
    private Optional<Date> created;
    private Boolean assetsAccount;
    private Optional<String> accountId;
    private Optional<CostTypeEnum> costType;
}
