package com.hamster.ak.common.exception;

import com.hamster.ak.common.bean.ResultBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理
 *
 * @author yanwenbo
 *
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    ResultBean<Void> handleException(Exception e) {
        log.error(e.getMessage(), e);

        return ResultBean.systemError();
    }

    @ExceptionHandler(HmException.class)
    @ResponseBody
    ResultBean<Void> handleHmException(HmException e) {
        log.error(e.getMessage(), e);

        return ResultBean.fail(e.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    ResultBean<Void> handleIllegalArgumentException(IllegalArgumentException e) {
        log.error(e.getMessage(), e);

        return ResultBean.fail(e.getMessage());
    }

}

