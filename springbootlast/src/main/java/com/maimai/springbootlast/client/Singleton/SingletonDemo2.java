package com.maimai.springbootlast.client.Singleton;

/**
 * @program: springbootmaimai
 * @description:
 * @author: zxb
 * @create: 2020-04-10 14:20
 * 懒汉式(线程安全，调用效率不高，但是能延时加载)：
 **/
public class SingletonDemo2 {
    private static SingletonDemo2 instance=null;
    private SingletonDemo2(){}
    public static synchronized SingletonDemo2 getInstance(){
        if(instance==null){
            instance=new SingletonDemo2();
        }
        return instance;
    }
}
//懒汉式 线程不安全
//public class Singleton {
//    private static Singleton instance;
//    private Singleton (){}
//
//    public static Singleton getInstance() {
//        if (instance == null) {
//            instance = new Singleton();
//        }
//        return instance;
//    }
//}
