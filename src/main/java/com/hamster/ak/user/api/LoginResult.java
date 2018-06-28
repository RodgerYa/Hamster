package com.hamster.ak.user.api;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "登录结果")
public class LoginResult {
    @ApiModelProperty(required = true, value = "用户id")
    private String userId;
    @ApiModelProperty(required = true, value = "登录名")
    private String loginName;
    @ApiModelProperty(required = true, value = "是否验证通过")
    private boolean accepted = false;
    @ApiModelProperty(required = true, value = "提示信息")
    private String message;
    @ApiModelProperty(required = true, value = "令牌")
    private String token;
}
