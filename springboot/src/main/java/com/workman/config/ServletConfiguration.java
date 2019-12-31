package com.workman.config;

import com.workman.servlet.TestServlet;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description TODO
 * @Auth 向问天
 * @Date 2019/12/31 14:53
 * @Version 1.0
 */
@Configuration
public class ServletConfiguration {

    @Bean
    public ServletRegistrationBean servletRegistrationBean()
    {
        return new ServletRegistrationBean(new TestServlet(),"/test");
    }
}
