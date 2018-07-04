package com.hamster.ak.account.api;

import com.hamster.ak.common.enumeration.AccountTypeEnum;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

/**
 * @author yanwenbo
 */
public class LiabilityAccountCreation {

    private AccountTypeEnum accountTypeEnum;
    private String accountName;
    private BigDecimal lineOfCredit;
    private Date repaymentDate;
    private Date statementDate;
    private Optional<String> description;
}