package com.hamster.ak.api;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author yanwenbo
 */
@Data
@ApiModel(description = "创建用户")
public class UserCreation {
    @ApiModelProperty(required = true, value = "登录名")
    @NotEmpty
    private String loginName;

    @ApiModelProperty(required = true, value = "用户姓名")
    @NotEmpty
    private String name;

    @ApiModelProperty(required = true, value = "密码（加密后）")
    @NotEmpty
    private String password;
}
