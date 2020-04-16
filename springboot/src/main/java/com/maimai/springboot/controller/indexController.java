package com.maimai.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @program: all
 * @description:
 * @author: zxb
 * @create: 2019-12-11 14:21
 **/
@Controller
public class indexController {
    @GetMapping("index")
    public  String index(){
        return "index";
    }
}
