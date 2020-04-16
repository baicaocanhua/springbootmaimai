package com.maimai.ueditor.controller;

import com.baidu.ueditor.ActionEnter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

/**
 * @program: all
 * @description: ueditor
 * @author: zxb
 * @create: 2019-11-09 15:37
 **/
@RestController
public class UeditorController {
    @RequestMapping("/ueditorImg")
    public String a(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding( "utf-8" );
        //response.setHeader("Content-Type" , "text/html");
        String fileDir = request.getServletContext().getRealPath("/");
        return new ActionEnter( request, fileDir ).exec();
    }
}
