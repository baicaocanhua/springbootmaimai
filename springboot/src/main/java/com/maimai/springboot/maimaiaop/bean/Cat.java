package com.maimai.springboot.maimaiaop.bean;

import org.springframework.stereotype.Component;

@Component
public class Cat implements Animal {
    @Override
    @Cache(60)
    public String sayName(String name, Integer num) {
        return "this is cat " + name + "," + num;
    }
}
