package com.maimai.springboot.controller;

import com.maimai.springboot.dao.CronMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.TimeZone;

@RestController
@RequestMapping("maimai")
public class WhoController {


    @RequestMapping("/infoAdd/{data:.+}")
    public String dosth(@PathVariable("data") String data) {
        return data;
    }

    @GetMapping(value = "/user/{useraccount:[a-zA-Z0-9.-_;\\/]+}")
    public String getUserAccount(@PathVariable("useraccount") String userAccount) {
        return userAccount;
    }


    @RequestMapping(value = "/tags/**")
    public String tags(HttpServletRequest request) {
// ISO-8859-1 ==> UTF-8 进行编码转换
        String tagname = extractPathFromPattern(request);
        return  tagname;
    }

    // 把指定URL后的字符串全部截断当成参数
// 这么做是为了防止URL中包含中文或者特殊字符（/等）时，匹配不了的问题
    private static String extractPathFromPattern(
            final HttpServletRequest request) {
        String path = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
        String bestMatchPattern = (String) request.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE);
        return new AntPathMatcher().extractPathWithinPattern(bestMatchPattern, path);
    }


    @RequestMapping("mm")
    public String dosth() {
        return "mm";
    }

    @RequestMapping("who")
    public String who() {
        return "maimai-who";
    }

    @Autowired
    CronMapper cronMapper;


    @RequestMapping("getcron")
    public String getcron() {
        return cronMapper.getCron(1);
    }

    public static void main(String[] args) {

        TimeZone timeZone = TimeZone.getTimeZone("America/Mexico_City");
        TimeZone.setDefault(timeZone); //多了这一行
        //Calendar calendar = Calendar.getInstance(timeZone);

        Calendar calendar = Calendar.getInstance();
        System.out.println("目前时间：" + calendar.getTime());
        System.out.println("Calendar时区：：" + calendar.getTimeZone().getID());
        System.out.println("user.timezone：" + System.getProperty("user.timezone"));
        System.out.println("user.country：" + System.getProperty("user.country"));
        System.out.println("默认时区：" + TimeZone.getDefault().getID());

        new Thread(() -> {
            System.out.println(123);
        });
    }
}
