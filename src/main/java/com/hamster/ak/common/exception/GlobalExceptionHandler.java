package com.hamster.ak.common.exception;

import com.hamster.ak.common.bean.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理
 *
 * @author yanwenbo
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    JsonResult handleException(Exception e) {

        log.error(e.getMessage(), e);

        if (e instanceof HmException) {
            // 这里捕获到的都是业务异常， 可以进行详细异常分析，以及分类处理操作
            return JsonResult.fail(e.getMessage());
        } else {
            // 其他异常直接抛出
            return JsonResult.systemError();
        }
    }
}

