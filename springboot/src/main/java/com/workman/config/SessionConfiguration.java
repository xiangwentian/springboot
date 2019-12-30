package com.workman.config;

import com.workman.interceptor.SessionInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Slf4j
@Configuration
public class SessionConfiguration extends WebMvcConfigurerAdapter {
    //@Override
    public void addInterceptors(InterceptorRegistry registry) {
        log.info("进入SessionConfiguration的addInterceptor方法");
        registry.addInterceptor(new SessionInterceptor()).addPathPatterns("/**");
    }
}
