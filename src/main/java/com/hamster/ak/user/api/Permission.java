package com.hamster.ak.user.api;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author yanwenbo
 */
@Data
@ApiModel(description = "权限")
public class Permission {
    @ApiModelProperty(required = true, value = "权限id")
    private String id;
    @ApiModelProperty(required = true, value = "权限名称")
    private String permissionName;
}
