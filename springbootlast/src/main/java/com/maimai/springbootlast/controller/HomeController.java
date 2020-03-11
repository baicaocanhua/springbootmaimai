package com.maimai.springbootlast.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: springbootmaimai
 * @description: 1
 * @author: zxb
 * @create: 2020-03-11 16:45
 **/
@RestController
public class HomeController {
    @RequestMapping("get")
    public String getMai(){
        return "maimai";
    }
}
