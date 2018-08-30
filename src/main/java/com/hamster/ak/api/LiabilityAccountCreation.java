package com.hamster.ak.api;

import com.hamster.ak.common.enumeration.LiabilityAccountTypeEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Optional;

/**
 * @author yanwenbo
 */
@Data
@Api("新增负债账户")
public class LiabilityAccountCreation {

    @ApiParam(value = "账户类型", required = true)
    @NotNull
    private LiabilityAccountTypeEnum type;

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

    @ApiParam(value = "账户描述", required = true)
    private Optional<String> description = Optional.empty();
}
