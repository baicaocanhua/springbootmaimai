package com.maimai.springbootlast.config;

import com.maimai.springbootlast.filter.MyFilter;
import com.maimai.springbootlast.filter.SensitiveWordsFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: springbootmaimai
 * @description:
 * @author: zxb
 * @create: 2020-03-30 15:12
 **/
@Configuration
public class FilterConfig  {

    @Bean
    public FilterRegistrationBean registFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new MyFilter());
        Map<String,String> params=new HashMap<>();
        params.put("name","maimai");
        registration.setInitParameters(params);
        registration.addUrlPatterns("/*");
        registration.setName("MyFilter");
        registration.setOrder(1);
        return registration;
    }
//
//    @Bean
//    public FilterRegistrationBean registSensitiveWordsFilterFilter() {
//        FilterRegistrationBean registration = new FilterRegistrationBean();
//        registration.setFilter(new SensitiveWordsFilter());
//        registration.addUrlPatterns("/*");
//        registration.setName("SensitiveWordsFilter");
//        registration.setOrder(1);
//        return registration;
//    }


}
