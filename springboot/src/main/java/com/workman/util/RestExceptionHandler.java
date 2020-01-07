package com.workman.util;

import org.springframework.web.bind.annotation.*;

/**
 * @Description TODO
 * @Auth 向问天
 * @Date 2020/1/7 17:06
 * @Version 1.0
 */
@ControllerAdvice(annotations = RestController.class)
@ResponseBody
public class RestExceptionHandler {
    /**
     * 默认统一异常处理方法
     * @param e 默认Exception异常对象
     * @return
     */
    @ExceptionHandler
    @ResponseStatus
    public ApiResult runtimeExceptionHandler(Exception e) {
        return ApiResultGenerator.errorResult(e.getMessage(),e);
    }

}
