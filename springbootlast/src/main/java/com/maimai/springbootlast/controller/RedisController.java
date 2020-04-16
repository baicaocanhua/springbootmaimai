package com.maimai.springbootlast.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.session.Session;
import org.springframework.session.SessionRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: springbootmaimai
 * @description:
 * @author: zxb
 * @create: 2020-04-15 09:32
 **/
@RestController
@RequestMapping("sessionRedis")
public class RedisController {
    @RequestMapping("/set")
    String set(HttpServletRequest req) {
        req.getSession().setAttribute("testKey", "testValue");
        return "设置session:testKey=testValue";
    }

    @RequestMapping("/query")
    String query(HttpServletRequest req) {
        Object value = req.getSession().getAttribute("testKey");
        return "查询Session：\"testKey\"=" + value;
    }

    @RequestMapping(value = "/setSession")
    public Map<String, Object> setSession (HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
        request.getSession().setAttribute("message", request.getRequestURL());
        map.put("request Url", request.getRequestURL());
        return map;
    }

    @RequestMapping(value = "/getSession")
    public Object getSession (HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
        map.put("sessionId", request.getSession().getId());
        map.put("message", request.getSession().getAttribute("message"));
        return map;
    }


    @RequestMapping(value = "/login")
    public String login (HttpServletRequest request,String userName,String password){
        String msg="logon failure!";

        if (userName!=null && "admin".equals(userName) && "123".equals(password)){
            request.getSession().setAttribute("user",userName);
            msg="login successful!";
        }
        return msg;
    }

    @Autowired
    SessionRepository sessionRepository;
    //@RequestMapping(value = "/login")
    public  Session tt(HttpServletRequest request){
        String id=request.getSession().getId();
        Session session= sessionRepository.findById(id);
         return session;
    }

}
