package com.maimai.springboot.entity;

public class Student {

    private int a;
    private int b;

    public int getA() {
        return a + b;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        b = b + 10;
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public static void main(String[] args) {
        Student student = new Student();
        student.setA(1);
        student.setB(1);
        //System.out.println(student.getB());
        System.out.println(student.getA());
//        System.out.println(student.getA()+student.getB());
    }
}
