package com.mengyunzhi.springmvc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Creat by xulinjie 09.20
 */
@RestController
public class HelloController {

    //设置该方法为一个触发器，并设置该触发器对应的路由信息"/"
    @RequestMapping("/")
    public String word(){
        return "HEllo world";
    }
}
