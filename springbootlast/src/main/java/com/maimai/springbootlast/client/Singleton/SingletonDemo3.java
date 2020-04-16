package com.maimai.springbootlast.client.Singleton;

/**
 * @program: springbootmaimai
 * @description:
 * @author: zxb
 * @create: 2020-04-10 14:23
 * Double CheckLock实现单例：DCL也就是双重锁判断机制（由于JVM底层模型原因，偶尔会出问题，不建议使用）：
 **/
public class SingletonDemo3 {
    private volatile  static SingletonDemo3 singletonDemo3=null;
    private SingletonDemo3(){}
    public static SingletonDemo3 getInstance(){
        if(singletonDemo3==null){
            synchronized (SingletonDemo3.class){
                if(singletonDemo3==null){
                    singletonDemo3=new SingletonDemo3();
                }
            }
        }
        return singletonDemo3;
    }
}
