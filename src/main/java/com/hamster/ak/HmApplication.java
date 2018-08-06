package com.hamster.ak;

import com.hamster.ak.mapper.HmMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author yanwenbo
 */
@SpringBootApplication
@ComponentScan(basePackageClasses = {HmApplication.class})
@MapperScan(basePackageClasses = {HmMapper.class})
@EnableSwagger2
public class HmApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(HmApplication.class).run(args);
    }

    @Bean
    public Docket swaggerDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(getClass().getPackage().getName())).build();
    }

    @Bean
    public ApiInfo apiInfo(){
        return new ApiInfoBuilder().title("仓鼠记账").version("1.0").build();
    }
}
