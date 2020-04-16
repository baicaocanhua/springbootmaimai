package com.maimai.springboot.entity;

/**
 * @program: all
 * @description: B
 * @author: zxb
 * @create: 2019-11-27 21:52
 **/
public class TestB {
    private TestC testC;

    public TestC getTestC() {
        return testC;
    }

    public void setTestC(TestC testC) {
        this.testC = testC;
    }

    public void b(){
        testC.c();
    }
}
