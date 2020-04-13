package com.changgou.oauth.bianma;
// 创建一个A对象先执行A中代码块打印1,再执行A构造方法打印2,创建一个B对象,
// 先执行B代码块打印a,再执行父类A的构造方法打印2,在执行B的构造方法打印b
class A {
    static {
        System.out.print("1");
    }

    public A() {
        System.out.print("2");
    }
}

class B extends A {
    static {
        System.out.print("a");
    }

    public B() {
        System.out.print("b");
    }
}

public class Hello {
    public static void main(String[] args) {
        A ab = new A();
        ab = new B();
    }
}