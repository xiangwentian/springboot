package com.workman.controller;

import com.alibaba.fastjson.JSONObject;
import com.workman.entity.UserEntity;
import com.workman.jpa.UserJPA;
import com.workman.util.LoggerUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping(value = "/user")
public class LoginController {

    @Autowired
    private UserJPA userJPA;

    @RequestMapping("/login")
    public String login(UserEntity user, HttpServletRequest request) {
        log.info("invoke LoginController login method");
        String result = "登录成功";
        JSONObject obj = new JSONObject();
        Optional<UserEntity> userOpt = userJPA.findOne(new Specification<UserEntity>() {
            @Override
            public Predicate toPredicate(Root<UserEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                criteriaQuery.where(criteriaBuilder.equal(root.get("name"), user.getName()));
                return null;
            }
        });
        //user不存在
        if (userOpt == null) {
            obj.put("msg", "用户:" + user.getName() + ",登录失败,user查询为空！");
            request.setAttribute(LoggerUtils.LOGGER_RETURN, obj);
            return "用户不存在，登录失败";
        }//密码错误
        else if (!userOpt.get().getPwd().equals(user.getPwd())) {
            obj.put("msg", "用户:" + user.getName() + ",登录失败,用户密码不正确！");
            request.setAttribute(LoggerUtils.LOGGER_RETURN, obj);
            return "用户密码不正确，登录失败";
        }
        //到这里已经是登录成功的用户了，加session
        request.getSession().setAttribute("session_user", userOpt.get());
        obj.put("msg", "用户:" + user.getName() + ",登录成功！");
        request.setAttribute(LoggerUtils.LOGGER_RETURN, obj);
        return result;
    }
}
