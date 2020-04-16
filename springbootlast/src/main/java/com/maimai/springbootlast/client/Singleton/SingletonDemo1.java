package com.maimai.springbootlast.client.Singleton;

import java.io.Serializable;

/**
 * @program: springbootmaimai
 * @description:
 * @author: zxb
 * @create: 2020-04-10 14:14
 * 饿汉式(线程安全，调用效率高，但是不能延时加载)：
 **/
public class SingletonDemo1 implements Serializable {

    private static SingletonDemo1 singletonDemo1=new SingletonDemo1();
    private SingletonDemo1(){}
    public static SingletonDemo1 getInstance(){
        return singletonDemo1;
    }
    public void hell(){
        System.out.println("hell");
    }
}
