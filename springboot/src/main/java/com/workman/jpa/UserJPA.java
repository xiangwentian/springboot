package com.workman.jpa;

import com.workman.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

public interface UserJPA extends JpaRepository<UserEntity, Long>{
    //使用jpa自定义查询
    public UserEntity findByUsername(String name);
}
