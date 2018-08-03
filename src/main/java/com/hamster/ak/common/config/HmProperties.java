package com.hamster.ak.common.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "hamster")
@Component
@Data
public class HmProperties {

    private Integer expiryTime;
}
