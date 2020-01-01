package com.workman.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Sort;

import java.io.Serializable;

/**
 * @Description TODO
 * @Auth 向问天
 * @Date 2020/1/1 15:38
 * @Version 1.0
 */
@Getter
@Setter
public class BaseEntity implements Serializable {
    /**
     *分页页码，默认1
     */
    protected int page = 1;
    /**
     *每页条数，默认20
     */
    protected int size = 20;
    /**
     * 排序名称，默认id
     */
    protected String sidx = "id";
    /**
     *排序，默认正序
     */
    protected String sord = "asc";
}
