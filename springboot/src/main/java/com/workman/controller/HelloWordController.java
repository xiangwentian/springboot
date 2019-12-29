package com.workman.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping
public class HelloWordController {

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){
        log.info("hello word,method index");
        return "hello world";
    }
}
