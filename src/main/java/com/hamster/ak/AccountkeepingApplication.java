package com.hamster.ak;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author yanwenbo
 */
@SpringBootApplication
@EnableSwagger2
public class AccountkeepingApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(AccountkeepingApplication.class)
                .properties("spring.jackson.date-format=yyyy-MM-dd HH:mm:ss")
                .properties("spring.jackson.time-zone=GMT+8")
                .properties("spring.jackson.serialization.WRITE_NULL_MAP_VALUES=true")
                .run(args);
    }

    @Bean
    public Docket swaggerDocket() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage(getClass().getName())).build();
    }
}
