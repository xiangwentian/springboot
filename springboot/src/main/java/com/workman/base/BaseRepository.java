package com.workman.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * @Description jpa基类
 * @Auth 向问天
 * @Date 2020/1/1 15:37
 * @Version 1.0
 */
@NoRepositoryBean
public interface BaseRepository<T,PK extends Serializable> extends JpaRepository<T,PK> {
}
