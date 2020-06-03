package com.maimai.springbootlast.entity;

/**
 * @program: springbootmaimai
 * @description:
 * @author: zxb
 * @create: 2020-05-15 15:55
 **/

public class SynchronizedMethod {
    private int sum;

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public void calculate() {
        setSum(getSum() + 1);
    }
    public synchronized void synchronizedCalculate() {
        setSum(getSum() + 1);
    }
}
