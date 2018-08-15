package com.hamster.ak.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Api("修改密码表单")
@Data
public class UserChangePasswordForm {

    @NotNull
    @ApiParam("用户id")
    private Integer userId;

    @NotEmpty
    @ApiParam("原密码")
    private String oldPassword;

    @NotEmpty
    @ApiParam("新密码")
    private String newPassword;
}
