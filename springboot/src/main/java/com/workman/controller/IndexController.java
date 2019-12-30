package com.workman.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Slf4j
@Controller
@RequestMapping("/user")
public class IndexController {

    @RequestMapping(value = "/login_view", method = RequestMethod.GET)
    public String login_view() {
        log.info("invoke indexController login_view method");
        return "login";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        log.info("invoke indexController index method");
        return "index";
    }

}
