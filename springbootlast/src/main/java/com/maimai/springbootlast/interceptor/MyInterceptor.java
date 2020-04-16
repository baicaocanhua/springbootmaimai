package com.maimai.springbootlast.interceptor;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;
import java.lang.reflect.Parameter;

/**
 * @program: springbootmaimai
 * @description:
 * @author: zxb
 * @create: 2020-03-30 15:05
 **/
@Component
//extends HandlerInterceptorAdapter
public class MyInterceptor implements HandlerInterceptor {
    private static final Logger LOG = LoggerFactory.getLogger(MyInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        LOG.info("执行拦截器的preHandle方法");
        //获取控制器的名字
        System.out.println(((HandlerMethod) handler).getBean().getClass().getName());
        //获取方法名
        System.out.println(((HandlerMethod) handler).getMethod().getName());

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        LOG.info("执行拦截器的postHandle方法");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        LOG.info("执行拦截器的afterCompletion方法");
    }
}
