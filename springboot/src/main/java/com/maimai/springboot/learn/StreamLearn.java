package com.maimai.springboot.learn;

import com.maimai.springboot.entity.Person;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class StreamLearn {


    public  void t1(){
        List<Person> list = new ArrayList<>();
        list.add(new Person("jack", 20));
        list.add(new Person("mike", 25));
        list.add(new Person("tom", 30));

        list = list.stream()
                .sorted((p1, p2) -> p1.getAge() - p2.getAge())
                .collect(toList());
    }

}
