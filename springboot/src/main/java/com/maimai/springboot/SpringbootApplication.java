package com.maimai.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@MapperScan("com.maimai.springboot.dao")
@RestController
public class SpringbootApplication {

    public static void main(String[] args) throws Throwable {
        SpringApplication.run(SpringbootApplication.class, args);
        /*try {
            new ClassPathXmlApplicationContext("test.xml");
        } catch (Exception e) {
            Throwable e1 = e.getCause().getCause().getCause();
            throw e1;
        }*/


        try {
            ClassPathXmlApplicationContext CTX=    new ClassPathXmlApplicationContext("test.xml");
            CTX.setAllowCircularReferences(false);
            System.out.println(CTX.getBean("testA"));
        } catch (Exception e) {
            Throwable e1 = e.getCause().getCause().getCause();
            throw e1;
        }


    }

    @RequestMapping("who")
    public String who() {
        return "springboot";
    }

//    @Bean
//    public FilterRegistrationBean<CsrfFilter> csrfFilter() {
//        FilterRegistrationBean<CsrfFilter> registration = new FilterRegistrationBean<>();
//        registration.setFilter(new CsrfFilter(new HttpSessionCsrfTokenRepository()));
//        registration.addUrlPatterns("/*");
//        registration.setName("csrfFilter");
//        return registration;
//    }

}
