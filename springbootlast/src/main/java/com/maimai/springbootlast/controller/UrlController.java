package com.maimai.springbootlast.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: springbootmaimai
 * @description:
 * @author: zxb
 * @create: 2020-04-24 14:25
 **/
@RequestMapping("url")
@RestController
public class UrlController {
    @RequestMapping("url")
    public Map<String, Object> get(@RequestParam("id") String id, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        map.put("getRequestURI", request.getRequestURI());
        map.put("getRequestURL", request.getRequestURL());
        map.put("ppmcloud-Host", request.getHeader("ppmcloud-Host"));
        map.put("ppmcloud-Host111", request.getHeader("ppmcloud-Host111"));
        map.put("getRemoteAddr", request.getRemoteAddr());
        map.put("getServletPath", request.getServletPath());
        map.put("getLocale", request.getLocale());
        map.put("getLocalAddr", request.getLocalAddr());
        map.put("getLocalName", request.getLocalName());
        map.put("getScheme", request.getScheme());
        map.put("getContextPath", request.getContextPath());
        map.put("getPathInfo", request.getPathInfo());
        map.put("getRemoteHost", request.getRemoteHost());
        map.put("getServerName", request.getServerName());
        final String a;
        if("aa".equals(id)){
            a="aa";
        }else {
            a="bb";
        }
        map.put("a", a);
        return map;
    }
}
