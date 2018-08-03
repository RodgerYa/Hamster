package com.hamster.ak.common.bean;

import com.hamster.ak.common.config.ModelConstant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.Optional;

/**
 * @author yanwenbo
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JsonResult<T> {

    private Integer code;
    private String message;
    private Optional<T> data = Optional.empty();

    public static JsonResult systemError() {
        return JsonResult.builder()
                .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message(ModelConstant.SYSTEM_ERROR_MSG)
                .build();
    }


    public static JsonResult fail(String msg) {
        return JsonResult.builder()
                .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message(msg)
                .build();
    }

    public static JsonResult ok() {
        return JsonResult.builder()
                .code(HttpStatus.OK.value())
                .message(ModelConstant.REQUEST_SUCCESS_MSG)
                .build();
    }

    public static <T> JsonResult<T> ok(T data) {
        JsonResult<T> result = new JsonResult<>();
        result.setCode(HttpStatus.OK.value());
        result.setMessage(ModelConstant.REQUEST_SUCCESS_MSG);
        result.setData(Optional.of(data));
        return result;
    }
}
