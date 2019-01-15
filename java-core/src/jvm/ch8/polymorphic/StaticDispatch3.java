package jvm.ch8.polymorphic;

public class StaticDispatch3 {

    static abstract class Human {
    }

    static class Man extends Human {
    }

    static class Woman extends Human {
    }

    public void sayHello(Human h) {
        System.out.println("Hello, guy");
    }

    public void sayHello(Man m) {
        System.out.println("Hello, gentleman");
    }

    public void sayHello(Woman w) {
        System.out.println("Hello, lady");
    }

    public static void main(String[] args) {
        StaticDispatch3 sd = new StaticDispatch3();
        Human man = new Man();
        Human woman = new Woman();
        sd.sayHello((Man) man);
        sd.sayHello((Woman) woman);
    }

}
