package com.maimai.springbootlast.controller;


import com.alibaba.fastjson.JSON;
import com.maimai.springbootlast.annotation.EagleEye;
import com.maimai.springbootlast.entity.Gril;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * @program: springbootmaimai
 * @description: 1
 * @author: zxb
 * @create: 2020-03-11 16:45
 **/
@RestController
public class HomeController {
    @EagleEye(desc = "测试接口")
    @RequestMapping("get")
    public String getMai() {
        return "maimai";
    }

    public int add(int a,int b) {
        try {
            return a/b;
        }catch(Exception e){
            System.out.println("catch语句块");
        }finally {
            System.out.println("finally语句块");
        }
        return 0;
    }
}
