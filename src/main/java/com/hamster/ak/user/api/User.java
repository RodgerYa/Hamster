package com.hamster.ak.user.api;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @author yanwenbo
 */
@Data
@Builder
@ApiModel(description = "用户")
public class User {
    @ApiModelProperty(required = true, value = "用户ID")
    private Integer id;

    @ApiModelProperty(required = true, value = "用户姓名")
    private String name;

    @ApiModelProperty(required = true, value = "登录名")
    private String loginName;

    @ApiModelProperty(required = true, value = "密码（加密后）")
    private String password;

    @ApiModelProperty(required = true, value = "创建时间")
    private Date created;

    @ApiModelProperty(required = true, value = "修改时间")
    private Date modified;

    @ApiModelProperty(required = true, value = "创建人")
    private String creator;

    @ApiModelProperty(required = true, value = "修改人")
    private String modifier;
}
