package com.maimai.springbootlast.client;

import com.alibaba.fastjson.JSON;
import com.maimai.springbootlast.entity.Gril;

import java.lang.reflect.Field;

/**
 * @program: springbootmaimai
 * @description:
 * @author: zxb
 * @create: 2020-03-31 11:07
 **/
public class Reflect {
    public static <T> void get(T t) {
        System.out.println(123);
        Class<?> clazz = t.getClass();
        Field[] fields = clazz.getFields();
        for (Field field : fields) {

            System.out.println(JSON.toJSONString(field));
        }
    }

    public static void main(String[] args) {
        Gril g = new Gril();
        g.setName("g1");
        g.setId(1);
        get(g);
        get(Gril.class);
    }
}
