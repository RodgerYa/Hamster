package com.hamster.ak.api;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

/**
 * @author yanwenbo
 */
@Data
@Builder
@ApiModel(description = "权限")
public class Permission {
    @ApiModelProperty(required = true, value = "权限id")
    private Integer id;
    @ApiModelProperty(required = true, value = "权限名称")
    private String permissionName;
}
