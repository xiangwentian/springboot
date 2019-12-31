package com.workman.jpa;

import com.workman.entity.LoggerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Description 请求日志数据接口
 * @Auth 向问天
 * @Date 2019/12/31 9:30
 * @Version 1.0
 */
public interface LoggerJPA extends JpaRepository<LoggerEntity,Long> {
}
