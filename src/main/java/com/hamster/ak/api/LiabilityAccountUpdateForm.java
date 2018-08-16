package com.hamster.ak.api;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@Data
@Builder
@ApiModel(value = "负债账户-更新Form")
public class LiabilityAccountUpdateForm {

    @ApiModelProperty(required = true, value = "原来账户名称")
    @NotNull
    private String oldName;

    @ApiModelProperty(value = "新账户名称")
    private Optional<String> newName = Optional.empty();

    @ApiModelProperty(value = "信用额度")
    private Optional<Integer> lineOfCredit = Optional.empty();

    @ApiModelProperty(value = "出账日期")
    private Optional<Integer> statementDate = Optional.empty();

    @ApiModelProperty(value = "还款日期")
    private Optional<Integer> repaymentDate = Optional.empty();

}
