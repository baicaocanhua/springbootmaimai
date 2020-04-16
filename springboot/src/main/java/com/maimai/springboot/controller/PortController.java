package com.maimai.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: all
 * @description: 22
 * @author: zxb
 * @create: 2019-12-10 11:24
 **/
@RestController
@RequestMapping("port")
public class PortController {
    @GetMapping("rr")
    public Map<String, Object> getPort(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>(16);
        map.put("getLocalPort", request.getLocalPort());//8099 8099 8099


        map.put("getRemotePort", request.getRemotePort());//60136 59543 59722
        map.put("getServerPort", request.getServerPort());//8099 80 8099
        map.put("getRemoteHost", request.getRemoteHost()); // 0:0:0:0:0:0:0:1  127.0.0.1 127.0.0.1
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String name=headerNames.nextElement();
            map.put(name, request.getHeader(name));
        }


        return map;
    }
}
