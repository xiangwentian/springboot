package com.workman.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.security.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "t_logger_infos")
public class LoggerEntity implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ali_id")
    private Long id;
    /** 客户端请求id */
    @Column(name = "ali_client_ip")
    private String clientIp;
    /** 客户端请求路径 */
    @Column(name = "ali_uri")
    private String uri;
    /** 终端请求方式，普通请求，ajax请求*/
    @Column(name = "ali_type")
    private String type;
    /** 请求方式method,post,get等 */
    @Column(name = "ali_method")
    private String method;
    /** 请求参数内容,json */
    @Column(name = "ali_param_data")
    private String paramData;
    /** 请求接口唯一session标识 */
    @Column(name = "ali_session_id")
    private String sessionId;
    /** 请求时间 */
    @Column(name = "ali_time",insertable = false)
    private Timestamp time;
    /** 接口返回时间 */
    @Column(name = "ali_return_time")
    private String returnTime;
    /** 接口返回数据,json */
    @Column(name = "ali_return_data")
    private String returnData;
    /** http返回状态码 */
    @Column(name = "ali_http_status_code")
    private String httpCode;
    /** consuming time */
    @Column(name = "ali_time_consuming")
    private int consuming;
}
