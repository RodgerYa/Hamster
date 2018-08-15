package com.hamster.ak.api;

import com.hamster.ak.common.enumeration.AccountTypeEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

/**
 * @author yanwenbo
 */
@Data
@Api("新增负债账户")
public class LiabilityAccountCreation {

    @ApiParam(value = "账户类型", required = true)
    @NotNull
    private AccountTypeEnum type;

    @ApiParam(value = "账户名称", required = true)
    @NotNull
    private String name;

    @ApiParam(value = "信用额度", required = true)
    @NotNull
    private Integer lineOfCredit;

    @ApiParam(value = "还款日", required = true)
    @NotNull
    private Integer repaymentDate;

    @ApiParam(value = "出账日", required = true)
    @NotNull
    private Integer statementDate;

    @ApiParam(value = "账户类型", required = true)
    private Optional<String> description;
}
