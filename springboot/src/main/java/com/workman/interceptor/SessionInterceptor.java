package com.workman.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SessionInterceptor implements HandlerInterceptor {
    public boolean preHandler(HttpServletRequest request, HttpServletResponse response,Object o) throws IOException {
        //登录不做拦截
        if(request.getRequestURI().equals("/user/login") || request.getRequestURI().equals("/user/login_view")){
            return true;
        }

        //验证session是否存在
        Object obj = request.getSession().getAttribute("session_user");
        if(null == obj){
            response.sendRedirect("/user/login_view");
            return false;
        }
        return true;
    }
}
