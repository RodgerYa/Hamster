package com.hamster.ak.common.control;

import com.hamster.ak.common.bean.ResultBean;
import com.hamster.ak.user.api.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "用户")
@RestController
public class HmController {

    @ApiOperation(value = "获取用户列表")
    @GetMapping(value = "/user/getUsers")
    public ResultBean<User> getUsers(){
        return ResultBean.fail("fail");
    }
}
