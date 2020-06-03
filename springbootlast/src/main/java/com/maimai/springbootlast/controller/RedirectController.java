package com.maimai.springbootlast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @program: springbootmaimai
 * @description:
 * @author: zxb
 * @create: 2020-04-28 14:57
 **/
//SpringBoot系列: url重定向和转发
//https://www.cnblogs.com/harrychinese/p/SpringBoot_redirect_and_forward.html
@Controller
public class RedirectController {

    @RequestMapping(value = "/testredirect", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView testredirect(HttpServletResponse response, HttpServletRequest request) throws IOException {
        response.sendRedirect("/index?id=1");
        request.setAttribute("name", "maimai");
        return null;
    }

    @RequestMapping(value = "/index", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView index(HttpServletRequest request) throws IOException {

        String id = request.getParameter("id");
        System.out.println(id);
        String name = request.getAttribute("name").toString();
        System.out.println(name);
        Enumeration<String> parameterNames = request.getParameterNames();
//        while (parameterNames.hasMoreElements()){
//
//        }


        for(Enumeration e=parameterNames;e.hasMoreElements();){

            String thisName=e.nextElement().toString();
            String thisValue=request.getParameter(thisName);
            System.out.println(thisName+"--------------"+thisValue);
        }
        Enumeration<String> attributeNames = request.getAttributeNames();
        System.out.println("-------------------");
        for(Enumeration e=attributeNames;e.hasMoreElements();){

            String thisName=e.nextElement().toString();
            Object thisValue=request.getAttribute(thisName);
            System.out.println(thisName+"--------------"+thisValue);
        }
        return null;
    }

    @RequestMapping("/testredirect1")
    public String testredirect1(Model model, RedirectAttributes attr) {
        attr.addAttribute("test", "51gjie");//跳转地址带上test参数
        attr.addFlashAttribute("u2", "51gjie");//跳转地址不带上u2参数
        return "redirect:/users";
    }

    @RequestMapping(value = "/users", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView users(HttpServletRequest request) throws IOException {

        String id = request.getParameter("id");
        System.out.println(id);
        String name = request.getAttribute("name").toString();
        System.out.println(name);
        return null;
    }

    @RequestMapping("/forwardTest1")
    public String forwardTest1(HttpServletRequest request) {
        request.setAttribute("name", "maimai");
        return "forward:/index?param1=v1&param2=v2";
    }

    private String wowo="123";
    @RequestMapping("/wowo")

    @ResponseBody
    public String wowo(String id){
        if("1".equals(id)){
            wowo="234";
        }
        return wowo;
    }
}
