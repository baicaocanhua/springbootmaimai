package com.maimai.springbootlast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

import java.util.concurrent.ConcurrentHashMap;

@SpringBootApplication
@EnableRedisHttpSession
@EnableJms
public class SpringbootlastApplication {


    public static void main(String[] args) {
        SpringApplication.run(SpringbootlastApplication.class, args);
    }


}
