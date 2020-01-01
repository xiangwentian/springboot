package com.workman.jpa;

import com.workman.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Transactional
public interface UserJPA extends JpaRepository<UserEntity, Long>, JpaSpecificationExecutor<UserEntity>, Serializable {
    //查询大于20岁的用户
    @Query(value = "select * from t_user where t_age>?1", nativeQuery = true)
    public List<UserEntity> nativeQuery(int age);

    //@Transactional
    @Modifying
    @Query(value = "delete from t_user where t_name=?1 and t_pwd=?2",nativeQuery = true)
    public void deleteQuery(String name,String pwd);
}
