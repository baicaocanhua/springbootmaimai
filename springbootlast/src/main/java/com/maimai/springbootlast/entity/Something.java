package com.maimai.springbootlast.entity;

import org.aspectj.weaver.ast.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @program: springbootmaimai
 * @description:
 * @author: zxb
 * @create: 2020-04-01 11:53
 **/
public class Something {
    // constructor methods
    Something() {
    }

    Something(String something) {
        System.out.println(something);
    }

    // static methods
    static String startsWith(String s) {
        return String.valueOf(s.charAt(0));
    }

    // object methods
    String endWith(String s) {
        return String.valueOf(s.charAt(s.length() - 1));
    }

    public static void printValur(String str) {
        System.out.println("print value : " + str);
    }

    public static void main(String[] args) {
        List<String> al = Arrays.asList("a", "b", "c", "d");
        al.forEach(Something::printValur);
        // 下面的方法和上面等价的
        Consumer<String> methodParam = Something::printValur; // 方法参数
        al.forEach(x -> methodParam.accept(x));// 方法执行accept
        //JAVA 8 '::' 关键字
        //https://blog.csdn.net/kegaofei/article/details/80582356
        //Java中::用法
        //https://blog.csdn.net/qq_27389705/article/details/89083963
        IConvert<String, String> convert = Something::startsWith;
        String converted = convert.convert("123");
        System.out.println(converted);
    }


}
