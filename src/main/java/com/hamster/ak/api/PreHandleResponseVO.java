package com.hamster.ak.api;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Builder;
import lombok.Data;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.boot.json.JsonParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.json.Jackson2ObjectMapperFactoryBean;
import springfox.documentation.spring.web.ObjectMapperConfigurer;
import springfox.documentation.spring.web.json.Json;

import java.util.Optional;

@Data
@Builder
public class PreHandleResponseVO<T> {
    private Boolean success;

    private String message;

    private Integer code;

    private Optional<T> data;

    public String toJson() {
        return JSONObject.toJSON(this).toString();
    }
}
