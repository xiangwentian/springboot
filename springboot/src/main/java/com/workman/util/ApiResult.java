package com.workman.util;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Description TODO
 * @Auth 向问天
 * @Date 2020/1/7 16:52
 * @Version 1.0
 */
@Getter
@Setter
public class ApiResult implements Serializable {
    //禁止创建对象
    private ApiResult(){}

    public static ApiResult newInstance(){return new ApiResult();}

    //消息提醒
    private String msg;
    //状态信息
    private boolean flag = true;
    //返回结构
    private Object result;
    //查看出的结构总数
    private int rows;
    //需要跳转的路径
    private String jumpUrl;
    //接口响应时间毫秒单位
    private long time;

    @Override
    public String toString(){return JSON.toJSONString(this);}
}
