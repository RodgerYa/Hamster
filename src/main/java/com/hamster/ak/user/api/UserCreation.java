package com.hamster.ak.user.api;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author yanwenbo
 */
@Data
@ApiModel(description = "创建用户")
public class UserCreation {
    @ApiModelProperty(required = true, value = "登录名")
    private String loginName;
    @ApiModelProperty(required = true, value = "用户姓名")
    private String name;
    @ApiModelProperty(required = true, value = "密码（加密后）")
    private String password;
}
