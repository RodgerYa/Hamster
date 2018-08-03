package com.hamster.ak.common.handler;

import com.hamster.ak.common.bean.JsonResult;
import com.hamster.ak.common.exception.HmException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.springframework.http.HttpHeaders.CACHE_CONTROL;

/**
 * 统一异常处理
 *
 * @author yanwenbo
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public JsonResult handleException(HttpServletRequest request,
                                      HttpServletResponse response,
                                      Throwable throwable) {

        response.setHeader(CACHE_CONTROL, "no-store");

        Throwable rootError = getRootError(throwable);

        String rootCauseMessage = ExceptionUtils.getRootCauseMessage(rootError);
        if (StringUtils.containsIgnoreCase(rootCauseMessage, "Broken pipe")
                || StringUtils.containsIgnoreCase(rootCauseMessage, "Connection reset by peer")) {
            // 客户端连接已断开，无法返回内容
            return null;
        } else {
            log.error("Exception occurred: " + throwable.getMessage()
                    + ". [URL=" + request.getRequestURI() + "]", rootError);
        }

        log.error(throwable.getMessage(), throwable);

        JsonResult result;
        if (throwable instanceof HmException) {
            // 这里捕获到的都是自己封装好的业务异常， 可以进行详细异常分析，以及分类处理操作
            result = JsonResult.fail(throwable.getMessage());
        } else if (throwable instanceof MethodArgumentNotValidException) {
            // 一般都是参数校验异常 也可能是服务内部的异常
            result = JsonResult.systemError();
        } else {
            // 其他异常
            result = JsonResult.systemError();
        }
        return result;
    }

    private Throwable getRootError(Throwable throwable) {
        while (throwable.getCause() != null) {
            throwable = throwable.getCause();
        }
        return throwable;
    }
}

