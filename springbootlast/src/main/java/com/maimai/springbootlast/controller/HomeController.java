package com.maimai.springbootlast.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.maimai.springbootlast.annotation.EagleEye;
import com.maimai.springbootlast.entity.Gril;
import com.maimai.springbootlast.entity.Grils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    public String getMai(HttpServletRequest request, HttpServletResponse response) {

        String name=request.getParameter("name");
        HttpSession session = request.getSession(true);
        Cookie cookie = new Cookie("huhu", "123");
        cookie.setMaxAge(Integer.MAX_VALUE); // 设置生命周期为MAX_VALUE
        response.addCookie(cookie); // 输出到客户端
        name="12355552222";
        name="wowowo";
        System.out.println(123);
        System.out.println(name);
        //return session;
        return name;
    }


    public static void main(String[] args) {

        List<Grils> grilsList = new ArrayList<>(16);

        Grils grils = new Grils();
        grils.setId(1);

        Gril g1 = new Gril();
        g1.setId(1);
        g1.setName("name1");
        Gril g2 = new Gril();
        g2.setId(2);
        g2.setName("name2");
        List<Gril> grilList1 = new ArrayList<>(8);
        grilList1.add(g1);
        grilList1.add(g2);

        grils.setGrilList(grilList1);
        grilsList.add(grils);


        Grils grils1 = new Grils();
        grils1.setId(2);

        Gril g3 = new Gril();
        g3.setId(3);
        g3.setName("name3");
        Gril g4 = new Gril();
        g4.setId(4);
        g4.setName("name4");
        List<Gril> grilList2 = new ArrayList<>(8);
        grilList2.add(g3);
        grilList2.add(g4);

        grils1.setGrilList(grilList2);
        grilsList.add(grils1);


        List<String> list = grilsList.stream().map(x -> x.getGrilList())
                .flatMap(z->z.stream())
                .map(y -> y.getName()).
                        collect(Collectors.toList());
        System.out.println(JSON.toJSONString(list));

        String[] words = {"Hello", "World"};

        //{h,e,l,l,o},{W,o,r,l,d}
        Stream<String[]> stream = Arrays.stream(words).map(w -> w.split(""));//Stream<String[]>

        //H,e,l,l,o,W,o,r,l,d
        Stream<String> stringStream = stream.flatMap(x-> Arrays.stream(x));

        stringStream.distinct().forEach(System.out::println);

    }


}
