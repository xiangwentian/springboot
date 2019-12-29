package com.workman.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Slf4j
@Controller
public class IndexController {
    @RequestMapping(value = "index_jsp", method = RequestMethod.GET)
    public String index() {
        log.info("invoke IndexController method index");
        return "index";
    }
}
