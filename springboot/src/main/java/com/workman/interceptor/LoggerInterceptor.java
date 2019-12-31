package com.workman.interceptor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.workman.entity.LoggerEntity;
import com.workman.jpa.LoggerJPA;
import com.workman.util.LoggerUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description 日志处理拦截器
 * @Auth 向问天
 * @Date 2019/12/31 9:32
 * @Version 1.0
 */
@Slf4j
public class LoggerInterceptor implements HandlerInterceptor {

    /**
     * 请求开始时间标识
     */
    private static final String LOGGER_SEND_TIME = "_send_time";
    /**
     * 请求日志实体标识
     */
    private static final String LOGGER_ENTITY = "_logger_entity";

    /**
     * 进入springMvc的controller之前开始记录日志实体
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @return
     * @throws Exception
     */
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        log.info("进入loggerInterceptor方法preHandle方法");
        //创建日志实体
        LoggerEntity logger = new LoggerEntity();
        //获取请求session_id
        String sessionId = httpServletRequest.getRequestedSessionId();
        //请求路径
        String url = httpServletRequest.getRequestURI();
        //获取请求参数
        String paramData = JSON.toJSONString(httpServletRequest.getParameterMap(), SerializerFeature.DisableCircularReferenceDetect, SerializerFeature.WriteMapNullValue);
        //设置客户端ip
        logger.setClientIp(LoggerUtils.getClientIp(httpServletRequest));
        //设置请求方法
        logger.setMethod(httpServletRequest.getMethod());
        //设置请求类型（json|普通请求）
        logger.setType(LoggerUtils.getRequestType(httpServletRequest));
        //设置请求内容json字符串
        logger.setParamData(paramData);
        //设置请求地址
        logger.setUri(url);
        //设置sessionId
        logger.setSessionId(sessionId);
        //设置请求开始时间
        httpServletRequest.setAttribute(LOGGER_SEND_TIME, System.currentTimeMillis());
        //设置请求实体到request内，方面afterCompletioin方法调用
        httpServletRequest.setAttribute(LOGGER_ENTITY, logger);

        return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        try {
            log.info("进入loggerInterceptor方法afterCompletion方法");
            //获取请求获取码
            int status = httpServletResponse.getStatus();
            //当前时间
            long currentTime = System.currentTimeMillis();
            //请求开始时间
            long time = Long.valueOf(httpServletRequest.getAttribute(LOGGER_SEND_TIME).toString());
            //获取本次请求实体
            LoggerEntity loggerEntity = (LoggerEntity) httpServletRequest.getAttribute(LOGGER_ENTITY);
            //设置请求时间差
            loggerEntity.setConsuming(Integer.valueOf((currentTime - time) + ""));
            //设置返回时间
            loggerEntity.setReturnTime(currentTime + "");
            //设置返回错误码
            loggerEntity.setHttpCode(status + "");
            //设置返回值
            loggerEntity.setReturnData(JSON.toJSONString(httpServletRequest.getAttribute(LoggerUtils.LOGGER_RETURN), SerializerFeature.DisableCircularReferenceDetect, SerializerFeature.WriteMapNullValue));
            //执行将日志写入数据库
            log.info("进入loggerInterceptor方法afterCompletion方法,准备调用jpa把日志信息入库,{}", JSON.toJSONString(loggerEntity));
            LoggerJPA loggerJPA = getDao(LoggerJPA.class, httpServletRequest);
            loggerJPA.save(loggerEntity);
        } catch (Exception error) {
            log.error("出异常了", error);
        }
    }


    /**
     * 根据传入的类型获取spring管理对应的bean
     *
     * @param clazz
     * @param request
     * @param <T>
     * @return
     */
    private <T> T getDao(Class<T> clazz, HttpServletRequest request) {
        BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
        return factory.getBean(clazz);
    }

}
