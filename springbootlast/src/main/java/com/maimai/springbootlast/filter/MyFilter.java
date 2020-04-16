package com.maimai.springbootlast.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;

/**
 * @program: springbootmaimai
 * @description:
 * @author: zxb
 * @create: 2020-03-30 15:11
 **/
//@WebFilter(urlPatterns = "/*", filterName = "logFilter2") //排序方法名根据首字母
public class MyFilter implements Filter {
    private static final Logger LOG= LoggerFactory.getLogger(MyFilter.class);
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        long start = System.currentTimeMillis();
        filterChain.doFilter(servletRequest,servletResponse);
        LOG.info("doFilter");
        //System.out.println("Execute cost="+(System.currentTimeMillis()-start));
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        LOG.info("init");
    }

    @Override
    public void destroy() {
        LOG.info("destroy");
    }
}
