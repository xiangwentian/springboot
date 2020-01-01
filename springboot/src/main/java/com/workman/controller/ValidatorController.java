package com.workman.controller;

import com.workman.entity.ValidatorDemoEntity;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

/**
 * @Description TODO
 * @Auth 向问天
 * @Date 2020/1/1 19:48
 * @Version 1.0
 */
@Slf4j
@RestController
public class ValidatorController {

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = "/validator")
    public String validator(@Valid ValidatorDemoEntity entity, BindingResult result) {
        log.info("进入validator方法");
        if (result.hasErrors()) {
            StringBuilder msg = new StringBuilder();
            //获取错误字段集合
            List<FieldError> fieldErrors = result.getFieldErrors();
            //获取本地cache,zh_CN
            Locale currentLocale = LocaleContextHolder.getLocale();
            //遍历错误字段获取错误消息
            for (FieldError fieldError : fieldErrors) {
                //获取错误消息
                String errorMessage = messageSource.getMessage(fieldError, currentLocale);
                //添加到错误集合
                msg.append(fieldError.getField() + ":" + errorMessage + ",");
            }
            log.info("msg:" + msg.toString());
            return msg.toString();
        }
        return "验证通过:" + "名称:" + entity.getName() + ",年龄:" + entity.getAge() + ",邮箱地址:" + entity.getMail();
    }

}
