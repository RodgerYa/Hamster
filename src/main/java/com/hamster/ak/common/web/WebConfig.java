package com.hamster.ak.common.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

  @Autowired
  private HmInterceptor hmInterceptor;

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    // swagger-ui.html 静态资源映射
    registry.addResourceHandler("/webjars*")
            .addResourceLocations("classpath:/META-INF/resources/webjars/");
        registry.addResourceHandler("/**").addResourceLocations("classpath:/META-INF/resources/").setCachePeriod(0);
  }

  @Override
  protected void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(hmInterceptor).addPathPatterns("/**").excludePathPatterns("/api/user/login")
            .excludePathPatterns("/swagger-resources/**", "/webjars*/**", "/swagger-ui*/**");
  }
}
