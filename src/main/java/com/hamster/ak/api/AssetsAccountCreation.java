package com.hamster.ak.api;

import com.hamster.ak.common.enumeration.AccountTypeEnum;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * @author yanwenbo
 */
@Data
public class AssetsAccountCreation {

    private AccountTypeEnum accountTypeEnum;
    private String accountName;
    private BigDecimal balance;
    private Optional<String> description;
}
