package com.workman.controller;

import com.workman.entity.UserEntity;
import com.workman.jpa.UserJPA;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserJPA userJPA;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<UserEntity> list() {
        return userJPA.findAll();
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

    @RequestMapping(value = "/age")
    public List<UserEntity> age() {
        return userJPA.nativeQuery(20);
    }

    @RequestMapping(value = "/deleteWhere")
    public String deleteWhere() {
        userJPA.deleteQuery("workman2", "123456");
        return "自定义sql删除数据成功";
    }

    @RequestMapping(value = "/cutPage")
    public List<UserEntity> cutPage(int page) {
        UserEntity user = new UserEntity();
        user.setSize(2);
        user.setSord("desc");
        user.setPage(page);

        //获取排序对象
        Sort.Direction sort_direction = Sort.Direction.ASC.toString().equalsIgnoreCase(user.getSord()) ? Sort.Direction.ASC : Sort.Direction.DESC;
        //设置排序对象参数
        Sort sort = Sort.by(sort_direction, user.getSidx());
        //创建分页对象
//        PageRequest pageRequest = PageRequest.of(user.getPage() - 1,user.getSize(),Sort.Direction.ASC);
        PageRequest pageRequest = PageRequest.of(user.getPage() - 1, user.getSize(), sort);
        //执行分页查询
        return userJPA.findAll(pageRequest).getContent();
    }
}
