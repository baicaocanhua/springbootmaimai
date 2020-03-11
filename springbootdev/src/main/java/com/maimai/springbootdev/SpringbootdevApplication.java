package com.maimai.springbootdev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpringbootdevApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootdevApplication.class, args);

		
	}

    @RequestMapping("/")
    public String index(){
        return "欢迎访问 springboot-aop";
    }

}
