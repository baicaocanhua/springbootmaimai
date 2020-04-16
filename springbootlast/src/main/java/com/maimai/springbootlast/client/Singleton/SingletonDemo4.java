package com.maimai.springbootlast.client.Singleton;

/**
 * @program: springbootmaimai
 * @description:
 * @author: zxb
 * @create: 2020-04-10 14:26
 * 静态内部类实现模式（线程安全，调用效率高，可以延时加载）
 **/
public class SingletonDemo4 {
    private static class SingletonClassInstance {
        private static final SingletonDemo4 instance = new SingletonDemo4();
    }

    private SingletonDemo4() {
    }

    public static SingletonDemo4 getInstance() {
        return SingletonClassInstance.instance;
    }
}
