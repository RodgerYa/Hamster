package com.hamster.ak.common.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class WebConfig extends WebMvcConfigurationSupport {
  @Autowired
  HmAuthFilter hmAuthFilter;

  @Bean
  public FilterRegistrationBean authControlFilter() {
    FilterRegistrationBean registrationBean = new FilterRegistrationBean();
    registrationBean.setFilter(hmAuthFilter);
    List<String> urlPatterns = new ArrayList<String>();
    urlPatterns.add("/users/*");
    urlPatterns.add("/account/*");
    urlPatterns.add("/bill/*");
    registrationBean.setUrlPatterns(urlPatterns);
    registrationBean.setOrder(10000);
    return registrationBean;
  }
}
