package com.hamster.ak.api;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author yanwenbo
 */
@Data
@Builder
@ApiModel("登录凭证")
public class UserCredential {

    @ApiModelProperty(required = true, value = "登录名")
    @NotEmpty
    private String loginName;

    @ApiModelProperty(required = true, value = "密码（加密后）")
    @NotEmpty
    private String password;
}
