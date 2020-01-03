package com.workman.controller;

import com.alibaba.fastjson.JSON;
import com.workman.entity.UserEntity;
import com.workman.jpa.UserJPA;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    UserJPA userJPA;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<UserEntity> list() {
        List<UserEntity> list = null;
        List<UserEntity> cacheResult = (List<UserEntity>)redisTemplate.opsForValue().get("list");
        log.info("get value from cache,cacheResult={}", JSON.toJSONString(cacheResult));
        if(null == cacheResult){
            log.info("redis not have value,get value from db");
            list = userJPA.findAll();
            redisTemplate.opsForValue().set("list",list);
        }else{
            list = cacheResult;
        }
        return list;
    }

    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public UserEntity save(UserEntity userEntity) {
        return userJPA.save(userEntity);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public List<UserEntity> delete(Long id) {
        userJPA.deleteById(id);
        return userJPA.findAll();
    }
}
