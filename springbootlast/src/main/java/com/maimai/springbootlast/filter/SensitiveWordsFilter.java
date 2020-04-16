package com.maimai.springbootlast.filter;


import com.alibaba.fastjson.JSON;
import com.maimai.springbootlast.annotation.EagleEye;

import javax.servlet.*;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: springbootmaimai
 * @description:
 * @author: zxb
 * @create: 2020-03-30 16:30
 **/
public class SensitiveWordsFilter implements Filter {
    private List<String> list = new ArrayList<>();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        ServletRequest proxy_request = (ServletRequest) Proxy.newProxyInstance(servletRequest.getClass().getClassLoader(),
                servletRequest.getClass().getInterfaces(), new InvocationHandler() {

                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //判断是否是getParameter方法
                        EagleEye eagleEye=   method.getAnnotation(EagleEye.class);
                        System.out.println("111111"+method.getName());

                        if (method.getName().equals("getParameter")) {
                            //增强返回值，获取返回值
                            String value = (String) method.invoke(servletRequest, args);
                            if (value != null) {
                                for (String str : list) {
                                    if (value.contains(str)) {
                                        value = value.replaceAll(str, "***");
                                    }
                                }
                            }
                            return value;
                        }
                        return method.invoke(servletRequest, args);
                    }
                });
        //过滤器放行
        filterChain.doFilter(proxy_request, servletResponse);

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        list.add("maimai");
    }

    @Override
    public void destroy() {

    }
}
