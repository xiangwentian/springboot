package com.workman.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Auth 向问天
 * @Date 2020/1/7 17:05
 * @Version 1.0
 */
@RestController
public class IndexController {
    @RequestMapping(value = "/index/{number}")
    public String index(@PathVariable int number){
        System.out.println(20 / number);
        return "get index page successfully.";
    }
}
