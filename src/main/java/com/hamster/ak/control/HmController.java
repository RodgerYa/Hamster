package com.hamster.ak.control;

import com.hamster.ak.api.*;
import com.hamster.ak.common.bean.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;

import javax.validation.Valid;

import static com.hamster.ak.common.config.Routes.*;

@RestController
@Api(tags = "Hamster")
public class HmController {

    @Autowired
    private UserService userService;

    @Autowired
    private LiabilityAccountService liabilityAccountService;

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

    @ApiOperation(value = "负债账户-新增")
    @PostMapping(CREATE_LIABILITY_ACCOUNT)
    public JsonResult createLiabilityAccount(@RequestBody @Valid LiabilityAccountCreation creation) {
        liabilityAccountService.create(creation);
        return JsonResult.ok();
    }

    @ApiOperation(value = "负债账户-根据id查询")
    @GetMapping(GET_LIABILITY_ACCOUNT)
    public JsonResult<LiabilityAccount> getAccountById(@PathVariable("id") Integer id) {

        return JsonResult.ok(liabilityAccountService.getAccountById(id));
    }


}
