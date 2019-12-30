package com.workman.interceptor;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class SessionInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object o) throws IOException {
        log.info("sessionInterceptor method preHandler start");
        //登录不做拦截
        if(request.getRequestURI().equals("/user/login") || request.getRequestURI().equals("/user/login_view")){
            log.info("登录不做拦截");
            return true;
        }

        //验证session是否存在
        Object obj = request.getSession().getAttribute("session_user");
        log.info("验证session是否存在,obj={}", JSON.toJSONString(obj));
        if(null == obj){
            log.info("obj is null,跳转login_view方法");
            response.sendRedirect("/user/login_view");
            return false;
        }
        log.info("session验证成功，返回true");
        return true;
    }
}
