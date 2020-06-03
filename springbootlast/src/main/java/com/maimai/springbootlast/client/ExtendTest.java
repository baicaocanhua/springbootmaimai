package com.maimai.springbootlast.client;

/**
 * @program: springbootmaimai
 * @description:
 * @author: zxb
 * @create: 2020-04-21 16:39
 **/
class A{
    static{
        System.out.println("A static");
    }
}
class B extends A{
    static{
        System.out.println("B static");
    }
}
class C extends B{
    private  D d = new D();
    static{
        System.out.println("C static");
    }
}
class D{
    static{
        System.out.println("D static");
    }
}
public class ExtendTest {
    public static void main(String[] args) {
        C c = new C();
    }
}
