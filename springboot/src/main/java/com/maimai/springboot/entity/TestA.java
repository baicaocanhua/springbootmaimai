package com.maimai.springboot.entity;

/**
 * @program: all
 * @description: a
 * @author: zxb
 * @create: 2019-11-27 21:52
 **/
public class TestA {
    private TestB testB;
    public void a(){
        testB.b();
    }

    public TestB getTestB() {
        return testB;
    }

    public void setTestB(TestB testB) {
        this.testB = testB;
    }
}
