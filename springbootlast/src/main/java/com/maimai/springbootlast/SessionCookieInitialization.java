package com.maimai.springbootlast;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.SessionCookieConfig;
import javax.servlet.annotation.WebListener;

/**
 * @program: springbootmaimai
 * @description:
 * @author: zxb
 * @create: 2020-03-26 15:36
 **/
//全局设置Session-Cookie相交互部分属性
@WebListener
public class SessionCookieInitialization implements ServletContextListener {
    private static final Log log = LogFactory.getLog(SessionCookieInitialization.class);
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("now init the Session Cookie");

        ServletContext servletContext = sce.getServletContext();

        SessionCookieConfig sessionCookie = servletContext
                .getSessionCookieConfig();
        sessionCookie.setName("YONGBOYID");
        sessionCookie.setPath(servletContext.getContextPath());
        sessionCookie.setHttpOnly(true);
        sessionCookie.setSecure(false);

        log.info("name : " + sessionCookie.getName() + "\n" + "domain:"
                + sessionCookie.getDomain() + "\npath:"
                + sessionCookie.getPath() + "\nage:"
                + sessionCookie.getMaxAge());

        log.info("isHttpOnly : " + sessionCookie.isHttpOnly());
        log.info("isSecure : " + sessionCookie.isSecure());
    }
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("the context is destroyed !");
    }
}
