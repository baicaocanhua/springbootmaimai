package com.maimai.springbootlast.filter;

import com.maimai.springbootlast.entity.Gril;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @program: springbootmaimai
 * @description:
 * @author: zxb
 * @create: 2020-03-30 15:11
 **/
//@WebFilter(urlPatterns = "/*", filterName = "logFilter2") //排序方法名根据首字母
public class MyFilter implements Filter {

      String aa="";

    private static final Logger LOG= LoggerFactory.getLogger(MyFilter.class);
    Gril gril=null;
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        long start = System.currentTimeMillis();


       try {
           gril.getName();
       }catch (Exception e){
           LOG.info(e.getMessage());
       }

        HttpServletRequest request= (HttpServletRequest) servletRequest;
        StringBuffer url = request.getRequestURL();
        String tempContextUrl = url.delete(url.length() - request.getRequestURI().length(), url.length()).append("/").toString();
        System.out.println(tempContextUrl);
        filterChain.doFilter(servletRequest,servletResponse);
        LOG.info("doFilter");
        //System.out.println("Execute cost="+(System.currentTimeMillis()-start));
        aa="444";
        LOG.info(aa);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        aa="123";
        String excludeUrl = filterConfig.getInitParameter("name");
        System.out.println("1111111111111"+excludeUrl);
        LOG.info("init");
    }

    @Override
    public void destroy() {
        LOG.info("destroy");
    }
}
