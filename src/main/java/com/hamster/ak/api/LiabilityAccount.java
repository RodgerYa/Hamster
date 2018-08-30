package com.hamster.ak.api;

import com.hamster.ak.common.enumeration.LiabilityAccountTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author yanwenbo
 */
@Data
@Builder
@ApiModel(value = "负债账户")
@NoArgsConstructor
@AllArgsConstructor
public class LiabilityAccount {

    @ApiModelProperty(required = true, value = "账户id")
    private Integer id;

    @ApiModelProperty(required = true, value = "账户名称")
    private String name;

    @ApiModelProperty(required = true, value = "用户id")
    private Integer userId;

    @ApiModelProperty(required = true, value = "账户类型")
    private LiabilityAccountTypeEnum type;

    @ApiModelProperty(required = true, value = "信用额度")
    private Integer lineOfCredit;

    @ApiModelProperty(required = true, value = "账户累计流出")
    private Integer totalCost;

    @ApiModelProperty(required = true, value = "出账日期")
    private Integer statementDate;

    @ApiModelProperty(required = true, value = "还款日期")
    private Integer repaymentDate;

    @ApiModelProperty(required = true, value = "创建时间")
    private Date created;

    @ApiModelProperty(required = true, value = "账户人")
    private String creator;

    @ApiModelProperty(required = true, value = "修改人")
    private String modifier;

    @ApiModelProperty(required = true, value = "修改时间")
    private Date modified;
}
