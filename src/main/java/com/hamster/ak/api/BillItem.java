package com.hamster.ak.api;

import com.hamster.ak.common.enumeration.CostTypeEnum;
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
@ApiModel(value = "款项")
public class BillItem {

    @ApiModelProperty(required = true, value = "款项id")
    private Integer id;

    @ApiModelProperty(required = true, value = "记账用户")
    private Integer userId;

    @ApiModelProperty(required = true, value = "创建时间")
    private Date created;

    @ApiModelProperty(required = true, value = "账户id")
    private Integer accountId;

    @ApiModelProperty(required = true, value = "资产账户记账")
    private Boolean fromAssetsAccount;

    @ApiModelProperty(required = true, value = "消费类型")
    private CostTypeEnum costTypeEnum;

    @ApiModelProperty(required = true, value = "记账金额（分）")
    private Integer amount;

}
