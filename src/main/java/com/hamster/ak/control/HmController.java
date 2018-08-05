package com.hamster.ak.control;

import com.hamster.ak.common.bean.JsonResult;
import com.hamster.ak.api.LoginResult;
import com.hamster.ak.api.UserCreation;
import com.hamster.ak.api.UserCredential;
import com.hamster.ak.api.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.hamster.ak.common.config.Routes.CREATE_USER;
import static com.hamster.ak.common.config.Routes.LOGIN;

@RestController
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
    @GetMapping(LOGIN)
    public JsonResult<LoginResult> login(@ModelAttribute @Valid UserCredential credential) {

        return JsonResult.ok(userService.login(credential));
    }
}
