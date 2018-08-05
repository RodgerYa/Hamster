package com.hamster.ak.api;

import com.hamster.ak.common.enumeration.AccountTypeEnum;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

/**
 * @author yanwenbo
 */
@Data
public class LiabilityAccountCreation {

    private AccountTypeEnum accountTypeEnum;
    private String accountName;
    private BigDecimal lineOfCredit;
    private Date repaymentDate;
    private Date statementDate;
    private Optional<String> description;
}
