package com.hamster.ak.control;

import com.hamster.ak.api.*;
import com.hamster.ak.common.bean.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;

import javax.validation.Valid;

import static com.hamster.ak.common.config.Routes.CHANGE_PASSWORD;
import static com.hamster.ak.common.config.Routes.CREATE_USER;
import static com.hamster.ak.common.config.Routes.LOGIN;

@RestController
@Api(tags = "Hamster")
public class HmController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "新增用户")
    @PostMapping(CREATE_USER)
    public JsonResult createUser(@RequestBody @Valid UserCreation userCreation) {

        userService.create(userCreation);

        return JsonResult.ok();
    }

    @ApiOperation(value = "用户登陆")
    @PostMapping(LOGIN)
    public JsonResult<LoginResult> login(@RequestBody @Valid UserCredential credential) {

        return JsonResult.ok(userService.login(credential));
    }

    @ApiOperation(value = "修改密码")
    @PostMapping(CHANGE_PASSWORD)
    public JsonResult changePassword(@RequestBody @Valid UserChangePasswordForm form) {
        userService.changePassword(form);
        return JsonResult.ok();
    }
}
