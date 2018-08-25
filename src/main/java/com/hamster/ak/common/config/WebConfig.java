package com.hamster.ak.common.config;

import com.hamster.ak.common.web.CustomFomatterRegistrar;
import com.hamster.ak.common.web.HmInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

  @Autowired
  private HmInterceptor hmInterceptor;

  /**
   * swagger-ui.html 静态资源映射
   */
  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/webjars*")
            .addResourceLocations("classpath:/META-INF/resources/webjars/");
        registry.addResourceHandler("/**").addResourceLocations("classpath:/META-INF/resources/").setCachePeriod(0);
  }

  /**
   * 请求过滤
   */
  @Override
  protected void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(hmInterceptor).addPathPatterns("/**").excludePathPatterns("/api/user/login", "/notify")
            .excludePathPatterns("/swagger-resources/**", "/webjars*/**", "/swagger-ui*/**");
  }

  // TODO @yanwenbo 枚举类型序列化与反序列化 传输过程使用 code
  @Override
  protected void addFormatters(FormatterRegistry registry) {
    new CustomFomatterRegistrar("code").registerFormatters(registry);
  }
}
