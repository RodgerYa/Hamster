package com.hamster.ak.account.api;

import com.hamster.ak.common.enumeration.AccountTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author yanwenbo
 */
@Data
@Builder
@ApiModel(value = "负债账户")
public class LiabilityAccount {

    @ApiModelProperty(required = true, value = "账户id")
    private String id;
    @ApiModelProperty(required = true, value = "账户名称")
    private String accountName;
    @ApiModelProperty(required = true, value = "账户类型")
    private AccountTypeEnum accountTypeEnum;
    @ApiModelProperty(required = true, value = "信用额度")
    private BigDecimal lineOfCredit;
    @ApiModelProperty(required = true, value = "出账日期")
    private Date statementDate;
    @ApiModelProperty(required = true, value = "还款日期")
    private Date repaymentDate;
    @ApiModelProperty(required = true, value = "创建时间")
    private Date created;
    @ApiModelProperty(required = true, value = "账户人")
    private String creator;
    @ApiModelProperty(required = true, value = "修改人")
    private String modifier;
    @ApiModelProperty(required = true, value = "修改时间")
    private Date modified;
}
