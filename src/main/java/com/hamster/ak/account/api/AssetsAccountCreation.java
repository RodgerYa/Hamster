package com.hamster.ak.account.api;

import com.hamster.ak.common.enumeration.AccountTypeEnum;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * @author yanwenbo
 */
public class AssetsAccountCreation {

    private AccountTypeEnum accountTypeEnum;
    private String accountName;
    private BigDecimal balance;
    private Optional<String> description;
}
