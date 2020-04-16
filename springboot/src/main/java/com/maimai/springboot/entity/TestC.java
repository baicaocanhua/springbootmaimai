package com.maimai.springboot.entity;

/**
 * @program: all
 * @description: c
 * @author: zxb
 * @create: 2019-11-27 21:53
 **/
public class TestC {
    private TestA testA;

    public TestA getTestA() {
        return testA;
    }

    public void setTestA(TestA testA) {
        this.testA = testA;
    }

    public void c(){
        testA.a();
    }
}
