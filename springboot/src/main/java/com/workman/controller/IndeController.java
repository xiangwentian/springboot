package com.workman.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndeController {
    @RequestMapping(value = "/index")
    public String index(){
        return "get index success";
    }
}
