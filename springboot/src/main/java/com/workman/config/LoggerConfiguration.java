package com.workman.config;

import com.workman.interceptor.LoggerInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Description TODO
 * @Auth 向问天
 * @Date 2019/12/31 10:54
 * @Version 1.0
 */
@Slf4j
@Configuration
public class LoggerConfiguration extends WebMvcConfigurerAdapter {
    public void addInterceptors(InterceptorRegistry registry) {
        log.info("进入LoggerInterceptor的addInterceptor方法");
        registry.addInterceptor(new LoggerInterceptor()).addPathPatterns("/**");
    }
}
