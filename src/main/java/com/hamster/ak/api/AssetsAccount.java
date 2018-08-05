package com.hamster.ak.api;

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
@ApiModel(value = "资产账户")
public class AssetsAccount {

    @ApiModelProperty(required = true, value = "账户id")
    private String id;
    @ApiModelProperty(required = true, value = "账户名称")
    private String name;
    @ApiModelProperty(required = true, value = "账户类型")
    private AccountTypeEnum accountTypeEnum;
    @ApiModelProperty(required = true, value = "账户余额")
    private Integer balance;
    @ApiModelProperty(required = true, value = "创建时间")
    private Date created;
    @ApiModelProperty(required = true, value = "账户人")
    private String creator;
    @ApiModelProperty(required = true, value = "修改人")
    private String modifier;
    @ApiModelProperty(required = true, value = "修改时间")
    private Date modified;

}
